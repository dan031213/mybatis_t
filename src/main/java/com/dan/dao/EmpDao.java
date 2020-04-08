package com.dan.dao;

import com.dan.bean.Emp;
import org.apache.ibatis.annotations.Insert;

/**
 * @author lizhenyang
 * @desc
 * @create 2020-04-08 11:04
 */
public interface EmpDao {

    @Insert("insert into emp(empno,ename) values(#{empno},#{ename})")
    Integer save(Emp emp);

    Integer update(Emp emp);

    Integer delete(Integer empno);

    Emp selectEmpByEmpno(Integer empno);
}
