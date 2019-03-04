package com.student.logistics.service;

import com.student.logistics.pojo.vo.PositionVo;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

/**
 * @author ZhongLiang.Xian
 * @ description: 岗位
 * @ date: 2019/3/2.
 */
public interface PositionService {

    void addPosition(PositionVo vo);

    void deletePosition(Integer id);

    void updatePosition(PositionVo vo);

    List<PositionVo> findByCondition(PositionVo condition);

    XSSFWorkbook exportExcel();
}
