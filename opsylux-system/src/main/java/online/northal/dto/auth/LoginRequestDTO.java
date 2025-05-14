package online.northal.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequestDTO {
    @Schema(description = "用户登录名", example = "north")
    @NotBlank(message = "用户名不能为空")
    private String username;


    @Schema(description = "密码（明文示例）", example = "123456")
    @NotBlank(message = "密码不能为空")
    private String password;
}
