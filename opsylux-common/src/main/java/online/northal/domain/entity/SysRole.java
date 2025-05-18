package online.northal.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import online.northal.base.BaseEntity;
import online.northal.enums.ScopeEnum;
import online.northal.enums.StatusEnum;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "系统角色实体")
public class SysRole extends BaseEntity {
    @Schema(description = "角色唯一标识符", example = "1")
    private Long id;

    @Schema(description = "角色名称", example = "管理员")
    private String roleName;

    @Schema(description = "角色标识", example = "admin")
    private String roleKey;

    @Schema(description = "角色排序", example = "1")
    private int sort;

    @Schema(description = "数据权限范围：0-全体，1-自建，2-当前部门，3-当前部门及子部门", example = "0")
    private ScopeEnum scope;

    @Schema(description = "角色状态：0-正常，1-停用", example = "1")
    private StatusEnum status;
}
