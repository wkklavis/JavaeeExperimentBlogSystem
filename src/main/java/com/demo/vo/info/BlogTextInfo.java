package com.demo.vo.info;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BlogTextInfo {
    private Long id;

    private String content;
    /**
     * 附带html-MarkDown格式
     */
    private String contentHtml;

}
