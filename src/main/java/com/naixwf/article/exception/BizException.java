package com.naixwf.article.exception;

/**
 * Created by wangfei on 14-11-5.
 * 系统业务逻辑异常
 * 运行时异常
 */
public class BizException extends RuntimeException {

	public BizException(String message) {
		super(message);
	}
}
