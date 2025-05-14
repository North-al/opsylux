package online.northal.handler;


import lombok.extern.slf4j.Slf4j;
import online.northal.enums.ResultCode;
import online.northal.exception.BaseException;
import online.northal.response.ActionResult;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ActionResult<?> handleBaseException(BaseException e) {
        log.error("[模块:{}] 发生业务异常，code={}, message={}, args={}",
                e.getModule(), e.getCode(), e.getMessage(), e.getArgs());

        // 返回简化后的前端错误信息（避免暴露细节）
        return ActionResult.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ActionResult<?> handleValidException(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", "));
        return ActionResult.fail(ResultCode.VALIDATE_FAILED.getCode(), errorMessage);
    }

    @ExceptionHandler(Exception.class)
    public ActionResult<?> handleSystemException(Exception e) {
        log.error("[系统异常]", e);
        return ActionResult.fail(500, "系统繁忙，请稍后再试");
    }
}
