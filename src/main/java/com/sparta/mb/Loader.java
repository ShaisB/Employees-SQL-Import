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

        employeeDAO.truncate();

        int desiredThreads = Scanner.getNumberOfThreads();

        Timer timer = new Timer();

        if (desiredThreads == 1) {
            long startTimeInMs = timer.startTime();
            SqlWriter.writeToDatabase(purged, employeeDAO);
            long timeTaken = timer.timeTaken(startTimeInMs);
            Printer.databaseWriteTime(timeTaken);
        } else {

            ArrayList<List> splitArrays = ArraySplitter.split(purged, desiredThreads - 1);

            long startTimeInMs = timer.startTime();

            ThreadManager.threadManager(desiredThreads, splitArrays);

            long timeTaken = timer.timeTaken(startTimeInMs);

            Printer.databaseWriteTime(timeTaken);


        }

    }

}
