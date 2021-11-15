package com.demo.dao.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Tag {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 标签名称
     */
    private String tagName;

}
