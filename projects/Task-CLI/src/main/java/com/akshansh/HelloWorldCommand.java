package com.akshansh;

import picocli.CommandLine;

@CommandLine.Command(
        name = "hello",
        description = "says hello"
)
public class HelloWorldCommand implements Runnable{
    @Override
    public void run(){
        System.out.println("Hello World");
    }

    public static void main(String[] args) {
        CommandLine.run(new HelloWorldCommand(), args);
    }
}
