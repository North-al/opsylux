package online.northal.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import online.northal.domain.entity.SysMenu;
import online.northal.dto.menu.MenuSaveRequestDTO;
import online.northal.dto.menu.MenuTreeResponseDTO;
import online.northal.dto.user.UserSaveRequestDTO;

import java.util.ArrayList;
import java.util.List;

public interface IMenuService {

    /**
     * 创建菜单
     *
     * @param menu 菜单信息
     * @return 创建成功的菜单id
     */
    Long saveMenu(MenuSaveRequestDTO menu);

    /**
     * 更新菜单
     *
     * @param menu 菜单信息
     * @return 是否更新成功
     */
    boolean updateMenu(MenuSaveRequestDTO menu);

    /**
     * 删除菜单
     *
     * @param id 菜单id
     * @return 是否删除成功
     */
    boolean deleteMenu(Long id);

    /**
     * 获取菜单列表
     *
     * @param menuTitle 菜单标题
     * @return 菜单列表
     */
     List<SysMenu> getAllMenuList(String menuTitle);

    /**
     * 获取菜单详情
     *
     * @param id 菜单id
     * @return  菜单详情
     */
    SysMenu getMenuById(Long id);

    ArrayList<MenuTreeResponseDTO> getMenuTree(String menuTitle);
}
