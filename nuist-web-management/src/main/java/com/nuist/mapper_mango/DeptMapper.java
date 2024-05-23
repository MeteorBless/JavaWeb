package com.nuist.mapper_mango;

import com.nuist.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {
    /**
        * 查询全部部门
        * @return
        **/
    @Select("select id,name,create_time,update_time from dept")
    List<Dept> list();

    /**
     * 根据ID删除部门
     * @param id
     * */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    /**
     * 新增部门
     * return
     * */
    @Insert("insert into dept(name,create_time,update_time) values (#{name},#{createTime},#{updateTime})")
    void add(Dept dept);

    /**
     * 更新部门
     * */
    @Update("update dept set name=#{name},update_time=#{updateTime} where id=#{id}")
    void update(Dept dept);



    /**
     * 根据id查找部门
     * */
    @Select("select * from dept where id = #{id}")
    Dept getById(Integer id);
}
