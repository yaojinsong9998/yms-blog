package com.yaojinsong.ymsblog.service;

import com.yaojinsong.ymsblog.vo.Result;

public interface CommentsService {

    /**
     * 根据文章id查询所有的评论列表
     * @param id
     * @return
     */
    Result commentsByArticleId(Long id);
}
