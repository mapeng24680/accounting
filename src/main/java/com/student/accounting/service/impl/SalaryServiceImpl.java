package com.student.logistics.service.impl;

import com.student.logistics.pojo.po.SalaryPo;
import com.student.logistics.pojo.vo.SalaryVo;
import com.student.logistics.repository.SalaryRepository;
import com.student.logistics.repository.UserRepository;
import com.student.logistics.service.SalaryService;
import com.student.logistics.utils.DTOConverterUtils;
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
import java.util.Date;
import java.util.List;

/**
 * @author ZhongLiang.Xian
 * @ description:
 * @ date: 2019/3/3.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryRepository repository;
    @Autowired
    private UserRepository userRepository;

    private DTOConverterUtils<SalaryPo, SalaryVo> converterUtils = new DTOConverterUtils<>(SalaryPo.class, SalaryVo.class);
    @Override
    public void addSalary(SalaryVo salaryVo) {
        SalaryPo salaryPo = converterUtils.toPO(salaryVo);
        salaryPo.setCreateDate(new Date());
        double base = salaryVo.getBaseSalary() == null ? 0 : salaryVo.getBaseSalary();
        double performance = salaryVo.getPerformanceSalary() == null ?0 : salaryVo.getPerformanceSalary();
        double takeOff = salaryVo.getTakeOff()==null? 0 : salaryVo.getTakeOff();
        salaryPo.setTotal(base +performance-takeOff);
        repository.save(salaryPo);
    }

    @Override
    public List<SalaryVo> findSalary(SalaryVo condition) {
        List<SalaryPo> pos;
        if (!StringUtils.isEmpty(condition.getUserName())) {
            pos =  repository.findByUserName(condition.getUserName());
        } else {
            pos = repository.findAll();
        }
        List<SalaryVo> salaryVos = converterUtils.toDTOList(pos);
        salaryVos.forEach(vo -> {
            userRepository.findById(vo.getUserId()).ifPresent(po -> {
                vo.setUserName(po.getName());
            });
        });
        return salaryVos;
    }
}
