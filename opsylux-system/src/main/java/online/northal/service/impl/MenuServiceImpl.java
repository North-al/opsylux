package online.northal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import online.northal.domain.entity.SysMenu;
import online.northal.dto.menu.MenuSaveRequestDTO;
import online.northal.dto.menu.MenuTreeResponseDTO;
import online.northal.mapper.MenuMapper;
import online.northal.service.IMenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements IMenuService {
    @Autowired
    private MenuMapper menuMapper;


    @Override
    public Long saveMenu(MenuSaveRequestDTO menu) {
        this.menuMapper.insert(menu);
        return menu.getId();
    }

    @Override
    public boolean updateMenu(MenuSaveRequestDTO menu) {
        int i = this.menuMapper.updateById(menu);
        return i > 0;
    }

    @Override
    public boolean deleteMenu(Long id) {
        int i = this.menuMapper.deleteById(id);
        return i > 0;
    }

    @Override
    public List<SysMenu> getAllMenuList(String menuTitle) {
        LambdaQueryWrapper<SysMenu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(menuTitle != null, SysMenu::getMenuTitle, menuTitle);
        return this.menuMapper.selectList(queryWrapper);
    }

    @Override
    public SysMenu getMenuById(Long id) {
        return this.menuMapper.selectById(id);
    }

    @Override
    public ArrayList<MenuTreeResponseDTO> getMenuTree(String menuTitle) {
        LambdaQueryWrapper<SysMenu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(menuTitle != null, SysMenu::getMenuTitle, menuTitle);
        List<SysMenu> sysMenus = this.menuMapper.selectList(queryWrapper);
        if (sysMenus.isEmpty()) {
            return new ArrayList<>();
        }

        HashMap<Long, MenuTreeResponseDTO> menuMap = new HashMap<>();
        ArrayList<MenuTreeResponseDTO> treeList = new ArrayList<>();

        // 将全部菜单放入map，找到根节点
        sysMenus.forEach(menu -> {
            MenuTreeResponseDTO treeResponseDTO = new MenuTreeResponseDTO();
            treeResponseDTO.setChildren(new ArrayList<>());
            BeanUtils.copyProperties(menu, treeResponseDTO);
            menuMap.put(menu.getId(), treeResponseDTO);

            if (menu.getParentId() == 0) {
                treeList.add(treeResponseDTO);
            }
        });

        sysMenus.forEach(menu -> {
            MenuTreeResponseDTO child = menuMap.get(menu.getId());
            MenuTreeResponseDTO parent = menuMap.get(menu.getParentId());
            if (parent != null) {
                parent.getChildren().add(child);
            }
        });

        return treeList;
    }
}
