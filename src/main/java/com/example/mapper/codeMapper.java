package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.code;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public interface codeMapper extends BaseMapper<code> {

    @Select("select count(0) from code where codeID = #{code}")
    int getCode(int code);
}
