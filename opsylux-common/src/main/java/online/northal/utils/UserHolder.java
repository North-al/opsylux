package online.northal.utils;

import online.northal.domain.entity.SysUser;

public class UserHolder {
    private static final ThreadLocal<SysUser> holder = new ThreadLocal<>();

    public static void set(SysUser user) {
        holder.set(user);
    }

    public static SysUser get() {
        return holder.get();
    }

    public static void clear() {
        holder.remove();
    }
}
