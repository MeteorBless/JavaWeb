package com.nusit.controller;

import com.nusit.pojo.Address;
import com.nusit.pojo.Result;
import com.nusit.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ResponseController {

    @RequestMapping("/getAddr")
    public Address getAddr(){
        Address addr = new Address();
        addr.setProvince("江苏省");
        addr.setCity("南京市");
        return addr;
    }

    @RequestMapping("/listAddr")
    public Result listAddr(){
        List<Address> list = new ArrayList<>();

        Address addr = new Address();
        addr.setProvince("江苏省");
        addr.setCity("南京市");
        list.add(addr);


        return Result.success(list);

    }

    @RequestMapping("/helloWorld")
    public Result helloWorld(){
        System.out.println("Hello World~");
//        return new Result(1,"success","Hello World~");
        return Result.success("Hello World~");
    }
}
