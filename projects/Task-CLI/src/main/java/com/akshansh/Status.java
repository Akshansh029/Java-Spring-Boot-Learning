package com.akshansh;

public enum Status{
    TODO("todo"), IN_PROGRESS("in-progress"), DONE("done");

    private final String stat;

    Status(String stat){
        this.stat = stat;
    }

    public String getStat(){
        return stat;
    }
}
