package com.xiaohei.service;

import com.xiaohei.domain.BaseResult;
import com.xiaohei.domain.StudentNexus;

import java.util.List;

public interface StudentService {

    List<StudentNexus> selectAll();

    /**
     * 分页查询
     * @param pageIndex 页码 从0开始
     * @param pageSize 每页显示的条数
     * @param student 包含条件的实体类
     * @return 返回包含total和data的数据
     */
    BaseResult<StudentNexus> pageSelect(int pageIndex, int pageSize, StudentNexus student);

}
