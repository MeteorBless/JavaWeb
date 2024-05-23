package com.nuist.controller;

import com.nuist.pojo.Emp;
import com.nuist.pojo.PageBean;
import com.nuist.pojo.Result;
import com.nuist.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

//    // 分页查询
//    @GetMapping
//    public Result page(@RequestParam(defaultValue = "1") Integer page,
//                       @RequestParam(defaultValue = "10") Integer pageSize){
//        log.info("分页查询，参数：{}，{}",page,pageSize);
//
//        // 调用业务层分页查询
//        PageBean<Emp> pageBean = empService.page(page,pageSize);
//
//        return Result.success(pageBean);
//    }

//    // pageHelper分页查询
//    @GetMapping
//    public Result pageHelper(@RequestParam(defaultValue = "1") Integer page,
//                       @RequestParam(defaultValue = "10") Integer pageSize){
//        log.info("分页查询，参数：{}，{}",page,pageSize);
//
//        // 调用业务层分页查询
//        PageBean<Emp> pageBean = empService.pageHelper(page,pageSize);
//
//        return Result.success(pageBean);
//    }

    // 按条件分页查询
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end){
        log.info("分页查询，参数{},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
        PageBean<Emp> pageBean = empService.pageHelper(page,pageSize,name,gender,begin,end);

        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        empService.delete(ids);
        return Result.success();
    }

    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新增员工,emp:{}",emp);
        empService.save(emp);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    @PutMapping
    public Result update(@RequestBody Emp emp){
        empService.update(emp);
        return Result.success();
    }
}
