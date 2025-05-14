package online.northal.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class SysUser implements Serializable {
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

    private Date createdAt;

    private Date updatedAt;

    private int deleted;
}
