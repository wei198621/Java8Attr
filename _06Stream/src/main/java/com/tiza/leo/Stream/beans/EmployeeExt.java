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
public class EmployeeExt implements Comparable{
    private Long id;
    private String name;
    private Integer age;
    private Double salary;

    @Override
    public int compareTo(Object o) {
        if (o instanceof EmployeeExt) {
            EmployeeExt e = (EmployeeExt) o;
            return this.age - e.getAge();
        } else {
            throw new RuntimeException("类型不正确");
        }
    }
}
