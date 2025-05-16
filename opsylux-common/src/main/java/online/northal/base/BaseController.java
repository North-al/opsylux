package online.northal.base;


import online.northal.domain.entity.SysUser;
import online.northal.utils.UserHolder;

/**
 * 所有 Controller 的基类
 * 提供当前用户获取方法
 */
public class BaseController {
    /**
     * 获取当前登录用户 ID
     *
     * @return 当前登录用户 ID
     */
    protected Long getUserId() {
        SysUser user = UserHolder.get();
        return user != null ? user.getId() : null;
    }


    /**
     * 获取当前登录用户名称
     *
     * @return 当前登录用户名称
     */
    protected String getUsername() {
        SysUser user = UserHolder.get();
        return user != null ? user.getUsername() : null;
    }
}
