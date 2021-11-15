package com.demo.dao.pojo;

import javax.validation.constraints.NotBlank;

public class BlogText {
    /**
     * 主键
     */
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
