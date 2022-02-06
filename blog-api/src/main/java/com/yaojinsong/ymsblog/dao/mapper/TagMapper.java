package com.yaojinsong.ymsblog.dao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yaojinsong.ymsblog.dao.pojo.Tag;

import java.util.List;

public interface TagMapper extends BaseMapper<Tag> {
    /**
     * 根据文章id查询标签列表
     * @param articleId
     * @return
     */
    List<Tag> findTagsByArticleId(Long articleId);


}
