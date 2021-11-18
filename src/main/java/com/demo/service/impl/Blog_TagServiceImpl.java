package com.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.dao.mapper.Blog_TagMapper;
import com.demo.dao.pojo.Blog_Tag;
import com.demo.service.Blog_TagService;
import org.springframework.stereotype.Service;

@Service
public class Blog_TagServiceImpl extends ServiceImpl<Blog_TagMapper, Blog_Tag> implements Blog_TagService {
}
