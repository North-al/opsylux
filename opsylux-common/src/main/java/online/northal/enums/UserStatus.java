package online.northal.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserStatus {
    OK(0, "正常"),
    DISABLE(1, "停用");

    @EnumValue
    private final int code;
    private final String text;

}

