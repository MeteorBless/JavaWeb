package com.nuist.controller;

import com.nuist.pojo.Emp;
import com.nuist.pojo.Result;
import com.nuist.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    @Autowired
    private EmpService empService;
    @RequestMapping("/listEmp")
    public Result listEmp(){
        List<Emp> empList = empService.listEmp();
        return Result.success(empList);
    }
}
