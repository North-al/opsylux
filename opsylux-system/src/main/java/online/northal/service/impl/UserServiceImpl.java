package online.northal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import online.northal.domain.entity.SysUser;
import online.northal.mapper.UserMapper;
import online.northal.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    private SysUser getUserByCondition(LambdaQueryWrapper<SysUser> wrapper) {
        return userMapper.selectOne(wrapper);
    }

    @Override
    public SysUser getUserById(Long id) {
        return this.getUserByCondition(new LambdaQueryWrapper<SysUser>().eq(SysUser::getId, id));
    }

    @Override
    public SysUser getUserByUsername(String username) {
        return this.getUserByCondition(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, username));
    }

    @Override
    public SysUser getUserByEmail(String email) {
        return this.getUserByCondition(new LambdaQueryWrapper<SysUser>().eq(SysUser::getEmail, email));
    }

    @Override
    public SysUser getUserByEmailOrUsername(String emailOrUsername) {
        return this.getUserByCondition(new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getEmail, emailOrUsername)
                .or()
                .eq(SysUser::getUsername, emailOrUsername)
        );
    }
}
