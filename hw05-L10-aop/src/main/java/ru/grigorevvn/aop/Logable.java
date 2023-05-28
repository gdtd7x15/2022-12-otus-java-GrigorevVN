package ru.grigorevvn.aop;

public interface Logable {
    void methodWithoutArgs();
    void methodWithOneArg(int first);
    void methodWithTwoArgs(int first, short second);
    void methodWithThreeArgs(int first, short second, boolean third);
    void methodWithoutLogging(int first, short second, boolean third);
}
