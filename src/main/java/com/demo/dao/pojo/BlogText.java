package com.demo.dao.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class BlogText {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 文章正文
     */
    @NotBlank(message = "内容不能为空")
    private String content;

    /**
     * 附带html-MarkDown格式
     */
    private String contentHtml;
    /**
     * 外键
     */
    private Long blogId;
}
