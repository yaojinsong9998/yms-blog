package com.yaojinsong.ymsblog.service;

import com.yaojinsong.ymsblog.vo.Result;
import com.yaojinsong.ymsblog.vo.params.PageParams;

public  interface ArticleService {

    /**
     * 分页查询 文章列表
     * @param pageParams
     * @return
     */
    Result listArticle(PageParams pageParams);
}
