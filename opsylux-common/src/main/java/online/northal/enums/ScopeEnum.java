package online.northal.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ScopeEnum {
//    0-全部、1-自定义、2-当前部门、3-当前部门及以下部门
    ALL(0, "全部数据权限"),
    CUSTOM(1, "自定义数据权限"),
    DEPT(2, "当前部门数据权限"),
    DEPT_AND_BELOW(3, "当前部门及以下部门数据权限");

    @EnumValue
    private final int code;
    private final String text;


}
