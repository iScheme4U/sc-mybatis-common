package com.soulcraft.mybatis.common.converter;

import com.soulcraft.mybatis.common.enums.BaseCodeEnum;
import org.springframework.core.convert.converter.Converter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <pre>
 * 将请求参数转换为枚举类型
 * </pre>
 *
 * @author Scott
 * @since 2022年03月22日
 */
public class RequestParamEnumConverter<E extends Enum<?> & BaseCodeEnum> implements Converter<String, E> {
    private final Map<String, E> enumMap;
    private final Class<E> enumType;

    /**
     * 创建转换对象
     *
     * @param enumType 枚举类型
     */
    public RequestParamEnumConverter(Class<E> enumType) {
        this.enumType = enumType;
        enumMap = new LinkedHashMap<>();
        E[] enumConstants = enumType.getEnumConstants();
        for (E enumConstant : enumConstants) {
            enumMap.put(String.valueOf(enumConstant.getCode()), enumConstant);
        }
    }

    @Override
    public E convert(String source) {
        E e = enumMap.get(source);
        if (e == null) {
            throw new EnumConstantNotPresentException(enumType, source);
        }
        return e;
    }
}
