package com.sparta.mb.jdbc;

import com.sparta.mb.Employee;

import java.sql.*;

public class EmployeeDAO {

    //create
    //read
    //update
    //delete

    private Connection connection;
    private Statement statement;

    public EmployeeDAO(Connection connection){
        this.connection = connection;
        try {
            statement = connection.createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void printAllUsers(){
        try {
            ResultSet resultSet = statement.executeQuery(SQLQueries.SELECT_ALL);
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
            }
    }catch (SQLException e){
        e.printStackTrace();
        }
    }

    public void createRecord(Employee employee){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.INSERT_INTO);
            preparedStatement.setInt(1, Integer.parseInt(employee.getEmployeeID()));
            preparedStatement.setString(2, employee.getTitle());
            preparedStatement.setString(3, employee.getFirstName());
            preparedStatement.setString(4, employee.getMiddleInitial());
            preparedStatement.setString(5, employee.getSurname());
            preparedStatement.setString(6, employee.getGender());
            preparedStatement.setString(7, employee.getEmail());
            preparedStatement.setString(8, employee.getDob());
            preparedStatement.setString(9, employee.getJoined());
            preparedStatement.setInt(10, Integer.parseInt(employee.getSalary()));
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
