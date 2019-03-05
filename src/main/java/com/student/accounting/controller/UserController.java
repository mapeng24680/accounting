package com.student.accounting.controller;

import com.student.accounting.pojo.vo.UserVo;
import com.student.accounting.service.UserService;
import com.student.accounting.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author ZhongLiang.Xian
 * @ description:
 * @ date: 2019/3/2.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登录
     *
     * @param userVo
     * @return
     */
    @PostMapping("/login")
    public Response login(@RequestBody UserVo userVo) {
        String account = userVo.getAccount();
        String password = userVo.getPassword();
        if (StringUtils.isEmpty(account)) {
            return Response.build().fail("用户名不能为空");
        }
        if (StringUtils.isEmpty(password)) {
            return Response.build().fail("密码不能为空");
        }
        try {
            UserVo login = userService.findByAccount(account);
            if (login == null) {
                return Response.build().fail("该用户不存在");
            } else if (!password.equals(login.getPassword())) {
                return Response.build().fail("密码错误");
            }
            return Response.build().setData(login).success("登录成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Response.build().fail("服务器内部错误");
        }
    }

    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public Response addUser(@RequestBody UserVo vo) {
        userService.save(vo);
        return Response.build().success("ok");
    }

    @PutMapping
    public Response updateUser(@RequestBody UserVo vo) {
        if (StringUtils.isEmpty(vo.getId())) {
            return Response.build().fail("用户id不能为空");
        }
        userService.update(vo);
        return Response.build().success("ok");
    }

}
