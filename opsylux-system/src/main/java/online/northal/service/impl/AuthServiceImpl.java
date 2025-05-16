package online.northal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import online.northal.dto.auth.LoginRequestDTO;
import online.northal.exception.BizException;
import online.northal.domain.entity.SysUser;
import online.northal.service.IAuthService;
import online.northal.service.IUserService;
import online.northal.utils.JwtUtil;
import online.northal.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private IUserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private RedisCache redisCache;

    @Value("${jwt.expire}")
    private Long expire;

    @Override
    public String login(LoginRequestDTO dto) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getUsername, dto.getUsername());
        SysUser user = this.userService.getUserByEmailOrUsername(dto.getUsername());
        if (user == null) throw new BizException("userService login", "当前账号不存在");
        if (!user.getPassword().equals(dto.getPassword())) throw new BizException("userService login", "账号或密码错误", dto);

        String token = this.jwtUtil.generateToken(user.getId(), user.getUsername());
        redisCache.set("user-token-" + user.getUsername(), token , this.expire);
        return token;
    }
}
