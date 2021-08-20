package com.sparta.mb;

import com.sparta.mb.jdbc.ConnectionManager;
import com.sparta.mb.jdbc.EmployeeDAO;

import java.util.ArrayList;
import java.util.List;

public class SqlWriter extends Thread{

    private List<Employee> employees;
    private EmployeeDAO employeeDAO;

    public SqlWriter(List<Employee> employees, EmployeeDAO employeeDAO) {
        this.employees = employees;
        this.employeeDAO = employeeDAO;
    }

    public void writeToDatabase(){
        int i = 0;
        int numberOfEmployees = employees.size();

        while(i < numberOfEmployees) {
            employeeDAO.createRecord(employees.get(i));
            i++;
        }
    }

    @Override
    public void run() {
        writeToDatabase();
    }

    public static void writeToDatabase(List<Employee> employees, EmployeeDAO employeeDAO){
        int i = 1;
        int numberOfEmployees = employees.size();

        while(i < numberOfEmployees) {
            employeeDAO.createRecord(employees.get(i));
            i++;
        }
    }

    public static void writeToDatabase(ArrayList<Employee> employees, EmployeeDAO employeeDAO){
        int i = 1;
        int numberOfEmployees = employees.size();

        while(i < numberOfEmployees) {
            employeeDAO.createRecord(employees.get(i));
            i++;
        }
    }

}
