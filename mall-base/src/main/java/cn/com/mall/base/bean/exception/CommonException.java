package cn.com.mall.base.bean.exception;

import cn.com.mall.base.bean.HttpStatus;

/**
* @ClassName: CommonException
* @Description: TODO
* @author: 55555
* @date: 2020年07月24日 2:54 下午
*/
public class CommonException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	private int code;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}


	public CommonException(String message, Throwable cause) {
		super(message, cause);

	}

	public CommonException(String message) {
		super(message);

	}

	public CommonException(Throwable cause) {
		super(cause);

	}

	public CommonException(HttpStatus httpStatus){
		super(httpStatus.reasonPhraseCN());
		this.code = httpStatus.code();
	}


}
