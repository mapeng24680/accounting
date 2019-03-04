package com.student.logistics.service.impl;

import com.student.logistics.pojo.po.DeptPo;
import com.student.logistics.pojo.vo.DeptVo;
import com.student.logistics.repository.DeptRepository;
import com.student.logistics.service.DeptService;
import com.student.logistics.utils.DTOConverterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhongLiang.Xian
 * @ description:
 * @ date: 2019/3/2.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptRepository deptRepository;
    private DTOConverterUtils<DeptPo, DeptVo> converterUtils = new DTOConverterUtils<>(DeptPo.class, DeptVo.class);
    @Override
    public void addDept(DeptVo deptVo) {
        DeptPo deptPo = converterUtils.toPO(deptVo);
        deptRepository.save(deptPo);
    }

    @Override
    public void deleteDept(Integer id) {
        deptRepository.deleteById(id);
    }

    @Override
    public void updateDept(DeptVo deptVo) {
        deptRepository.findById(deptVo.getId()).ifPresent(po -> {
            if (!StringUtils.isEmpty(deptVo.getName())) {
                po.setName(deptVo.getName());
            }
            if (!StringUtils.isEmpty(deptVo.getManager())) {
                po.setManager(deptVo.getManager());
            }
        });
    }

    @Override
    public List<DeptVo> findByCondition(DeptVo deptVo) {
        List<DeptPo> po = deptRepository.findAll((Specification<DeptPo>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            if (!StringUtils.isEmpty(deptVo.getName())) {
                list.add(criteriaBuilder.like(root.get("name").as(String.class), "%" + deptVo.getName() + "%"));
            }
            Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.and(list.toArray(p));
        });
        return converterUtils.toDTOList(po);
    }
}
