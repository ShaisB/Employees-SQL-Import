package com.sparta.mb;

public class Scanner {

    public static int getNumberOfThreads() {
        int desiredThreads = 1;
        java.util.Scanner keyboard = new java.util.Scanner(System.in);
        System.out.print("How many threads would you like to use? : ");
        try{
        desiredThreads = keyboard.nextInt();}
        catch (Exception e){
            System.out.println("Positive integers only please!");
            return getNumberOfThreads();
        }

        if (desiredThreads > 0){
            return desiredThreads;
        }
        else {
            System.out.println("Positive integers only please!\n");
            return getNumberOfThreads();
        }

    }

}
