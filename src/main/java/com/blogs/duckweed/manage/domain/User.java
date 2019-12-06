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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


/**
 * @author dingfan
 */
@ApiModel(description = "用户实体")
@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity {
    @ApiModelProperty(value = "昵称")
    @Column(length = 20)
    private String nickname;
    @ApiModelProperty(value = "性别:0 保密,1 男,2 女")
    @Column(length = 1)
    @Max(value = 2)
    @Min(value = 0)
    private Integer sex;
    @ApiModelProperty(value = "年龄")
    @Column(length = 3)
    private Integer age;
    @ApiModelProperty(value = "个性签名")
    @Column(length = 100)
    private String signature;
    @ApiModelProperty(value = "状态:0 禁用,1 正常,2 锁定")
    @Column(columnDefinition = "int(1) default 1")
    @Min(value = 0)
    @Max(value = 2)
    private Integer status;
}
