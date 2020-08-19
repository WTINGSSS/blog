package com.czxy.controller;

import com.czxy.common.utils.JwtUtils;
import com.czxy.common.utils.RasUtils;
import com.czxy.common.vo.BaseResult;
import com.czxy.domain.Blogger;
import com.czxy.service.BloggerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 庭前云落
 * @Date 2020/3/3 15:21
 * @description
 */
@RestController
@RequestMapping("/blogger")
public class BolggerController {
    @Resource
    private BloggerService bloggerService;

    private static final  String priKeyPath="D:\\ras\\ras.pri";

    @PostMapping("/login")
    public BaseResult login(@RequestBody Blogger blogger) {

        Blogger result = bloggerService.login(blogger);

        if(result!=null){
            String token = null;

            try {
                token = JwtUtils.generateToken(result,3000, RasUtils.getPrivateKey(priKeyPath));
            } catch (Exception e) {
                e.printStackTrace();
            }

            return BaseResult.ok("登录成功").append("token",token).append("blogger",result);
        }else{
            return BaseResult.error("登录失败,用户名或密码错误!");
        }
    }

    @PutMapping
    public BaseResult update(@RequestBody Blogger blogger){
        Blogger result = bloggerService.update(blogger);
        return BaseResult.ok("修改成功",result);
    }

    @GetMapping
    public BaseResult layout(HttpServletRequest request){
        request.getSession().invalidate();
        return BaseResult.ok("退出成功");
    }
}
