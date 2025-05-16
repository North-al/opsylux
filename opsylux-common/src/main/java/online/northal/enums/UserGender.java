package online.northal.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserGender {
//    0-未知，1-男，2-女
    UNKNOWN(0, "未知"),
    MAN(1, "男"),
    WOMAN(2, "女");

    @EnumValue
    private final int code;
    private final String text;
}

