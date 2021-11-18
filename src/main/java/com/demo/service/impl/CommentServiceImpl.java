package com.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.dao.mapper.CommentMapper;
import com.demo.dao.mapper.UserMapper;
import com.demo.dao.pojo.Comment;
import com.demo.dao.pojo.User;
import com.demo.service.CommentService;
import com.demo.service.UserService;
import com.demo.vo.ReturnResult;
import com.demo.vo.info.CommentInfo;
import com.demo.vo.param.CommentParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
@Transactional
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Override
    public List<CommentInfo> getCommentsByBlogId(Long blogId) {
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("blog_id",blogId);
        queryWrapper.select("id","nickname","email","content","create_date");
        queryWrapper.orderByAsc("create_date");
        List<Comment> comments = commentMapper.selectList(queryWrapper);
        List<CommentInfo> commentInfos = new ArrayList<>();
        for (Comment comment : comments) {
            CommentInfo commentInfo = new CommentInfo();
            commentInfo.setId(comment.getId());
            commentInfo.setContent(comment.getContent());
            commentInfo.setEmail(comment.getEmail());
            commentInfo.setNickname(comment.getNickname());
            Instant instant = Instant.ofEpochMilli(comment.getCreateDate());
            ZoneId zone = ZoneId.systemDefault();
            LocalDateTime time =  LocalDateTime.ofInstant(instant, zone);
            commentInfo.setCreateDate(time);
            commentInfos.add(commentInfo);
        }
        return commentInfos;
    }

    @Override
    public ReturnResult addComment(CommentParam commentParam) {
        Comment comment = new Comment();
        comment.setNickname(commentParam.getNickname());
        comment.setEmail(commentParam.getEmail());
        comment.setContent(commentParam.getContent());
        comment.setCreateDate(System.currentTimeMillis());
        comment.setBlogId(commentParam.getBlogId());
        commentMapper.insert(comment);
        return ReturnResult.returnSuccess("评论成功");
    }

    @Override
    public ReturnResult deleteComment(Long commentId) {
        commentMapper.deleteById(commentId);
        return ReturnResult.returnSuccess("成功删除");
    }
}
