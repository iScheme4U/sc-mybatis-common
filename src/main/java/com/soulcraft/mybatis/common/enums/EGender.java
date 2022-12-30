package com.soulcraft.mybatis.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 性别枚举
 *
 * @author Scott
 * @since 2022-03-22
 */
@Getter
@AllArgsConstructor
public enum EGender implements BaseCodeEnum {
	/**
	 * 女
	 */
	FEMALE(0, "女"),
	/**
	 * 男
	 */
	MALE(1, "男"),
	;
	@EnumValue
	@JsonValue
	private int code;
	private String desc;
}
