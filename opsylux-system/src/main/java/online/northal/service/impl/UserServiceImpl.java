package online.northal.service.impl;


import online.northal.mapper.UserMapper;
import online.northal.domain.entity.SysUser;
import online.northal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    public SysUser getUserById(Long id) {
        return userMapper.selectById(id);
    }
}
