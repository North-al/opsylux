package online.northal.exception;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
    private final Integer code;
    private final String module;
    private final Object[] args;

    public BaseException(Integer code, String module, String message, Object... args) {
        super(message);
        this.code = code;
        this.module = module;
        this.args = args;
    }

    public BaseException(Integer code, String message, Object... args) {
        this(code, null, message, args);
    }
}
