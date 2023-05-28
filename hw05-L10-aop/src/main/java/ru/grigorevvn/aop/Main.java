package ru.grigorevvn.aop;

public class Main {
    public static void main(String[] args) {
        Logable logable = Ioc.createLogableInstance();
        logable.methodWithoutArgs();
        logable.methodWithOneArg(7);
        logable.methodWithTwoArgs(1, (short) 5);
        logable.methodWithThreeArgs(71, (short) 5, true);
        logable.methodWithoutLogging(444, (short) 44, false);
    }
}
