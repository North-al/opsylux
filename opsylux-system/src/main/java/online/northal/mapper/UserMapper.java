package online.northal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import online.northal.domain.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<SysUser> {
}
