package com.xiaohei.service.impl;

import com.xiaohei.domain.BaseResult;
import com.xiaohei.domain.PageBean;
import com.xiaohei.domain.StudentNexus;
import com.xiaohei.mapper.StudentMapper;
import com.xiaohei.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    public List<StudentNexus> selectAll() {

        return studentMapper.selectAll();

    }

    public BaseResult<StudentNexus> pageSelect(int pageIndex, int pageSize, StudentNexus student) {

        BaseResult<StudentNexus> result = new BaseResult<StudentNexus>();

        PageBean<StudentNexus> pg = new PageBean<StudentNexus>();

        pg.setParameter(student);

        /* 获得总条数 */
        int total = studentMapper.getTotalRecord(pg);

        /* 构建分页对象 */
        PageBean<StudentNexus> pageBean =
                new PageBean<StudentNexus>(pageIndex + 1,pageSize,total);

        /* 更新分页查询中的参数 */
        pageBean.setParameter(student);

        /* 获取当前页数据 */
        List<StudentNexus> data = studentMapper.limitSelect(pageBean);

        /* 设置总记录数与当前页data数据设置到BaseResult对象中 */
        result.setTotal(total);
        result.setData(data);

        return result;
    }


}
