package online.northal.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import online.northal.base.BasePage;
import online.northal.domain.entity.SysRole;
import online.northal.dto.role.RoleListResponseDTO;
import online.northal.dto.role.RoleSaveRequestDTO;
import online.northal.mapper.RoleMapper;
import online.northal.service.IRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;


    @Override
    public Long saveRole(RoleSaveRequestDTO role) {
        SysRole sysRole = SysRole.builder()
                .roleName(role.getRoleName())
                .roleKey(role.getRoleKey())
                .sort(role.getSort())
                .status(role.getStatus())
                .build();

        int i = this.roleMapper.insert(sysRole);
        if (i > 0) {
            return sysRole.getId();
        }

        return null;
    }

    @Override
    public boolean updateRole(RoleSaveRequestDTO role) {
        SysRole sysRole = SysRole.builder()
                .id(role.getId())
                .roleName(role.getRoleName())
                .roleKey(role.getRoleKey())
                .sort(role.getSort())
                .status(role.getStatus())
                .build();

        int i = this.roleMapper.updateById(sysRole);
        return i > 0;
    }

    @Override
    public boolean deleteRole(Long id) {
        int i = this.roleMapper.deleteById(id);
        return i > 0;
    }

    @Override
    public IPage<RoleListResponseDTO> getRoleByPage(BasePage page) {
        IPage<SysRole> selectedPage = this.roleMapper.selectPage(page.toPage(), null);
        return selectedPage.convert(sysRole -> {
            RoleListResponseDTO dto = new RoleListResponseDTO();
            BeanUtils.copyProperties(sysRole, dto);
            return dto;
        });
    }
}
