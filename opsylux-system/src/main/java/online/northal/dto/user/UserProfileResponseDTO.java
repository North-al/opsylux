package online.northal.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import online.northal.domain.entity.SysUser;

public class UserProfileResponseDTO extends SysUser {

    // 返回状态码字符串，用@JsonProperty指定序列化字段名为status
    @JsonProperty("status")
    public Integer getStatusCode() {
        return super.getStatus() != null ? super.getStatus().getCode() : null;
    }

    // 返回状态文本
    @JsonProperty("statusText")
    public String getStatusText() {
        return super.getStatus() != null ? super.getStatus().getText() : "未知";
    }

    @JsonProperty("gender")
    public Integer getGenderCode() {
        return super.getGender() != null ? super.getGender().getCode() : null;
    }

    // 返回性别文本
    @JsonProperty("genderText")
    public String getGenderText() {
        return super.getGender() != null ? super.getGender().getText() : "未知";
    }
}
