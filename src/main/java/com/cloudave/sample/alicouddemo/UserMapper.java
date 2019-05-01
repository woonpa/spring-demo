package com.cloudave.sample.alicouddemo;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select(value = "select * from user")
    List<UserEntity> getAll();

    @Select(value = "select * from user where id=#{id}")
    UserEntity getOne(String id);

    @Update(value = "update user set name=#{name}, age=#{age} where id = #{id}")
    int updateOne(UserEntity userEntity);

    @Delete(value = "delete from user where id=#{id}")
    int deleteOne(String id);

    @Insert(value = "insert into user (id, name, age) values (#{id}, #{name}, #{age})")
    int createOne(UserEntity userEntity);
}
