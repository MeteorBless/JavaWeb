package com.nusit.controller;

import com.nusit.pojo.Address;
import com.nusit.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@RestController
//public class RequestController {
//    @RequestMapping("/simpleParam")
//    public String simpleParam(HttpServletRequest request){
//        String name = request.getParameter("name");
//        String ageStr = request.getParameter("age");
//        int age = Integer.parseInt(ageStr);
//        System.out.println(name+":"+age);
//        return "OK";
//    }
//}


@RestController
public class RequestController {

    @RequestMapping("/simpleParam")
    public String simpleParam(@RequestParam(value = "name",required = false) String username, Integer age){
        // 参数名需要对应 不对应会返回null
        // 或者使用注解 RequestParam
        System.out.println(username+":"+age);
        return "OK";
    }

    @RequestMapping("/simplePojo")
    public String simplePojo(User user){
        // 参数名需要对应 不对应会返回null
        // 或者使用注解 RequestParam
        System.out.println(user);
        return "OK";
    }

    @RequestMapping("arrayParam")
    public String arrayParam(String[] hobby){
        System.out.println(Arrays.toString(hobby));
        return "OK";
    }

    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby){
        System.out.println(hobby);
        return "OK";
    }

    @RequestMapping("dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                            LocalDateTime updateTime){
        System.out.println(updateTime);
        return "OK";
    }

    //    RequestBody 封装json数据
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user){
        // 参数名需要对应 不对应会返回null
        // 或者使用注解 RequestParam
        System.out.println(user);
        return "OK";
    }

    //路径参数
    @RequestMapping("/path/{id}/{name}")
    public String pathParam(@PathVariable Integer id,
                            @PathVariable String name){
        System.out.println(id+":"+name);
        return "OK";
    }

}
