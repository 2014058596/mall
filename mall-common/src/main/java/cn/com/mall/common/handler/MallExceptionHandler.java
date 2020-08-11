package cn.com.mall.common.handler;

import cn.com.mall.base.bean.exception.CommonException;
import cn.com.mall.base.bean.HttpStatus;
import cn.com.mall.base.bean.result.StandardResult;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: ExceptionHandler
 * @Description: TODO
 * @author: 55555
 * @date: 2020年04月04日 8:02 下午
 */
@RestControllerAdvice
@Log4j2
public class MallExceptionHandler {


    /**
     * 全局Exception处理
     * @param e
     * @param response
     * @return
     */
    @ExceptionHandler(Exception.class)
    public StandardResult<CommonException> handlerException(Exception e, HttpServletResponse response) {
        log.error("全局异常拦截器：{}", e);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.code());
        return StandardResult.fail(e);
    }

    /**
     * 全局CommonException处理
     * @param e
     * @param response
     * @return
     */
    @ExceptionHandler(CommonException.class)
    public StandardResult<CommonException> handlerCommonException(CommonException e, HttpServletResponse response) {
        log.error("全局异常拦截器：{}", e);
        return StandardResult.fail(e);
    }

    /**
     * 全局CommonException处理
     * @param e
     * @param response
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public StandardResult<CommonException> handlerCommonException(NoHandlerFoundException e, HttpServletResponse response) {
        response.setStatus(HttpStatus.NOT_FOUND.code());
        return StandardResult.fail(HttpStatus.NOT_FOUND);
    }


}
