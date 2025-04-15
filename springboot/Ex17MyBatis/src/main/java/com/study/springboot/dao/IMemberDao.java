package com.study.springboot.dao;

import com.study.springboot.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;

// @Mapper : 인터페이스 DAO와 MyBatis XML과 연결하는 용도
@Mapper
public interface IMemberDao {
    //select *
    public List<MemberDto> list();
    //select count(*)
    public int count();
    //select where id=10
    public Optional<MemberDto> findById(int id);
    //insert
    public int insert(MemberDto dto);
    public int insert(Map map);
    //update
    public int update(MemberDto dto);
    //delete
    public int delete(int id);
    public int deleteMap(int id, String userId);
    // map.put("id", id)
    // map.put("userId", userId)
}
