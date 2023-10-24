package lhjava.quickstart;

import io.littlehorse.sdk.worker.LHTaskMethod;

public class Greeter {

    @LHTaskMethod("greeting")
    public String greet(String name) {
        System.out.println("Calling with input: " + name);
        return "Hello, " + name + "!";
    }
}
