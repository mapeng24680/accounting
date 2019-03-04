package com.student.logistics.service.impl;

import com.student.logistics.pojo.po.SignedPo;
import com.student.logistics.pojo.po.WorkPo;
import com.student.logistics.pojo.vo.SignedVo;
import com.student.logistics.pojo.vo.WorkVo;
import com.student.logistics.repository.SignedRepository;
import com.student.logistics.repository.UserRepository;
import com.student.logistics.repository.WorkRepository;
import com.student.logistics.service.SignedService;
import com.student.logistics.utils.DTOConverterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author ZhongLiang.Xian
 * @ description: 签到
 * @ date: 2019/3/2.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SignedServiceImpl implements SignedService {
    @Autowired
    private SignedRepository repository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WorkRepository workRepository;
    private DTOConverterUtils<SignedPo, SignedVo> converterUtils = new DTOConverterUtils<>(SignedPo.class, SignedVo.class);
    private DTOConverterUtils<WorkPo, WorkVo> workConverterUtils = new DTOConverterUtils<>(WorkPo.class, WorkVo.class);

    /**
     * 新增签到
     * @param userId
     */
    @Override
    public void signed(Integer userId) {
        SignedPo po = new SignedPo();
        po.setTime(new Date());
        po.setUserId(userId);
        repository.save(po);
    }

    /**
     * 查询签到列表
     * @param userId
     * @return
     */
    @Override
    public List<SignedVo> findByUser(Integer userId) {
        List<SignedPo> po = repository.findByUserId(userId);
        List<SignedVo> signedVos = converterUtils.toDTOList(po);
        signedVos.forEach(vo -> {
            userRepository.findById(vo.getUserId()).ifPresent(userPo ->
                vo.setUserName(userPo.getName())
            );
        });
        return signedVos;
    }

    @Override
    public void addWork(WorkVo vo) {
        WorkPo workPo = workConverterUtils.toPO(vo);
        workRepository.save(workPo);
    }

    @Override
    public List<WorkVo> findWork(Integer userId) {
        List<WorkPo> pos = workRepository.findByUserId(userId);
        return workConverterUtils.toDTOList(pos);
    }
}
