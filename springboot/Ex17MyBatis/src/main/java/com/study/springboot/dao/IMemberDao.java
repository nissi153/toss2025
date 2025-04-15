package com.study.springboot.dao;

import com.study.springboot.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// @Mapper : 인터페이스 DAO와 MyBatis XML과 연결하는 용도
@Mapper
public interface IMemberDao {
    public List<MemberDto> list();
}
