package vn.poly.group2.pro2111.common.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import vn.poly.group2.pro2111.common.dto.LoginUserDto;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	// Before the actual handler will be executed
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

	

		// Bypass for login uri
		if (request.getRequestURI().endsWith("/auth/login")) {
			return true;
		}

		// Check logged in user
		LoginUserDto loginUserDto = (LoginUserDto) request.getSession().getAttribute("LOGGED_IN_USER_DTO");
		if (loginUserDto == null || StringUtils.isEmpty(loginUserDto.getUsername())) {
			request.getSession().setAttribute("LOGGED_IN_USER_DTO", new LoginUserDto());
			response.sendRedirect(request.getContextPath() + "/auth/login");
			return false;
		}

		// Check logout
		if (request.getRequestURI().endsWith("/auth/logout")) {
			request.getSession().setAttribute("LOGGED_IN_USER_DTO", new LoginUserDto());
			response.sendRedirect(request.getContextPath() + "/auth/login");
			return false;
		}

		return true;
	}

	// After the handler is executed
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
}
