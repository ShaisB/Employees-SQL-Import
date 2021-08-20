package com.sparta.mb.jdbc;

public interface SQLQueries {

    String INSERT_INTO = "INSERT INTO `user_db`.`employees_test` (`employeeID`, `title`, `firstName`, `middleInitial`, `surname`, `gender`, `email`, `dob`, `joined`, `salary`) VALUES (?,?,?,?,?,?,?,?,?,?) ";
    String SELECT_ALL = "SELECT * FROM user_db.employees_test";
    String TRUNCATE = "TRUNCATE user_db.employees_test";


}
