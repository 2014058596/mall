package cn.com.mall.base.bean.exception;

import lombok.Data;

/**
* @ClassName: ExceptionDTO
* @Description: TODO
* @author: 55555
* @date: 2020年03月30日 9:24 上午
*/
@Data
public class ExceptionDto {

    private String message;

    private int code;

    private StackTraceElement[] stackTrace;

    private String exceptionClassName;
}
