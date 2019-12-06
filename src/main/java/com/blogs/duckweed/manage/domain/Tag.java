package com.blogs.duckweed.manage.domain;

import com.blogs.duckweed.common.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javafx.scene.chart.ValueAxis;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

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
public class Tag extends BaseEntity {
    @ApiModelProperty(value = "标签名称")
    @Column(length = 4)
    @NotNull
    private String name;
    @ApiModelProperty(value = "点击量")
    @Column(columnDefinition = "int(9) default 0")
    private Integer clickAmount;
    @ApiModelProperty(value = "默认排序号")
    @Column(length = 9)
    private Integer rankNum;
    @ApiModelProperty(value = "状态:1 正常 0 隐藏")
    private Integer status;
}
