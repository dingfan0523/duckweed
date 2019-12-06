package com.blogs.duckweed.manage.domain;

import com.blogs.duckweed.common.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;

/**
 * @author dingfan
 */
@ApiModel(description = "用户授权实体")
@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@Getter
@Setter
public class UserAuth extends BaseEntity {
    @ApiModelProperty(value = "用户id")
    private Integer userId;
    @ApiModelProperty(value = "验证类型")
    private Integer identityType;
    @ApiModelProperty(value = "身份唯一标识")
    private String identifier;
    @ApiModelProperty(value = "授权凭证")
    private String credential;
    @ApiModelProperty(value = "验证通过:0 不通过,1 通过")
    private Integer verified;
}
