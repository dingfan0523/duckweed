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
@ApiModel(description = "评论实体")
@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@Getter
@Setter
public class Comment extends BaseEntity {
    @ApiModelProperty(value = "文章id")
    private Integer articleId;
    @ApiModelProperty(value = "用户id")
    private Integer userId;
    @ApiModelProperty(value = "评论内容")
    private String content;
    @ApiModelProperty(value = "点赞数")
    private Integer likeAmount;
    @ApiModelProperty(value = "踩数")
    private Integer trampleAmount;
    @ApiModelProperty(value = "父级id")
    private Integer pid;
    @ApiModelProperty(value = "状态:1 正常,0 删除")
    private Integer status;
}
