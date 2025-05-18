package online.northal.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import online.northal.base.BasePage;
import online.northal.domain.entity.SysRole;
import online.northal.dto.role.RoleListResponseDTO;
import online.northal.dto.role.RoleSaveRequestDTO;

public interface IRoleService {
    /**
     * 创建角色
     *
     * @param role 角色信息
     * @return 创建成功的角色id
     */
    Long saveRole(RoleSaveRequestDTO role);

    /**
     * 更新角色
     *
     * @param role 角色信息
     * @return 是否更新成功
     */
    boolean updateRole(RoleSaveRequestDTO role);

    /**
     * 删除角色
     *
     * @param id 角色id
     * @return 是否删除成功
     */
    boolean deleteRole(Long id);

    /**
     * 获取角色分页列表
     *
     * @param page 分页参数
     * @return 角色列表
     */
    IPage<RoleListResponseDTO> getRoleByPage(BasePage page);
}
