package com.tiza.leo.Stream.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: tz_wl
 * Date: 2020/8/16 15:04
 * Content:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private Integer age;
    private Double salary;


}
