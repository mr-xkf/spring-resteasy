/**
 * FileName: CharacterFilter
 * Author:   13235
 * Date:     2019/1/16 23:38
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.config;

import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/16
 * @since 1.0.0
 */

@Component
public class CharacterFilter implements Filter {
    private String ENCODING_UTF_8 = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("wewewre");
        servletRequest.setCharacterEncoding(ENCODING_UTF_8);
        servletResponse.setCharacterEncoding(ENCODING_UTF_8);
        servletRequest.setAttribute(InputPart.DEFAULT_CHARSET_PROPERTY, ENCODING_UTF_8);
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
