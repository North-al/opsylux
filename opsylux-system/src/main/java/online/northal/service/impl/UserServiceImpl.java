package online.northal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import online.northal.base.BasePage;
import online.northal.domain.entity.SysUser;
import online.northal.dto.user.UserProfileResponseDTO;
import online.northal.dto.user.UserSaveRequestDTO;
import online.northal.mapper.UserMapper;
import online.northal.service.IUserService;
import org.springframework.beans.BeanUtils;
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

    @Override
    public Long saveUser(UserSaveRequestDTO user) {
        SysUser sysUser = SysUser.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .phone(user.getPhone())
                .avatar(user.getAvatar())
                .nickname(user.getNickname())
                .build();

        this.userMapper.insert(sysUser);
        return sysUser.getId();
    }

    @Override
    public boolean updateUser(UserSaveRequestDTO user) {
        int update = this.userMapper.updateById(SysUser.builder()
                .id(user.getId())
                .email(user.getEmail())
                .phone(user.getPhone())
                .avatar(user.getAvatar())
                .nickname(user.getNickname())
                .build());

        return update > 0;
    }

    @Override
    public boolean deleteUser(Long id) {
        int delete = this.userMapper.deleteById(id);
        return delete > 0;
    }

    @Override
    public IPage<UserProfileResponseDTO> getUserByPage(BasePage page) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(page.getKeyword() != null, SysUser::getUsername, page.getKeyword());
        IPage<SysUser> sysUserIPage = this.userMapper.selectPage(page.toPage(), queryWrapper);
        return sysUserIPage.convert(user -> {
            UserProfileResponseDTO dto = new UserProfileResponseDTO();
            BeanUtils.copyProperties(user, dto);
            return dto;
        });
    }
}
