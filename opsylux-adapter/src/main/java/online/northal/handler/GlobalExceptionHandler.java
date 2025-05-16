package online.northal.handler;


import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import lombok.extern.slf4j.Slf4j;
import online.northal.enums.ResultCode;
import online.northal.exception.BaseException;
import online.northal.response.ActionResult;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 业务异常
    @ExceptionHandler(BaseException.class)
    public ActionResult<?> handleBaseException(BaseException e) {
        log.error("[模块:{}] 发生业务异常，code={}, message={}, args={}",
                e.getModule(), e.getCode(), e.getMessage(), e.getArgs());

        // 返回简化后的前端错误信息（避免暴露细节）
        return ActionResult.fail(e.getCode(), e.getMessage());
    }

    // 参数校验异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ActionResult<?> handleValidException(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", "));
        log.debug("[参数校验失败] {}", errorMessage, ex);
        return ActionResult.fail(ResultCode.VALIDATE_FAILED.getCode(), errorMessage);
    }

    // MyBatis-Plus 异常
    @ExceptionHandler(MybatisPlusException.class)
    public ActionResult<?> handleMyBatisPlusException(MybatisPlusException e) {
        log.error("[MyBatis-Plus 异常]", e);
        return ActionResult.fail(500, "数据库操作异常（MyBatis-Plus）");
    }

    // MyBatis 系统异常
    @ExceptionHandler(MyBatisSystemException.class)
    public ActionResult<?> handleMyBatisSystemException(MyBatisSystemException e) {
        log.error("[MyBatis 系统异常]", e);
        return ActionResult.fail(500, "MyBatis 执行异常");
    }

    // SQL语法错误
    @ExceptionHandler(BadSqlGrammarException.class)
    public ActionResult<?> handleSqlGrammarException(BadSqlGrammarException e) {
        log.error("[SQL 语法错误]", e);
        return ActionResult.fail(500, "SQL 语法错误，请联系管理员");
    }

    // 唯一约束冲突（比如主键重复）
    @ExceptionHandler(DuplicateKeyException.class)
    public ActionResult<?> handleDuplicateKeyException(DuplicateKeyException e) {
        log.warn("[唯一约束冲突]", e);
        return ActionResult.fail(500, "记录已存在，禁止重复添加" + e.getMessage());
    }

    // 通用数据库访问异常
    @ExceptionHandler(DataAccessException.class)
    public ActionResult<?> handleDataAccessException(DataAccessException e) {
        log.error("[数据库访问异常]", e);
        return ActionResult.fail(500, "数据库操作异常");
    }

    @ExceptionHandler(Exception.class)
    public ActionResult<?> handleSystemException(Exception e) {
        log.error("[系统异常]", e);
        return ActionResult.fail(500, "系统繁忙，请稍后再试");
    }
}
