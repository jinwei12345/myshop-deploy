/**
 * 项目名称:  my-shop
 * 文件名:    LoginInterceptor
 * 作者:     金威
 * 修改日期:  2020/5/20 15:57
 * 描述:
 */
package com.jinwei.my.shop.web.admin.web.interceptor;


import com.jinwei.my.shop.commons.constant.ConstantUtils;
import com.jinwei.my.shop.domain.TbUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //return false;
        TbUser tbuser = (TbUser) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);

        // 判断用户是否登录
        if (tbuser == null) {
            // 用户未登录，重定向到登录页
            httpServletResponse.sendRedirect("/login");
           // return false;
        }

        // 放行
        return true;
    }


    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }


    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
