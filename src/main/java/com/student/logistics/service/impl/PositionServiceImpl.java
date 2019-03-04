package com.student.logistics.service.impl;

import com.student.logistics.pojo.po.PositionPo;
import com.student.logistics.pojo.vo.PositionVo;
import com.student.logistics.repository.DeptRepository;
import com.student.logistics.repository.PositionRepository;
import com.student.logistics.repository.UserRepository;
import com.student.logistics.service.PositionService;
import com.student.logistics.utils.DTOConverterUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhongLiang.Xian
 * @ description:
 * @ date: 2019/3/2.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository repository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DeptRepository deptRepository;
    private DTOConverterUtils<PositionPo, PositionVo> converterUtils = new DTOConverterUtils<>(PositionPo.class, PositionVo.class);
    @Override
    public void addPosition(PositionVo vo) {
        //属性转换
        PositionPo positionPo = converterUtils.toPO(vo);
        repository.save(positionPo);
    }

    @Override
    public void deletePosition(Integer id) {
        //删除岗位，需将此岗位下的人员的岗位信息清空
        userRepository.updatePosition(id);
        repository.deleteById(id);
    }

    @Override
    public void updatePosition(PositionVo vo) {
        repository.findById(vo.getId()).ifPresent( po -> {
            if (!StringUtils.isEmpty(vo.getName())){
                po.setName(vo.getName());
            }
        });
    }

    @Override
    public List<PositionVo> findByCondition(PositionVo condition) {
        return this.findPosition(condition);
    }

    @Override
    public XSSFWorkbook exportExcel() {
        List<PositionVo> vos = this.findPosition(new PositionVo());
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet sheet = xssfWorkbook.createSheet("岗位报表");
        //创建行
        XSSFRow row = sheet.createRow(0);
        String[] columnsName = { "岗位名", "所属部门", "部门负责人" };
        //创建第一行的头信息
        for (int i=0;i<columnsName.length;i++){
            XSSFCell cell = row.createCell(i);
            cell.setCellValue(columnsName[i]);
        }
        //创建内容,目前就一行
        int i = 1;
        for (PositionVo vo : vos) {
            XSSFRow contentRow = sheet.createRow(i);
            XSSFCell cell = contentRow.createCell(0);
            cell.setCellValue(vo.getName());
            XSSFCell cell1 = contentRow.createCell(1);
            cell1.setCellValue(vo.getDeptName());
            XSSFCell cell2 = contentRow.createCell(2);
            cell2.setCellValue(vo.getDeptManager());
            i++;
        }
        return xssfWorkbook;
    }
    private List<PositionVo> findPosition(PositionVo condition){
        List<PositionPo> pos = repository.findAll((Specification<PositionPo>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            if (!StringUtils.isEmpty(condition.getName())) {
                list.add(criteriaBuilder.like(root.get("name").as(String.class), "%" + condition.getName() + "%"));
            }
            if (condition.getDeptId() != null) {
                list.add(criteriaBuilder.equal(root.get("deptId").as(Integer.class),  condition.getDeptId()));
            }
            Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.and(list.toArray(p));
        });
        List<PositionVo> vos = converterUtils.toDTOList(pos);
        vos.forEach(vo ->
                deptRepository.findById(vo.getDeptId()).ifPresent(dp -> {
                    vo.setDeptName(dp.getName());
                    vo.setDeptManager(dp.getManager());
                })
        );
        return vos;
    }
}
