package com.demo.dao.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Comment {
    /**
     * 评论id-主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论时间
     */
    private Long createDate;

    /**
     * 所属的文章--外键1
     */
    private Long blogId;

}
