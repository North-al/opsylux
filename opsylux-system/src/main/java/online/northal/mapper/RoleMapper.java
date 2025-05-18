package online.northal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import online.northal.domain.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper extends BaseMapper<SysRole> {
}
