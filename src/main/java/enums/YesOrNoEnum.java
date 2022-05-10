package enums;

import lombok.Getter;

/**
 * 常用枚举类型YES/NO
 * 使用场景：常用于数据库某些只有0和1这两个值的字段
 *
 * @author xujun
 * @version 1.1
 */
@Getter
public enum YesOrNoEnum {
    NO(0, "N", "否"),
    YES(1, "Y", "是");

    /**
     * 数字编码
     */
    private final Integer code;
    /**
     * 文字编码
     */
    private final String characterCode;
    /**
     * 描述
     */
    private final String description;

    YesOrNoEnum(Integer code, String characterCode, String description) {
        this.code = code;
        this.characterCode = characterCode;
        this.description = description;
    }

    public static YesOrNoEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (YesOrNoEnum yesOrNoEnum : YesOrNoEnum.values()) {
            if (yesOrNoEnum.code.equals(code)) {
                return yesOrNoEnum;
            }
        }
        return null;
    }

    public static YesOrNoEnum getByCharacterCode(String characterCode) {
        if (characterCode == null) {
            return null;
        }
        for (YesOrNoEnum yesOrNoEnum : YesOrNoEnum.values()) {
            if (yesOrNoEnum.characterCode.equals(characterCode)) {
                return yesOrNoEnum;
            }
        }
        return null;
    }

    /**
     * 校验code是否有效
     */
    public static boolean isValid(Integer code) {
        return getByCode(code) != null;
    }
}
