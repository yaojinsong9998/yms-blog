package com.yaojinsong.ymsblog.service;

import com.yaojinsong.ymsblog.vo.Result;
import com.yaojinsong.ymsblog.vo.TagVo;

import java.util.List;

public interface TagService {

    List<TagVo> findTagsByArticleId(Long articleId);

    Result hots(int limit);
}
