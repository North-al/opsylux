package online.northal.domain.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import online.northal.base.BaseEntity;
import online.northal.enums.UserGender;
import online.northal.enums.UserStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class SysUser extends BaseEntity {

    private Long id;

    private String username;

    @JsonIgnore
    private String password;

    private String nickname;

    private String email;

    private String phone;

    private UserGender gender;

    private UserStatus status;

    private String avatar;

    @JsonIgnore
    @TableLogic
    private int deleted;
}
