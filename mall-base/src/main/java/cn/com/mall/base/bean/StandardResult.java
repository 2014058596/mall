package cn.com.mall.base.bean;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.PrintWriter;
import java.io.StringWriter;

/** 
* @ClassName: StandardResult
* @Description: 标准自定义响应结构
* @author: 55555
* @date: 2020年03月03日 10:26 上午
*/
@Data
@ApiModel(value = "StandardResult", description = "标准自定义响应结构")
public class StandardResult<T> {


    @ApiModelProperty(value = "响应业务状态")
    private boolean state;

    @ApiModelProperty(value = "响应消息")
    private String msg;

    @ApiModelProperty(value = "响应中的数据")
    private T data;

    @ApiModelProperty(value = "响应状态码  200 响应成功   500响应失败")
    private int code;



    public StandardResult(boolean state, String msg, T data, int code) {
        super();
        this.state = state;
        this.msg = msg;
        this.data = data;
        this.code = code;
    }

    /**
     * 构造参数
     * @param httpStatus
     * @param data
     */
    public StandardResult(HttpStatus httpStatus, T data) {
        this.code = httpStatus.code();
        this.state = httpStatus.success();
        this.msg = httpStatus.reasonPhraseCN();
        this.data = data;
    }


    public StandardResult() {
        super();
    }

    /**
     * 成功
     * @param msg
     * @param data
     * @return
     */
    public static <T> StandardResult<T> ok(String msg, T data) {

        return new StandardResult<>(HttpStatus.OK.success(), msg, data, HttpStatus.OK.code());
    }


    /**
     * 成功
     * @param msg
     * @return
     */
    public static <T> StandardResult<T> ok(String msg) {

        return StandardResult.ok(msg, null);
    }

    /**
     * 成功
     * @param data
     * @return
     */
    public static <T> StandardResult<T> ok(T data) {

        return StandardResult.ok(null, data);
    }

    /**
     * 成功
     * @return
     */
    public static <T> StandardResult<T> ok() {
        return StandardResult.ok(null);
    }


    public static StandardResult fail(HttpStatus httpStatus){

        return new StandardResult(httpStatus.success(), httpStatus.reasonPhraseCN(), null, httpStatus.code());
    }

    /**
     * 失败
     * @param msg
     * @return
     */
    public static StandardResult fail(String msg) {
        return new StandardResult(false, msg, null, HttpStatus.INTERNAL_SERVER_ERROR.code());
}

    /**
     * 失败
     * @param ex
     * @return
     */
    public static StandardResult fail(Exception ex) {
        return fail(HttpStatus.INTERNAL_SERVER_ERROR.reasonPhraseCN());
    }


    /**
     * 打印栈信息
     * @param t 异常
     * @return json
     */
    public static String printStackTraceToString(Throwable t) {
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw, true));
        return sw.getBuffer().toString();
    }


}

