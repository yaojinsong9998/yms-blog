package com.yaojinsong.ymsblog.service.impl;

import com.yaojinsong.ymsblog.dao.mapper.CategoryMapper;
import com.yaojinsong.ymsblog.dao.pojo.Category;
import com.yaojinsong.ymsblog.service.CategoryService;
import com.yaojinsong.ymsblog.vo.CategoryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public CategoryVo findCategoryById(Long categoryId) {
        Category category = categoryMapper.selectById(categoryId);
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category,categoryVo);
        return categoryVo;
    }
}
