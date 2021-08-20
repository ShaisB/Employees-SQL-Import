package com.sparta.mb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DuplicatePurger {

    public static ArrayList<Employee> purgeDuplicates(ArrayList<Employee> employees){

        ArrayList<Employee> employeesPurged = new ArrayList<>();
        Set<String> id = new HashSet();

        ArrayList<Employee> purged = new ArrayList<>();

        for (Employee employee : employees){
            if(id.add(employee.getEmployeeID())){
                employeesPurged.add(employee);
            }
        }

        return employeesPurged;
    }

}
