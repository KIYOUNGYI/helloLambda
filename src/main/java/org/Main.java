package org;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionalSpringApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        FunctionalSpringApplication.run(Main.class, args);
    }
}
