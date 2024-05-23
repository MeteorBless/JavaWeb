package com.nuist.controller;

import com.nuist.pojo.Dept;
import com.nuist.pojo.Result;
import com.nuist.service.DeptService;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    // 指定请求方式为get
//    @RequestMapping (value = "/depts",method = RequestMethod.GET)
    @GetMapping
    public Result list(){
        log.info("查询所有部门信息");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    /**
    * 删除部门
    * @return
    * */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除部门"+id);
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 新增部门
     * @return
     * */
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门：{}",dept);
        deptService.add(dept);
        return Result.success();
    }

    /**
     *  更新部门
     * @return
    * */
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("更新部门:{}",dept);
        deptService.update(dept);
        return Result.success();
    }

    /**
     * 根据id查找部门
     * */
    @GetMapping("/{id}")
    public Result getByID(@PathVariable Integer id){
        log.info("更具id查找部门{}",id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }


}
