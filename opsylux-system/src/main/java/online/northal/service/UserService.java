package online.northal.service;

import online.northal.domain.entity.SysUser;
import online.northal.dto.auth.LoginRequestDTO;

public interface UserService {
    SysUser getUserById(Long id);

    String login(LoginRequestDTO dto);

}
