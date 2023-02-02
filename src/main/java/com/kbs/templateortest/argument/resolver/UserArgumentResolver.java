package com.kbs.templateortest.argument.resolver;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

public class UserArgumentResolver implements HandlerMethodArgumentResolver {

    /** 주어진 메소드의 파라미터가 이 Argument Resolver에서 지원하는 타입인지 검사한다.
     * 지원한다면 true 를, 그렇지 않다면 false 를 반환한다. */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(UserDto.class);
    }

    /**
     * 이 메소드의 반환값이 대상이 되는 메소드의 파라미터에 바인딩된다.
     */
    @Override
    public Object resolveArgument(@NotNull MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {

        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        String remoteAddr = request.getRemoteAddr();
        String uri = request.getRequestURI();

        String id = webRequest.getParameter("id");

        return new UserDto(id, remoteAddr, uri);
    }
}
