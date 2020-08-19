package com.czxy.service;

import com.czxy.domain.Blogger;

/**
 * @author 庭前云落
 * @Date 2020/3/3 15:20
 * @description
 */
public interface BloggerService {
    Blogger login(Blogger blogger);

    Blogger update(Blogger blogger);
}
