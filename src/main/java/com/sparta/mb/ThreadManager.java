package com.sparta.mb;

import com.sparta.mb.jdbc.ConnectionManager;
import com.sparta.mb.jdbc.EmployeeDAO;

import java.util.ArrayList;
import java.util.List;

public class ThreadManager {

    public static void threadManager(int desiredThreads, ArrayList<List> splitArrays){

        Thread[] threads = new Thread[desiredThreads];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new SqlWriter(splitArrays.get(i), new EmployeeDAO(ConnectionManager.connectToDB())));
            threads[i].start();
        }
        try {
            for (int j = 0; j < threads.length; j++) {
                threads[j].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
