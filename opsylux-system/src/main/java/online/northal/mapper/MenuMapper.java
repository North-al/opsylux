package online.northal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import online.northal.domain.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper extends BaseMapper<SysMenu> {
}
