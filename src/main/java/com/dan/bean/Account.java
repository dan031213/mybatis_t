package com.dan.bean;

import lombok.*;

/**
 * @author lizhenyang
 * @desc
 * @create 2020-04-08 13:44
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Integer id;
    private String loginName;
    private String password;
    private String nickName;
    private Integer age;
    private String location;
    private String role;
}
