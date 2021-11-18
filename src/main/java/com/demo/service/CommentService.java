package com.demo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.dao.pojo.Comment;
import com.demo.dao.pojo.User;
import com.demo.vo.ReturnResult;
import com.demo.vo.info.CommentInfo;
import com.demo.vo.param.CommentParam;

import java.util.List;

public interface CommentService extends IService<Comment> {
    public List<CommentInfo> getCommentsByBlogId(Long blogId);

    ReturnResult addComment(CommentParam commentParam);
    ReturnResult deleteComment(Long commentId);
}
