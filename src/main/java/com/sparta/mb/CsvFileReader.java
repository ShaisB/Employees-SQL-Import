package com.sparta.mb;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CsvFileReader {

    public static void readFromFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.out.println(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromFileScanner(String fileName) {
        File file = new File(fileName);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int i = 0;
        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
            System.out.println(i);
            i++;
        }
        scanner.close();
    }

    public static ArrayList<Employee> fileToArrayList(String fileName) {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        File file = new File(fileName);
        Scanner scanner = null;
        String[] splitLine = null;
        int employeeNumber;
        int salary;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int i = 0;
        while (scanner.hasNextLine()){
                splitLine = scanner.nextLine().split(",");
                //employeeNumber = Integer.parseInt(splitLine[0]);
                //salary = Integer.parseInt(splitLine[9]);
                employees.add(new Employee(splitLine[0],splitLine[1],splitLine[2],splitLine[3],splitLine[4],splitLine[5],splitLine[6],splitLine[7],splitLine[8],splitLine[9]));
                //System.out.println(i);
                i++;
        }
        scanner.close();
        return employees;
    }


}
