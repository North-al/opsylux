package online.northal.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import online.northal.dto.auth.LoginRequestDTO;
import online.northal.exception.BizException;
import online.northal.mapper.UserMapper;
import online.northal.domain.entity.SysUser;
import online.northal.service.UserService;
import online.northal.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private JwtUtil jwtUtil;


    public SysUser getUserById(Long id) {
//        if (true) throw new BizException("userService getUserById", "user not found");
        int i = 1/0;
        return userMapper.selectById(id);
    }

    @Override
    public String login(LoginRequestDTO dto) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getUsername, dto.getUsername());
        SysUser user = userMapper.selectOne(queryWrapper);
//        if (user == null) throw new BizException("userService login", "user not found");
//
//        if (!user.getPassword().equals(dto.getPassword())) throw new BizException("userService login", "password not match");

        String token = this.jwtUtil.generateToken(user.getId(), user.getUsername());

        return token;
    }

}
