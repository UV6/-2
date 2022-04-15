package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

  //可以把简单的增删查改直接拿来用了
@Service
public interface userMapper extends BaseMapper<user> {

    @Select("select count(0) from user where name = #{name}")
    int getName(String name);

    //根据name查询pwd
    @Select("select pwd from user where name = #{name}")  //这个查询的结果分别用不同的类型来存放
    String getPwdByName(String name);                       //select *用User来存放
                                                            //一个结果集用List<User>来存放
    @Insert("insert into user (userID,name,pwd) values(#{codeID},#{name},#{pwd})")
    int insertUser(int codeID,String name,String pwd);
}
