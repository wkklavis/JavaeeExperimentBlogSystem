package com.demo.vo.info;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.demo.dao.pojo.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class BlogInfo {
    /**
     * 文章id，主键
     */
    private Long id;

    /**
     * 文章标题
     */
    @NotBlank(message = "标题不能为空")
    private String title;

    /**
     * 描述
     */
    @NotBlank(message = "摘要不能为空")
    private String description;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    /**
     * 浏览次数
     */
    private Integer views;

    public BlogInfo(Long id, @NotBlank(message = "标题不能为空") String title, @NotBlank(message = "摘要不能为空") String description, LocalDateTime createDate, Integer views) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createDate = createDate;
        this.views = views;
    }

    /**
     * 文章作者
     */
    private User user;

    private String userNickname;

    private List<TagInfo> tags;

    private BlogTextInfo text;

    private List<CommentInfo> comments;


}
