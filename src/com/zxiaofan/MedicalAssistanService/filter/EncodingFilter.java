package com.zxiaofan.MedicalAssistanService.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 描述：编码过滤器.
 * 
 * @version v1.0
 */
public class EncodingFilter implements Filter {

    /**
     * 添加字段注释.
     */
    private String encoding = "UTF-8";

    /**
     * {@inheritDoc}.
     */
    public void init(FilterConfig config) throws ServletException {
        this.encoding = config.getInitParameter("encoding");
    }

    /**
     * 进行过滤处理，这个方法最重要，所有过滤处理的代码都在此实现. {@inheritDoc}.
     */
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        chain.doFilter(req, res);
    }

    /**
     * 销毁过滤器.
     */
    public void destroy() {
    }
}
