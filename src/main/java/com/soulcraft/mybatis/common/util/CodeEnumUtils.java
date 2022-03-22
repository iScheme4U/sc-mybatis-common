package com.soulcraft.mybatis.common.util;

import com.soulcraft.mybatis.common.enums.BaseCodeEnum;

/**
 * 码值映射的基础接口
 *
 * @author Scott
 * @since 2022年03月22日
 */
public final class CodeEnumUtils {
    /**
     * 将状态码值转换为对应的枚举对象
     *
     * @param enumClass 枚举类class对象
     * @param code      状态码
     * @param <E>       枚举类型
     * @return 对应的枚举对象或null
     */
    public static <E extends Enum<?> & BaseCodeEnum> E valueOf(Class<E> enumClass, int code) {
        E[] enumConstants = enumClass.getEnumConstants();
        for (E e : enumConstants) {
            if (e.getCode() == code)
                return e;
        }
        return null;
    }
}
