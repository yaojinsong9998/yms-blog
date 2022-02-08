package com.yaojinsong.ymsblog.service;

import com.yaojinsong.ymsblog.vo.CategoryVo;

public interface CategoryService {
    CategoryVo findCategoryById(Long categoryId);
}
