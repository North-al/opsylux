package online.northal.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.northal.validation.Create;
import online.northal.validation.Update;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSaveRequestDTO {
    @NotNull(message = "用户id不能为空", groups = Update.class)
    private Long id;

    @NotBlank(message = "用户名不能为空", groups = Create.class)
    private String username;

    @NotBlank(message = "密码不能为空", groups = Create.class)
    private String password;

    @Email(message = "邮箱格式不正确", groups = {Create.class, Update.class})
    private String email;

    private String phone;

    private String avatar;

    @NotBlank(message = "昵称不能为空", groups = {Create.class, Update.class})
    private String nickname;
}
