package com.project.yingxieg.common.aspect;

import com.project.yingxieg.common.entity.User;
import com.project.yingxieg.common.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Yingxie Gao
 * @date 2019-07-08 13:48
 */

@Component
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    public static CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver;

    @Autowired
    private CommonService commonService;

    public CurrentUserMethodArgumentResolver() {
    }

    @PostConstruct
    public void init() {
        currentUserMethodArgumentResolver = this;
        currentUserMethodArgumentResolver.commonService = this.commonService;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        if (parameter.getParameterType().isAssignableFrom(User.class) && parameter.hasParameterAnnotation(CurrentUser.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String token = getPar("token");
        User user = getUser(token);
        return user;
    }
    private String getPar(String key) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        try {
            String s = new String(request.getParameter(key).getBytes("ISO-8859-1"), "UTF-8");
            if ("".equals(s)) {
                return null;
            }
            return s;
        } catch (Exception var4) {
            return request.getParameter(key);
        }
    }

    private User getUser(String token){
        return currentUserMethodArgumentResolver.commonService.findByToken(token);
    }
}
