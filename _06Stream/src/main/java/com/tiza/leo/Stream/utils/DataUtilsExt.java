package com.tiza.leo.Stream.utils;

import com.tiza.leo.Stream.beans.Employee;
import com.tiza.leo.Stream.beans.EmployeeExt;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: tz_wl
 * Date: 2020/8/16 15:04
 * Content:
 */
public class DataUtilsExt {
    private static List<EmployeeExt> emps = new ArrayList<>();

    static {
        emps.add(new EmployeeExt(1L, "Morton", 22, 8000.0));
        emps.add(new EmployeeExt(2L, "Dahlia", 20, 13000.0));
        emps.add(new EmployeeExt(3L, "Babb", 23, 7000.0));
        emps.add(new EmployeeExt(4L, "Rice", 21, 15000.0));
        emps.add(new EmployeeExt(5L, "Handy", 26, 13000.0));
        emps.add(new EmployeeExt(6L, "Rudy", 30, 14000.0));
        emps.add(new EmployeeExt(7L, "Grady", 27, 12000.0));
        emps.add(new EmployeeExt(8L, "Brenton", 32, 6000.0));
        emps.add(new EmployeeExt(9L, "Vinson", 33, 7000.0));
        emps.add(new EmployeeExt(10L, "Kemp", 23, 14000.0));
        emps.add(new EmployeeExt(11L, "Sebastian", 22, 12000.0));
        emps.add(new EmployeeExt(12L, "Evangeline", 24, 18000.0));
        emps.add(new EmployeeExt(13L, "Lisette", 29, 8000.0));
        emps.add(new EmployeeExt(14L, "Wilkes", 25, 7000.0));
        emps.add(new EmployeeExt(15L, "Leach", 33, 6000.0));
        emps.add(new EmployeeExt(16L, "Geiger", 32, 12000.0));
        emps.add(new EmployeeExt(17L, "Holden", 34, 13000.0));
        emps.add(new EmployeeExt(18L, "Thorpe", 26, 15000.0));
        emps.add(new EmployeeExt(19L, "Adrienne", 23, 16000.0));
        emps.add(new EmployeeExt(20L, "Calderon", 51, 14000.0));
        emps.add(new EmployeeExt(20L, "Calderon", 51, 14000.0));
    }
    public static List<EmployeeExt> getEmployees() {
        return emps;
    }
}
