package com.sparta.mb;

public class Printer {

    public static void  initialDatabaseSize(int databaseSize){
        System.out.println("There are " + databaseSize + " entries in the database");
    }

    public static void  databaseSizeAfterRemoval(int databaseSize){
        System.out.println("There are " + databaseSize + " entries in the database after duplicate removal");
    }

    public static void  databaseWriteTime(long timeTaken){
        System.out.println("Database written in: " + timeTaken + " milliseconds");
    }

}
