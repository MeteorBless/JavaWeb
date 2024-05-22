package com.nuist.mapper;

import com.nuist.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper //在运行时，会自动生成该接口的实现类对象，并将该对象交给IOC容器
public interface UserMapper {

    @Select("select * from user")
    public List<User> list();
}
