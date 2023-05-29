package ru.grigorevvn.aop;

public class LogImpl implements Logable {
    @Log
    @Override
    public void methodWithoutArgs() {

    }

    @Log
    @Override
    public void methodWithOneArg(int first) {

    }

    @Log
    @Override
    public void methodWithTwoArgs(int first, short second) {

    }

    @Log
    @Override
    public void methodWithThreeArgs(int first, short second, boolean third) {

    }

    @Override
    public void methodWithoutLogging(int first, short second, boolean third) {

    }
}
