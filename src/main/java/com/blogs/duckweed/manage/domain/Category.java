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
@ApiModel(description = "分类实体")
@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@Getter
@Setter
public class Category extends BaseEntity {
    @ApiModelProperty(value = "分类名称")
    @Column(length = 4)
    private String name;
    @ApiModelProperty(value = "描述")
    @Column(length = 50)
    private String description;
}
