package com.nuist.service.impl;

import com.nuist.mapper_mango.DeptMapper;
import com.nuist.mapper_mango.EmpMapper;
import com.nuist.pojo.Dept;
import com.nuist.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Dept> list() {
        List<Dept> deptList = deptMapper.list();
        return deptList;
    }

    @Transactional(rollbackFor = Exception.class) // 指定所有异常都回滚，包括运行时异常
    @Override
    public void delete(Integer id) {
        deptMapper.deleteById(id);
        empMapper.deleteByDeptId(id);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }

    @Override
    public Dept getById(Integer id) {
        Dept dept = deptMapper.getById(id);
        return dept;
    }


}
