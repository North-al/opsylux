package online.northal.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SysUser {
    private Long id;

    private String username;

    @JsonIgnore
    private String password;

    private String nickname;

    private String email;

    private String phone;

    private int gender;

    private String genderDesc;

    private int status;

    private String statusDesc;

    private String avatar;

    @JsonIgnore
    private int deleted;
}
