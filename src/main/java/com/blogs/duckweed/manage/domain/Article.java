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
import javax.validation.constraints.NotNull;

/**
 * @author dingfan
 */
@ApiModel(description = "文章实体")
@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@Getter
@Setter
public class Article extends BaseEntity {
    @ApiModelProperty(value = "标题")
    @Column(length = 25)
    @NotNull(message = "标题不能为空")
    private String title;
    @ApiModelProperty(value = "图片")
    @Column(length = 50)
    private String images;
    @ApiModelProperty(value = "内容")
    @Column(columnDefinition = "TEXT")
    private String content;
    @ApiModelProperty(value = "作者")
    private Integer author;
    @ApiModelProperty(value = "浏览数")
    private Integer viewAmount;
    @ApiModelProperty(value = "评论数")
    private Integer commentAmount;
    @ApiModelProperty(value = "点赞数")
    private Integer likeAmount;
    @ApiModelProperty(value = "踩数")
    private Integer trampleAmount;
    @ApiModelProperty(value = "原始链接")
    @Column(length = 150)
    private String originalLink;
    @ApiModelProperty(value = "原创标识:1 原创,0 转载")
    @Column(columnDefinition = "int(1) default 1")
    private Integer originalFlag;
    @ApiModelProperty(value = "置顶标识:1 置顶,0 不置顶")
    @Column(columnDefinition = "int(1) default 0")
    private Integer topFlag;
    @ApiModelProperty(value = "状态:1 公开,2 私密,0 删除")
    private Integer status;
}
