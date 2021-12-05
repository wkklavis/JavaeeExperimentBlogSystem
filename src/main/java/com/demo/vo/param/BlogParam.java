package com.demo.vo.param;

import com.demo.dao.pojo.Tag;
import lombok.Data;

import java.util.List;

@Data
public class BlogParam {
    Long id;

    String title;

    BlogTextParam text;

    String description;

    List<Tag> tags;
}
