package com.czxy.service.Impl;

import com.czxy.domain.Blogger;
import com.czxy.mapper.BloggerMapper;
import com.czxy.service.BloggerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * @author 庭前云落
 * @Date 2020/3/3 15:20
 * @description
 */
@Service
public class BloggerServiceImpl implements BloggerService {

    @Resource
    private BloggerMapper bloggerMapper;

    @Override
    public Blogger login(Blogger blogger) {
        return bloggerMapper.login(blogger);
    }

    @Override
    public Blogger update(Blogger blogger) {
         bloggerMapper.updateByPrimaryKey(blogger);
         return blogger;
    }
}
