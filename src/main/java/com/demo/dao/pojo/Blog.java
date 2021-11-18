package com.demo.dao.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
@Data
public class Blog {
    /**
     * 文章id，主键
     */
    @TableId(type = IdType.AUTO)
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
    private Long createDate;

    /**
     * 浏览次数
     */
    private Integer views;

    /**
     * 文章作者id--外键
     */

    private Long userId;



}
