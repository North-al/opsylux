package online.northal.dto.menu;

import lombok.Data;
import lombok.EqualsAndHashCode;
import online.northal.domain.entity.SysMenu;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class MenuTreeResponseDTO extends SysMenu {
    private List<MenuTreeResponseDTO> children;
}
