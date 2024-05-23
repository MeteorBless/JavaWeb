package com.nuist.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nuist.mapper_mango.EmpMapper;
import com.nuist.pojo.Emp;
import com.nuist.pojo.PageBean;
import com.nuist.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean<Emp> page(Integer page, Integer pageSize) {
        // 1、获得总记录数
        Long count = empMapper.count();

        // 2、获得分页查询结果
        Integer start = (page-1)*pageSize;
        List<Emp> empList = empMapper.list(start,pageSize);

        // 3、封装PageBean对象
        PageBean<Emp> pageBean = new PageBean<>(count, empList);
        return pageBean;
    }

    @Override
    public PageBean<Emp> pageHelper(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {

        // 1.设置分页参数
        PageHelper.startPage(page,pageSize);
        // 2.按条件分页查询
        List<Emp> empList = empMapper.listByCondition(name,gender,begin,end);

        Page<Emp> p = (Page<Emp>) empList;
        // 封装pageBean
        PageBean<Emp> pageBean = new PageBean<>(p.getTotal(),p.getResult());

        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.insert(emp);
    }

    @Override
    public Emp getById(Integer id) {

        return empMapper.findById(id);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {
        Emp loginEmp = empMapper.getByUssernameAndPassword(emp);
        return loginEmp;
    }

//    @Override
//    public PageBean<Emp> pageHelper(Integer page, Integer pageSize) {
//        // 设置分页参数
//        PageHelper.startPage(page,pageSize);
//        // 执行分页查询
//        List<Emp> empList = empMapper.listAll();
//        // 获取分页结果
//        Page<Emp> p = (Page<Emp>) empList;
//
//        PageBean<Emp> pageBean = new PageBean<>(p.getTotal(),p.getResult());
//
//        return pageBean;
//
//    }
}
