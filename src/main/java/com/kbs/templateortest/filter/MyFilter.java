package com.kbs.templateortest.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;


/* InterceptorController로 테스트 */
@Component
public class MyFilter implements Filter {

    /**
     * init 메소드는 필터 객체를 초기화하고 서비스에 추가하기 위한 메소드이다.
     * 웹 컨테이너가 1회 init 메소드를 호출하여 필터 객체를 초기화하면 이후의 요청들은 doFilter를 통해 처리된다.
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("[[[MyFilter.init");
        Filter.super.init(filterConfig);
    }

    /**
     * doFilter 메소드는 url-pattern에 맞는 모든 HTTP 요청이 디스패처 서블릿으로 전달되기 전에 웹 컨테이너에 의해 실행되는 메소드이다.
     * doFilter의 파라미터로는 FilterChain이 있는데, FilterChain의 doFilter 통해 다음 대상으로 요청을 전달하게 된다.
     * chain.doFilter() 전/후에 우리가 필요한 처리 과정을 넣어줌으로써 원하는 처리를 진행할 수 있다.
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("[[[MyFilter.doFilter1");

        chain.doFilter(request, response);

        System.out.println("[[[MyFilter.doFilter2");
    }

    /**
     * destroy 메소드는 필터 객체를 서비스에서 제거하고 사용하는 자원을 반환하기 위한 메소드이다.
     * 이는 웹 컨테이너에 의해 1번 호출되며 이후에는 이제 doFilter에 의해 처리되지 않는다.
     */
    @Override
    public void destroy() {
        System.out.println("[[[MyFilter.destroy");
        Filter.super.destroy();
    }
}
