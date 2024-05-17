package com.nusit.controller;

import com.nusit.pojo.Emp;
import com.nusit.pojo.Result;
import com.nusit.service.EmpService;
import com.nusit.service.EmpServiceA;
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
