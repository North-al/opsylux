package online.northal.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import online.northal.base.BaseEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "系统菜单实体")
public class SysMenu extends BaseEntity {
    @Schema(description = "菜单的唯一标识符", example = "1")
    private Long id;

    @Schema(description = "菜单标题", example = "仪表盘")
    private String menuTitle;

    @Schema(description = "父菜单ID", example = "0")
    private Long parentId;

    @Schema(description = "菜单路径", example = "/dashboard")
    private String path;

    @Schema(description = "与菜单关联的组件", example = "dashboard/index")
    private String component;

    @Schema(description = "菜单的路由名称", example = "dashboard")
    private String routeName;

    @Schema(description = "菜单类型：0 表示目录，1 表示菜单，2 表示权限", example = "1")
    private Integer menuType;

    @Schema(description = "菜单是否为框架：0 表示否，1 表示是", example = "0")
    private Integer isFrame;

    @Schema(description = "菜单是否隐藏：0 表示否，1 表示是", example = "0")
    private Integer isHidden;

    @Schema(description = "菜单是否缓存：0 表示否，1 表示是", example = "0")
    private Integer isCache;

    @Schema(description = "菜单状态：0 表示禁用，1 表示启用", example = "1")
    private Integer status;

    @Schema(description = "菜单的权限标识", example = "system:menu:view")
    private String permission;

    @Schema(description = "菜单图标", example = "el-icon-menu")
    private String icon;
}