package online.northal.service;

import online.northal.domain.entity.SysUser;

public interface IUserService {
    SysUser getUserById(Long id);

    SysUser getUserByUsername(String username);

    SysUser getUserByEmail(String email);

    SysUser getUserByEmailOrUsername(String emailOrUsername);
}
