package Entity;

import lombok.Getter;

/**
 * @author Administrator
 * @date 2025/9/22 17:42
 * @see
 * @since JDK 17
 */
@Getter
public enum SexEnum {

    MALE("男"),FEMALE("女"),UNKNOWN("未知");

    private final String discretion;

    SexEnum(String discretion) {
        this.discretion = discretion;
    }

    public static SexEnum parseSex(String s){
        for (SexEnum value : SexEnum.values()) {
            if (value.discretion.equals(s))
                return value;
        }
        return null;
    }

}
