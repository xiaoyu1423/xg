package com.xg.mall.dao;

import com.xg.mall.po.XgwhMember;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XgwhMemberMapper {
    int deleteByPrimaryKey(Integer memberId);

    int insert(XgwhMember record);

    int insertSelective(XgwhMember record);

    XgwhMember selectByPrimaryKey(Integer memberId);
    List<XgwhMember> select(XgwhMember xgwhMember);

    XgwhMember selectMember(@Param("memberId") Integer memberId);

    int updateByPrimaryKeySelective(XgwhMember record);

    int updateByPrimaryKey(XgwhMember record);

    XgwhMember selectByMemberName(String memberName);

    int count(XgwhMember xgwhMember);

    XgwhMember selectPwdByMemberId(@Param("memberUsername") String memberUsername);

}