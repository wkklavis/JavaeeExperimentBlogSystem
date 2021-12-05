package com.demo.vo.param;

import lombok.Data;

@Data
public class BlogTextParam {
    Long id;

    String content;

    String contentHtml;

    Long blogId;
}
