package com.xiaohei.controller;

import com.xiaohei.domain.BaseResult;
import com.xiaohei.domain.StudentNexus;
import com.xiaohei.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class StudentController {

    @Resource
    private StudentService studentService;

    /* 配置起始页 */
    @RequestMapping(value = {"","/"})
    public String index(){

        return "index";

    }

    /* 获取学生列表数据,用于前端页面表格显示
     * 返回数据以json格式返回 */
    @RequestMapping(value = "/searchStudent")
    @ResponseBody
    public BaseResult<StudentNexus> searchStudent(){

        List<StudentNexus> students = studentService.selectAll();

        /* 将查询到的结果集进行封装 */
        BaseResult<StudentNexus> result = new BaseResult<StudentNexus>();

        result.setTotal(100);

        result.setData(students);

        return result;
    }

    /* 分页查询
     * student:用来接收前端传递过来的参数 */
    @RequestMapping(value = "/limitStudent")
    @ResponseBody
    public BaseResult<StudentNexus> limitStudent(int pageIndex, int pageSize, StudentNexus student){

        /* 调用分页查询业务 */
        BaseResult<StudentNexus> result = studentService.pageSelect(pageIndex, pageSize, student);

        return result;

    }

}
