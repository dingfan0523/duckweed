package com.blogs.duckweed.manage.domain;

import com.blogs.duckweed.common.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author dingfan
 */
@ApiModel(description = "认证方式实体")
@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@Getter
@Setter
public class Auth extends BaseEntity {
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "标识码")
    private String code;
    @ApiModelProperty(value = "图标")
    private String icon;
    @ApiModelProperty(value = "默认标识:1 默认认证方式,0 否")
    @Column(columnDefinition = "int(1) default 0")
    private Integer defaultFlag;
}
