package com.demo.dao.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("blog_tag")
public class Blog_Tag {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long blogId;

    private Long tagId;
}
