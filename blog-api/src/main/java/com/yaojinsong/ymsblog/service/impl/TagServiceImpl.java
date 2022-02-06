package com.yaojinsong.ymsblog.service.impl;

import com.yaojinsong.ymsblog.dao.mapper.TagMapper;
import com.yaojinsong.ymsblog.dao.pojo.Tag;
import com.yaojinsong.ymsblog.dao.pojo.Tag;
import com.yaojinsong.ymsblog.service.TagService;
import com.yaojinsong.ymsblog.vo.Result;
import com.yaojinsong.ymsblog.vo.TagVo;
import com.yaojinsong.ymsblog.vo.TagVo;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    
    @Autowired
    private TagMapper tagMapper;
    
    @Override
    public List<TagVo> findTagsByArticleId(Long TagId) {
        //mybatisplus 无法进行多表查询
        List<Tag> tags = tagMapper.findTagsByArticleId(TagId);
        return copyList(tags);
    }

    @Override
    public Result hots(int limit) {
        /**
         * 标签所拥有的文章数量最多 最热标签
         * 查询 根据tag_id 分组 计数 从大到小进行排列 取前limit个
         */
        //先获取id
        List<Long> tagIds = tagMapper.findHotsTagIds(limit);
        if(CollectionUtils.isEmpty(tagIds)){
            return Result.success(Collections.emptyList());
        }
        //在获取tag对象
        //select * from tag where id in (1,2,3,4)
        List<Tag> tagList = tagMapper.findTagsByTagIds(tagIds);
        return Result.success(tagList);
    }

    private List<TagVo> copyList(List<Tag> tagList) {
        ArrayList<TagVo> TagVoList = new ArrayList<>();
        for(Tag tag : tagList){
            TagVoList.add(copy(tag));
        }
        return TagVoList;

    }

    private TagVo copy(Tag Tag){
        TagVo TagVo = new TagVo();
        BeanUtils.copyProperties(Tag,TagVo);
        return TagVo;
    }
}
