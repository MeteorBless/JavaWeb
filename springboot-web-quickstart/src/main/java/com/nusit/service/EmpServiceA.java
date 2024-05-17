package com.nusit.service;

import com.nusit.dao.EmpDao;
import com.nusit.dao.EmpDaoA;
import com.nusit.pojo.Emp;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmpServiceA implements EmpService{
    //    1.调用Dao获取数据
    @Autowired // 运行时，IOC容器会提供该类型的bean对象，并赋值给该变量
    private EmpDao empDao;

    //    2.对数据进行转换处理
    @Override
    public List<Emp> listEmp() {
        List<Emp> empList = empDao.listEmp();

        empList.stream().forEach(emp->{
            String gender = emp.getGender();
            if("1".equals(gender)){
                emp.setGender("男");
            }else if ("2".equals(gender)){
                emp.setGender("女");
            }

            String job = emp.getJob();
            if("1".equals(job)){
                emp.setGender("讲师");
            }else if ("2".equals(job)){
                emp.setGender("班主任");
            }else if ("3".equals(job)){
                emp.setGender("就业指导");
            }
        });
        return empList;
    }
}
