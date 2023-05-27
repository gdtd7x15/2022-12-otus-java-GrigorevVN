package ru.grigorevvn.aop;

public class Main {
    public static void main(String[] args) {
        Logable Logable = Ioc.createLogableInstance();
        Logable.methodWithoutArgs();
        Logable.methodWithOneArg(7);
        Logable.methodWithTwoArgs(1, (short) 5);
        Logable.methodWithThreeArgs(71, (short) 5, true);
        Logable.methodWithoutLogging(444, (short) 44, false);
    }
}
