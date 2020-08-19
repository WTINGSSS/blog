package com.czxy.filter;

import com.czxy.common.utils.JwtUtils;
import com.czxy.common.utils.RasUtils;
import com.czxy.domain.Blogger;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 庭前云落
 * @Date 2020/3/5 22:36
 * @description
 */
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String uri = request.getRequestURI();
        if("/api/bloggerservice/blogger/login".equals(uri)){
           return  false;
        }
        return true;
    }

    private static final String pubKeyPath = "D:\\ras\\ras.pub";


    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getHeader("authorization");
        try {
            JwtUtils.getObjectFromToken(token, RasUtils.getPublicKey(pubKeyPath), Blogger.class);
        } catch (Exception e) {
            e.printStackTrace();
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(403);
        }
        return null;
    }
}
