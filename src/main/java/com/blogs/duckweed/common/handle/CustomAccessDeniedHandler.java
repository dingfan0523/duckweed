package com.blogs.duckweed.common.handle;

import com.blogs.duckweed.common.domain.BaseResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author dingfan
 * 自定义授权失败处理
 */
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException{
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(BaseResult.failure(e.getMessage()));
        response.getWriter().flush();
    }
}
