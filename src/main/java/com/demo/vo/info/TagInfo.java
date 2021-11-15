package com.demo.vo.info;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 面向返回前端的pojo类
 */
@Data
@AllArgsConstructor
public class TagInfo {
    private Long id;
    private String tagName;
}
