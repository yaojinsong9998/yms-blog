package com.yaojinsong.ymsblog.service.impl;

import com.yaojinsong.ymsblog.dao.mapper.TagMapper;
import com.yaojinsong.ymsblog.dao.pojo.Tag;
import com.yaojinsong.ymsblog.dao.pojo.Tag;
import com.yaojinsong.ymsblog.service.TagService;
import com.yaojinsong.ymsblog.vo.TagVo;
import com.yaojinsong.ymsblog.vo.TagVo;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
