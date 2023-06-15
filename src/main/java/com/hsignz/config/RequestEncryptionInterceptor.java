package com.hsignz.config;

import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RequestEncryptionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		ContentCachingRequestWrapper servletRequest = new ContentCachingRequestWrapper(request);
		String decryptedRequestBody = IOUtils.toString(servletRequest.getInputStream(), StandardCharsets.UTF_8);
		log.debug("Inside RequestEncryptionInterceptor  -----------");
		log.debug("RequestEncryptionInterceptor >> Decrypted_RequestBody  >>>> " + decryptedRequestBody);
		String type = request.getHeader("Content-Type");
		log.debug("RequestEncryptionInterceptor >> Content-Type >>>> " + type);
		boolean isPost = "POST".equals(request.getMethod());
		if (isPost) {
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
}
