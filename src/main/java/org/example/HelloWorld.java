package org.example;

public class HelloWorld {

    /**
     * aws lambda => org.example.HelloWorld::helloWorld
     *
     * @return
     */
    public String helloWorld() {
        return "helloWorld";
    }

    /**
     * aws lambda => json 말고 문자열 넣어도 실행됨
     *
     * @param param
     * @return
     */
    public String helloParamWorld(String param) {
        return param + "_world";
    }

    /**
     * 아직은 방법 못찾음
     *
     * @param param1
     * @param param2
     * @return
     */
    public String helloTwoParamsWorld(String param1, String param2) {
        return param1 + "_" + param2 + "_world";
    }

    /**
     * private method working?
     * <p>
     * aws lambda => org.example.HelloWorld::privateHelloWorld
     * * *
     * {g
     * "errorMessage": "No public method named privateHelloWorld with appropriate method signature found on class org.example.HelloWorld"
     * }
     */
    private String privateHelloWorld() {
        return "privateHelloWorld";
    }

    /**
     * private method working?
     */
    protected String protectedHelloWorld() {
        return "protectedHelloWorld";
    }
}
