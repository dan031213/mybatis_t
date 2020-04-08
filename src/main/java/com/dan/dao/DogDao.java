package com.dan.dao;

import com.dan.bean.Dog;
import com.dan.bean.Emp;
import org.apache.ibatis.annotations.Insert;

/**
 * @author lizhenyang
 * @desc
 * @create 2020-04-08 11:04
 */
public interface DogDao {

    Dog selectDogById(Integer id);
}
