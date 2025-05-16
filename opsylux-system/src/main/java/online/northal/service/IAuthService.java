package online.northal.service;

import online.northal.domain.entity.SysUser;
import online.northal.dto.auth.LoginRequestDTO;

public interface IAuthService {
    String login(LoginRequestDTO dto);
}
