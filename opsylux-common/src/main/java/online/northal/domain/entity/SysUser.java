package online.northal.domain.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import online.northal.domain.BaseEntity;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysUser extends BaseEntity implements Serializable  {
    private static final long serialVersionUID = 1L;

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
