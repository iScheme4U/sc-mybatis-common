package com.soulcraft.mybatis.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 是和否枚举
 *
 * @author Scott
 * @since 2022-03-22
 */
@Getter
@AllArgsConstructor
public enum EYesOrNo implements BaseCodeEnum {
    /**
     * 否
     */
    NO(0),
    /**
     * 是
     */
    YES(1),
    ;
    @EnumValue
    @JsonValue
    private int code;
}
