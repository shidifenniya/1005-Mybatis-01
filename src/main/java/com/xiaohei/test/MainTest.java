package com.xiaohei.test;

import com.xiaohei.domain.BaseResult;
import com.xiaohei.domain.PageBean;
import com.xiaohei.domain.StudentNexus;
import com.xiaohei.mapper.StudentMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainTest {

    private ApplicationContext context;

    @Before
    public void init(){

        context = new ClassPathXmlApplicationContext("classpath*:spring-*.xml");


    }

    @Test
    public void testMapper(){

        /* 获得mybatis的Student表的代理对象 */
        StudentMapper studentMapper = context.getBean(StudentMapper.class);

        List<StudentNexus> nexusList = studentMapper.selectAll();

        System.out.println(nexusList);

    }

    @Test
    public void testLimit(){

        StudentMapper studentMapper = context.getBean(StudentMapper.class);

        /* 获取总条数 */
//        int totalRecord = studentMapper.getTotalRecord();

//        System.out.println(totalRecord);

        /* 分页查询 */
//        PageBean<StudentNexus> pageBean = new PageBean<StudentNexus>(1,2,totalRecord);
//
//        System.out.println(studentMapper.limitSelect(pageBean));

    }

    @Test
    public void testPageSelect(){

        StudentMapper studentMapper = context.getBean(StudentMapper.class);

        StudentNexus studentNexus = new StudentNexus();

        studentNexus.setStudentName("y");

        PageBean<StudentNexus> pg = new PageBean<StudentNexus>();

        pg.setParameter(studentNexus);

        PageBean<StudentNexus> pageBean = new PageBean<StudentNexus>();

        pageBean.setParameter(studentNexus);

        int total = studentMapper.getTotalRecord(pg);

        List<StudentNexus> students = studentMapper.limitSelect(pageBean);

        System.out.println(students);

    }

}
