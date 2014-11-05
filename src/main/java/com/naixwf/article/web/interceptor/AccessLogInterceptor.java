package com.naixwf.article.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by wangfei on 14-11-5.
 */
public class AccessLogInterceptor implements HandlerInterceptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccessLogInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI().replaceAll(";.*", "");
		if (uri.indexOf('.') != -1) {
			return true;
		}

		StringBuilder params = new StringBuilder();
		Map<String, String[]> parameterMap = request.getParameterMap();
		for (Iterator<String> iter = parameterMap.keySet().iterator(); iter.hasNext(); ) {
			String key = (String) iter.next();
			if ((key != null) && (!key.trim().equals(""))) {
				params.append(key + "=" + request.getParameter(key));
			}
			if (iter.hasNext()) {
				params.append("&");
			}
		}
		LOGGER.info("uri={},method={},params=[{}],remoteIp={}",
				uri.substring(request.getContextPath().length()),
				request.getMethod(),
				params.toString(),
				getRemoteIp(request));

		return true;
	}

	private String getRemoteIp(HttpServletRequest request) {
		String ip = request.getRemoteAddr();
		String rip = request.getHeader("X-Real-IP");
		if (rip == null) {
			rip = request.getHeader("X-Forwarded-For");
		}
		return rip != null ? rip : ip;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}
}
