package com.sparta.mb;

import com.sparta.mb.jdbc.ConnectionManager;
import com.sparta.mb.jdbc.EmployeeDAO;
import com.sparta.mb.util.PropertiesLoader;

import java.util.ArrayList;
import java.util.List;

public class Loader {

    public static void loader(){

        String data = PropertiesLoader.getProperties().getProperty("database");

        ArrayList<Employee> employees = CsvFileReader.fileToArrayList(data);

        System.out.println("There are " + (employees.size() - 1) + " entries in the database");

        ArrayList<Employee> purged = new ArrayList<Employee>();
        purged = DuplicatePurger.purgeDuplicates(employees);

        System.out.println("There are " + (purged.size() - 1) + " entries in the database after duplicate removal");

        EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionManager.connectToDB());

        //long startTimeInMs = System.currentTimeMillis();
        //SqlWriter.writeToDatabase(purged, employeeDAO);
        //long timeTakenInMs = System.currentTimeMillis() - startTimeInMs;

        //int timeInSeconds = (int) (timeTakenInMs/1000);

        //System.out.println("Database written in: " + timeInSeconds + " seconds");

        int startIndex = 1;

/*        ArrayList<Employee> quarter = ArraySplitter.splitArray(purged,startIndex, purged.size()/4);
        startIndex =+ purged.size()/4;
        ArrayList<Employee> half = ArraySplitter.splitArray(purged,startIndex, purged.size()/2);
        startIndex =+ purged.size()/2;
        ArrayList<Employee> threeQuarters = ArraySplitter.splitArray(purged, startIndex, (purged.size()*3)/4);
        startIndex =+ (purged.size()*3)/4;
        ArrayList<Employee> remainder = ArraySplitter.splitArray(purged,startIndex, purged.size() - 1);*/


        //checking all the data was successfully divided
        //some log here


        ArrayList<List> splitArrays = ArraySplitter.split(purged, 3);


        //checking all the data was successfully divided
        //some log here

        SqlWriter writer1 = new SqlWriter(splitArrays.get(0), employeeDAO);
        Thread thread1 = new Thread(writer1);
        SqlWriter writer2 = new SqlWriter(splitArrays.get(1), employeeDAO);
        Thread thread2 = new Thread(writer2);
        SqlWriter writer3 = new SqlWriter(splitArrays.get(2), employeeDAO);
        Thread thread3 = new Thread(writer3);
        SqlWriter writer4 = new SqlWriter(splitArrays.get(3), employeeDAO);
        Thread thread4 = new Thread(writer4);


        long startTimeInMs = System.currentTimeMillis();

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //SqlWriter.writeToDatabase(splitArrays.get(0), employeeDAO);
/*        SqlWriter.writeToDatabase(quarter, employeeDAO);
        SqlWriter.writeToDatabase(half, employeeDAO);
        SqlWriter.writeToDatabase(threeQuarters, employeeDAO);
        SqlWriter.writeToDatabase(remainder, employeeDAO);*/


        long timeTakenInMs = System.currentTimeMillis() - startTimeInMs;
        int timeInSeconds = (int) (timeTakenInMs/1000);

        System.out.println("Database written in: " + timeInSeconds + " seconds");

        //System.out.println(employees.toString());



    }

}
