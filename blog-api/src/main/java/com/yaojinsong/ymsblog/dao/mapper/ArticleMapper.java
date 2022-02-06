package com.yaojinsong.ymsblog.dao.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yaojinsong.ymsblog.dao.pojo.Article;

import java.util.List;

public interface ArticleMapper extends BaseMapper<Article> {



    IPage<Article> listArticle(Page<Article> page,
                               Long categoryId,
                               Long tagId,
                               String year,
                               String month);
}
