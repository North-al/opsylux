package online.northal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import online.northal.domain.entity.SysMenu;
import online.northal.dto.menu.MenuSaveRequestDTO;
import online.northal.mapper.MenuMapper;
import online.northal.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
