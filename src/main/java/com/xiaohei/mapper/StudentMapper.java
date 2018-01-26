package com.xiaohei.mapper;

import com.xiaohei.domain.PageBean;
import com.xiaohei.domain.StudentNexus;

import java.util.List;

/* student操作的对外接口声明
 * 具体实现见Student.xml */
public interface StudentMapper {

    /* 查询所有学生列表
     * 方法名对应student.xml中的id属性
     * 方法参数对应student.xml中的parameterType属性
     * 方法返回值对应Student.xml中的resultType*/
    List<StudentNexus> selectAll();

    /* pageBean:包含分页信息对象 */
    List<StudentNexus> limitSelect(PageBean<StudentNexus> pageBean);

    /* 获取学生表总条数 */
    Integer getTotalRecord(PageBean<StudentNexus> pageBean);

}
