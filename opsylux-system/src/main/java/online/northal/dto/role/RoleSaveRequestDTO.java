package online.northal.dto.role;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.northal.enums.StatusEnum;
import online.northal.validation.Create;
import online.northal.validation.Update;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleSaveRequestDTO {
    @Schema(description = "角色唯一标识符", example = "1")
    @NotNull(message = "角色id不能为空", groups = {Update.class})
    private Long id;

    @Schema(description = "角色名称", example = "管理员")
    @NotBlank(message = "角色名称不能为空", groups = {Create.class, Update.class})
    @Size(max = 50, message = "角色名称长度不能超过50个字符", groups = {Create.class, Update.class})
    private String roleName;

    @Schema(description = "角色标识", example = "admin")
    @NotBlank(message = "角色标识不能为空", groups = {Create.class, Update.class})
    @Size(max = 100, message = "角色标识长度不能超过100个字符", groups = {Create.class, Update.class})
    private String roleKey;

    @Schema(description = "角色排序", example = "1")
    @NotNull(message = "角色排序不能为空", groups = {Create.class, Update.class})
    private int sort;

    @Schema(description = "角色状态：0-正常，1-停用", example = "0")
    private StatusEnum status;

//    @Schema(description = "数据权限范围：0-全体，1-自建，2-当前部门，3-当前部门及子部门", example = "0")
//    @NotNull(message = "数据权限范围不能为空", groups = {Create.class, Update.class})
//    @Min(value = 0, message = "数据权限范围必须在0-3之间", groups = {Create.class, Update.class})
//    @Max(value = 3, message = "数据权限范围必须在0-3之间", groups = {Create.class, Update.class})
//    private Integer scope;
}
