package com.dan.bean;

import lombok.*;

import java.lang.annotation.Target;
import java.util.Date;

/**
 * @author lizhenyang
 * @desc
 * @create 2020-04-08 10:55
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private Integer empno;
    private String ename;
    private String job;
    private String mgr;
    private Date hiredate;
    private double sal;
    private double comm;
    private Integer depno;
}
