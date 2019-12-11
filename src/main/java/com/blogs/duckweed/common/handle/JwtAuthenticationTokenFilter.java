package com.blogs.duckweed.common.handle;

import com.blogs.duckweed.common.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author dingfan
 * JWT登录过滤器
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String authHeader = request.getHeader(tokenHeader);
        if (null != authHeader && authHeader.startsWith(tokenHead)) {
            String token = authHeader.substring(tokenHead.length());
            int userId = TokenUtil.getUserIdFromToken(token);
            if (userId > 0 && null == SecurityContextHolder.getContext().getAuthentication()) {
                UserDetails userDetails = userDetailsService.loadUserByUsername("");
                if (TokenUtil.validateToken(token, 0)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
            filterChain.doFilter(request, response);
        }
    }
}
