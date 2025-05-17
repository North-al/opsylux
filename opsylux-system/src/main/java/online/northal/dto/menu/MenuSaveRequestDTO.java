package online.northal.dto.menu;

import lombok.*;
import online.northal.domain.entity.SysMenu;
import online.northal.validation.Create;
import online.northal.validation.Update;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuSaveRequestDTO extends SysMenu {

    @NotNull(message = "菜单ID不能为空", groups = Update.class)
    private Long id;

    @NotBlank(message = "菜单标题不能为空", groups = {Create.class, Update.class})
    private String menuTitle;

    @NotBlank(message = "菜单路径不能为空", groups = {Create.class, Update.class})
    private String path;
}
