package online.northal.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.northal.enums.ResultCode;

import java.io.Serializable;


/**
 * 操作结果返回对象
 *
 * @param <T> 返回数据类型
 * @author north
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActionResult<T> implements Serializable {

    /** 状态码 */
    private Integer code;

    /** 返回数据 */
    private T data;

    /** 返回提示信息 */
    private String message;

    /** 成功（无数据） */
    public static <T> ActionResult<T> success() {
        return new ActionResult<>(ResultCode.SUCCESS.getCode(), null, ResultCode.SUCCESS.getMessage());
    }

    /** 成功（带数据） */
    public static <T> ActionResult<T> success(T data) {
        return new ActionResult<>(ResultCode.SUCCESS.getCode(), data, ResultCode.SUCCESS.getMessage());
    }

    /** 成功（带数据 + 自定义消息） */
    public static <T> ActionResult<T> success(T data, String message) {
        return new ActionResult<>(ResultCode.SUCCESS.getCode(), data, message);
    }

    /** 成功（自定义状态码和消息） */
    public static <T> ActionResult<T> success(ResultCode code, T data) {
        return new ActionResult<>(code.getCode(), data, code.getMessage());
    }

    /** 失败（默认） */
    public static <T> ActionResult<T> fail() {
        return new ActionResult<>(ResultCode.ERROR.getCode(), null, ResultCode.ERROR.getMessage());
    }

    /** 失败（自定义消息） */
    public static <T> ActionResult<T> fail(String message) {
        return new ActionResult<>(ResultCode.ERROR.getCode(), null, message);
    }

    /** 失败（自定义状态码和消息） */
    public static <T> ActionResult<T> fail(Integer code, String message) {
        return new ActionResult<>(code, null, message);
    }

    /** 失败（自定义状态码、数据、消息） */
    public static <T> ActionResult<T> fail(Integer code, T data, String message) {
        return new ActionResult<>(code, data, message);
    }

    /** 失败（枚举状态码和消息） */
    public static <T> ActionResult<T> fail(ResultCode code) {
        return new ActionResult<>(code.getCode(), null, code.getMessage());
    }
}