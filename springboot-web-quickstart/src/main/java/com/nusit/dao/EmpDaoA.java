package com.nusit.dao;

import com.nusit.pojo.Emp;
import com.nusit.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // 将当前类交给IOC容器管理，成为IOC容器中的Bean
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {

        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file,Emp.class);

        return empList;
    }
}
