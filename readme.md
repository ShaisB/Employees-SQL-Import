# Employees SQL Import Project  

## About  

This project aims to read a csv file, remove any duplicates and write all the remaining data into an SQL database as fast as possible. It does this by making use of threads, allowing it to write multiple entries to the database simultaneously.

## How to use  

Clone the repo and edit properties.properties to include your User Name, Password, Database Connection URL and the path to your csv file. Save the .properties file and run the program.  

Your csv file should be comma delimited, in the format:  
Emp ID,Name Prefix,First Name,Middle Initial,Last Name,Gender,E Mail,Date of Birth,Date of Joining,Salary
  
When running the program you will be told how many entries are in your database and how many are in the database after duplicates have been removed. You will then be prompted to enter the number of threads you would like to use.  
  
## Future features

Truncate stable on start up
Date to be entered as a DATE rather than a VARCHAR.  
Add tests  
