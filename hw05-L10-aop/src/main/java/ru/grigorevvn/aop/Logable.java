package ru.grigorevvn.aop;

public interface Logable {
    @Log
    void methodWithoutArgs();
    @Log
    void methodWithOneArg(int first);
    @Log
    void methodWithTwoArgs(int first, short second);
    @Log
    void methodWithThreeArgs(int first, short second, boolean third);
    void methodWithoutLogging(int first, short second, boolean third);
}
