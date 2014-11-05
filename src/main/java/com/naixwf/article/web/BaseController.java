package com.naixwf.article.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by wangfei on 14-11-5.
 */
public class BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

	protected String urlEncode(String format, Object... args) {
		String info = String.format(format, args);
		try {
			return URLEncoder.encode(info, "utf-8");
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("", e);
			return null;
		}
	}
}
