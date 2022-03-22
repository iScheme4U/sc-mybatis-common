package com.soulcraft.mybatis.common.converter.factory;

import com.soulcraft.mybatis.common.converter.RequestParamEnumConverter;
import com.soulcraft.mybatis.common.enums.BaseCodeEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <pre>
 * 请求参数转换为枚举类型对象创建工厂
 * </pre>
 *
 * @author Scott
 * @since 2022年03月22日
 */
public class RequestParamToEnumConverterFactory implements ConverterFactory<String, BaseCodeEnum> {
    private static final Map<Class<? extends BaseCodeEnum>, Converter> CONVERTERS = new LinkedHashMap();

    @Override
    public <T extends BaseCodeEnum> Converter<String, T> getConverter(Class<T> targetType) {
        Converter<String, T> converter = CONVERTERS.get(targetType);
        if (converter == null) {
            converter = new RequestParamEnumConverter(targetType);
            CONVERTERS.put(targetType, converter);
        }
        return converter;
    }
}
