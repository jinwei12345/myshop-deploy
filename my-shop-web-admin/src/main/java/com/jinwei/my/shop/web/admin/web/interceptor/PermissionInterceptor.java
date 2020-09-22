/**
 * 项目名称:  my-shop
 * 文件名:    PermissionInterceptor
 * 作者:     金威
 * 修改日期:  2020/5/21 13:10
 * 描述:
 */
package com.jinwei.my.shop.web.admin.web.interceptor;

import com.jinwei.my.shop.commons.constant.ConstantUtils;
import com.jinwei.my.shop.domain.TbUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PermissionInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }


    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //以login为结尾的请求
        if(modelAndView !=null&&modelAndView.getViewName ()!=null&& modelAndView.getViewName ().endsWith ("login")){
            TbUser tbUser=(TbUser)httpServletRequest.getSession ().getAttribute (ConstantUtils.SESSION_USER);
            if (tbUser!=null){
                httpServletResponse.sendRedirect("/main");

            }
        }
    }


    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
