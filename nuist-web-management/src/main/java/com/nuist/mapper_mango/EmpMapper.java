package com.nuist.mapper_mango;

import com.nuist.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {
    void delete(List<Integer> ids);

    /**
     * 获得总记录数
     * */
    @Select("select count(*) from emp")
    public Long count();


    /**
     * 获得当前页的结果列表
     * */
    @Select("select * from emp limit #{start},#{pageSize}")
    public List<Emp> list(Integer start, Integer pageSize);

    /**
     * 使用pageHelper进行分页操作
     * 获取当前页的结果列表
     * */
    @Select("select * from emp")
    public List<Emp> listAll();


    /**
    * 按条件查询
    * */
    List<Emp> listByCondition(String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 新增员工
     * */
    void insert(Emp emp);

    /**
     * 根据员工id查看员工信息
     * */
    @Select("select id,username,password,name,gender,image,job,entrydate,dept_id,create_time," +
            "update_time from emp where id = #{id}")
    Emp findById(Integer id);

    void update(Emp emp);


    /**
     * 通过用户名和密码获取员工信息
     * */
    Emp getByUssernameAndPassword(Emp emp);


    /**
     * 根据部门id删除相应的员工数据
     * */
    @Delete("delete from emp where dept_id = #{deptId}")
    void deleteByDeptId(Integer deptId);
}
