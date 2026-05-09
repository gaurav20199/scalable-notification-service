package com.project.notificationservice.config.security.filters;

import com.project.notificationservice.config.NotificationContext;
import com.project.notificationservice.config.NotificationContextHolder;
import com.project.notificationservice.constant.NotificationConstants;
import com.project.notificationservice.utils.NotificationServiceUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class NotificationAuthFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        if (isValidAPI(request.getRequestURI())) {
            String xTenantId = request.getHeader(NotificationConstants.X_TENANT_ID);

            if (NotificationServiceUtil.isObjectEmpty(xTenantId)) {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.getWriter().write("Invalid API Key");
                return;
            }

            NotificationContextHolder.setContext(new NotificationContext(xTenantId));
        }
        filterChain.doFilter(request, response);
        if (isValidAPI(request.getRequestURI())) {
            NotificationContextHolder.clearContext();
        }

    }

    static boolean isValidAPI(final String apiPath) {
        return apiPath.startsWith("/api");
    }
}