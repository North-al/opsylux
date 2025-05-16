package online.northal.domain.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import online.northal.base.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysUser extends BaseEntity {

    private Long id;

    private String username;

    private String password;

    private String nickname;

    private String email;

    private String phone;

    private int gender;

    private int status;

    private String avatar;

    @TableLogic
    private int deleted;
}
