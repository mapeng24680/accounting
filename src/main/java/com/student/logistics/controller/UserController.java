package com.student.logistics.controller;

import com.student.logistics.pojo.vo.UserVo;
import com.student.logistics.utils.Response;
import org.springframework.web.bind.annotation.*;

/**
 * @author ZhongLiang.Xian
 * @ description:
 * @ date: 2019/3/2.
 */
@RestController
@RequestMapping("/user")
public class UserController {



    @PostMapping("/login")
    public Response login(@RequestBody UserVo userVo) {
//        if (StringUtils.isEmpty(userVo.getAccount())) {
//            return Response.build().fail("用户名不能为空");
//        }
//        if (StringUtils.isEmpty(userVo.getPassword())) {
//            return Response.build().fail("密码不能为空");
//        }
//        try {
//            UserVo login = service.login(userVo);
//            if (login == null) {
//                return Response.build().fail("用户名密码错误");
//            }
//            return Response.build().setData(login).success("登录成功");
//        } catch (Exception e){
//            e.printStackTrace();
//            return Response.build().fail("服务器内部错误");
//        }
        return null;
    }

    @PostMapping
    public Response addUser(@RequestBody UserVo vo) {
//        service.saveUser(vo);
        return Response.build().success("ok");
    }

    @PutMapping
    public Response updateUser(@RequestBody UserVo vo) {
//        service.updateUser(vo);
        return Response.build().success("ok");
    }

    @DeleteMapping("/{id}")
    public Response deleteUser(@PathVariable("id") Integer id) {
//        service.deleteUser(id);
        return Response.build().success("ok");
    }

    @PostMapping("/condition")
    public Response findByCondition(@RequestBody UserVo vo) {
//        List<UserVo> vos = service.findByCondition(vo);
//        return Response.build().success("ok").setData(vos);
        return null;
    }
}
