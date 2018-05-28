package com.xg.mall.dao;

import com.xg.mall.po.XgwhMemberClosure;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XgwhMemberClosureMapper {
    int insert(XgwhMemberClosure record);

    int insertSelective(XgwhMemberClosure record);

    List<XgwhMemberClosure> selectDescendant(@Param("descendant") Integer descendant, @Param("distance") Integer distance, @Param("page") Integer page, @Param("number_page") Integer number_page);

    List<XgwhMemberClosure> selectItDescendant(@Param("descendant") Integer descendant, @Param("distance") Integer distance, @Param("page") Integer page, @Param("number_page") Integer number_page);
    List<XgwhMemberClosure> selectByAncestor(Integer ancestor);

    Integer b_count(@Param("descendant") Integer descendant, @Param("distance") Integer distance);

    Integer s_count(@Param("descendant") Integer descendant, @Param("distance") Integer distance);
}