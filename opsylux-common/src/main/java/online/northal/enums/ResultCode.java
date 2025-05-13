package online.northal.enums;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS(200, "操作成功"),
    VALIDATE_FAILED(400, "参数检验失败"),
    UNAUTHORIZED(401, "未认证"),
    FORBIDDEN(403, "没有权限"),
    ERROR(500, "操作失败");

    private final Integer code;
    private final String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
