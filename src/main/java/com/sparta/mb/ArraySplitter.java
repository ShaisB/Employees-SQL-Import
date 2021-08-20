package com.sparta.mb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArraySplitter {


    public static ArrayList<List> split(ArrayList<Employee> employee, int numOfSplit) {
        int employeesPerArray = employee.size() / numOfSplit;
        ArrayList<List> splitArrays = new ArrayList<List>();
        for (int i = 1; i <= employee.size(); i += employeesPerArray) {
            if (i + (employeesPerArray - 1) > employee.size()) {
                splitArrays.add((employee.subList(i, i + (employee.size()) - i)));
            } else {
                splitArrays.add((employee.subList(i, i + employeesPerArray)));
            }
        }
        return splitArrays;
    }


}
