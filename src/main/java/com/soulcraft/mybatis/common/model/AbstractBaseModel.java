package com.soulcraft.mybatis.common.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

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
public abstract class AbstractBaseModel implements Serializable {

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
