package com.demo.vo.param;

import lombok.Data;

/**
 * 前端博客参数封装
 */
@Data
public class PageParam {
    //页
    int page = 1;
    //页大小
    int pageSize = 5;
}
