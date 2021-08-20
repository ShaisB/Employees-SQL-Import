package com.sparta.mb;

import com.sparta.mb.jdbc.ConnectionManager;
import com.sparta.mb.jdbc.EmployeeDAO;
import com.sparta.mb.util.PropertiesLoader;

import java.util.ArrayList;
import java.util.List;

public class Loader {

    public static void loader() {

        String data = PropertiesLoader.getProperties().getProperty("database");

        ArrayList<Employee> employees = CsvFileReader.fileToArrayList(data);

        Printer.initialDatabaseSize(employees.size() - 1);

        ArrayList<Employee> purged = DuplicatePurger.purgeDuplicates(employees);

        Printer.databaseSizeAfterRemoval(purged.size() - 1);

        EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionManager.connectToDB());

        int startIndex = 1;

        int desiredThreads = Scanner.getNumberOfThreads();

        if (desiredThreads == 1) {
            long startTimeInMs = System.currentTimeMillis();
            SqlWriter.writeToDatabase(purged, employeeDAO);
            long timeTakenInMs = System.currentTimeMillis() - startTimeInMs;
            int timeInSeconds = (int) (timeTakenInMs / 1000);

            Printer.databaseWriteTime(timeInSeconds);
        } else {

            ArrayList<List> splitArrays = ArraySplitter.split(purged, desiredThreads - 1);


            //checking all the data was successfully divided
            //some log here
            long startTimeInMs = System.currentTimeMillis();

            ThreadManager.threadManager(desiredThreads, splitArrays);

            long timeTakenInMs = System.currentTimeMillis() - startTimeInMs;
            int timeInSeconds = (int) (timeTakenInMs / 1000);

            Printer.databaseWriteTime(timeInSeconds);


        }

    }

}
