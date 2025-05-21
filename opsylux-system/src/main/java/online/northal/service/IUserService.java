package online.northal.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import online.northal.base.BasePage;
import online.northal.domain.entity.SysUser;
import online.northal.dto.user.UserProfileResponseDTO;
import online.northal.dto.user.UserSaveRequestDTO;

public interface IUserService {
    SysUser getUserById(Long id);

    SysUser getUserByUsername(String username);

    SysUser getUserByEmail(String email);

    SysUser getUserByEmailOrUsername(String emailOrUsername);

    Long saveUser(UserSaveRequestDTO user);

    boolean updateUser(UserSaveRequestDTO user);

    boolean deleteUser(Long id);

    IPage<UserProfileResponseDTO> getUserByPage(BasePage page);

}
