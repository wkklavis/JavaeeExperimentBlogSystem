package com.demo.vo.param;

import lombok.Data;

@Data
public class CommentParam {

    private String nickname;

    private String email;

    private String content;

    private Long blogId;
}
