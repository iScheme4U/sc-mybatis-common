package com.soulcraft.mybatis.common.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <pre>
 * 数据表对象基础映射类
 * 定义了通用属性：ID，创建时间，更新时间
 * </pre>
 *
 * @author Scott
 * @since 2022年03月22日
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseUuidModel extends AbstractBaseModel {

	@ApiModelProperty(value = "ID")
	@TableId(value = "id", type = IdType.ASSIGN_UUID)
	private String id;

}
