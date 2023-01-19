package com.soulcraft.mybatis.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * 使Mybatis Plus创建时间、更新时间字段的自动插入、更新
 *
 * @author scott
 * @since 2023年01月18日
 */
public class MybatisMetaObjectHandler implements MetaObjectHandler {

	@Override
	public void insertFill(MetaObject metaObject) {
		setFieldValByName("createTime", new Date(), metaObject);
		setFieldValByName("updateTime", new Date(), metaObject);
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		setFieldValByName("updateTime", new Date(), metaObject);
	}

}
