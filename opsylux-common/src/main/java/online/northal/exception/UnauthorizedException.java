package online.northal.exception;

import online.northal.enums.ResultCode;

public class UnauthorizedException extends BaseException {
    public UnauthorizedException(String message) {
        super(ResultCode.UNAUTHORIZED.getCode(), "auth", message);
    }
}
