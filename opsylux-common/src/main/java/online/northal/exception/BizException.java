package online.northal.exception;
import online.northal.enums.ResultCode;


public class BizException extends BaseException {
  public BizException(String module, String message, Object... args) {
    super(ResultCode.ERROR.getCode(), module, message, args);
  }

  public BizException(String module, ResultCode resultCode, Object... args) {
    super(resultCode.getCode(),module, resultCode.getMessage(), args);
  }
}
