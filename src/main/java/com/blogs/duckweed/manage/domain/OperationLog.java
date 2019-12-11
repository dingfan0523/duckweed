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
import javax.persistence.Transient;


/**
 * @author dingfan
 */
@ApiModel(description = "操作日志实体")
@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@Getter
@Setter
public class OperationLog extends BaseEntity {
    @ApiModelProperty(value = "ip")
    @Column(length = 20)
    private String ip;
    @ApiModelProperty(value = "浏览器")
    private String browser;
    @ApiModelProperty(value = "地区")
    private String area;
    @ApiModelProperty(value = "省")
    private String province;
    @ApiModelProperty(value = "市")
    private String city;
    @ApiModelProperty(value = "url")
    private String url;
    @ApiModelProperty(value = "参数")
    private String params;
    @ApiModelProperty(value = "接口类型")
    private String type;
    @ApiModelProperty(value = "用户昵称")
    @Transient
    private String nickName;
}
