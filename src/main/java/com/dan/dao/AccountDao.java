package com.dan.dao;

import com.dan.bean.Account;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author lizhenyang
 * @desc
 * @create 2020-04-08 11:04
 */
public interface AccountDao {

    Account selectById(Integer id);

    ArrayList<Account> selectAll();

    @MapKey("loginName")
    Map<String, Account> selectAllToMap();

    ArrayList<Account> selectAccountByNameAndPwd(@Param("loginName") String loginName, @Param("password") String password);

    ArrayList<Account> selectAccountByNameAndPwd2(Map map);

    Integer addAccount(Account account);
}
