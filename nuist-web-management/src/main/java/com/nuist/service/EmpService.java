package com.nuist.service;

import com.nuist.pojo.Emp;
import com.nuist.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {
    /**
     * 条件分页查询
     * @param page 页码
     * @param pageSize 每页展示记录数
     * @return
     * */
    PageBean<Emp> page(Integer page, Integer pageSize);

//    PageBean<Emp> pageHelper(Integer page,Integer pageSize);


    PageBean<Emp> pageHelper(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);


    /**
     * 删除
     * */
    void delete(List<Integer> ids);

    /**
     * 新增员工
     * @param emp
     * */
    void save(Emp emp);

    Emp getById(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);
}
