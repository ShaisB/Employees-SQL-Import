package com.sparta.mb;

public class Timer {

    public long startTime(){
        return System.currentTimeMillis();
    }

    public long timeTaken(long startTime){
        return System.currentTimeMillis() - startTime;
    }

}
