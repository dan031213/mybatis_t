package com.dan.dao;

import com.dan.bean.Account;

import java.util.ArrayList;

/**
 * @author lizhenyang
 * @desc
 * @create 2020-04-08 11:04
 */
public interface AccountDao {

    Account selectById(Integer id);

    ArrayList<Account> selectAll();
}
