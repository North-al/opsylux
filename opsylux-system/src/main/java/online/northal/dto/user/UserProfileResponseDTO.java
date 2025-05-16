package online.northal.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserProfileResponseDTO {
        /** 用户id*/
        @Schema(description = "用户id")
        private Long id;
        private String username;
        private String email;
        private String phone;
        private String avatar;
        private String nickname;
        private Integer gender;
        private Integer status;
        private String genderText;
        private String statusText;
        private String createdAt;
        private String updatedAt;
}
