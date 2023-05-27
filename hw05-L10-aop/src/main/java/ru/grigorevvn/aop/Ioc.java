package ru.grigorevvn.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

public class Ioc {
    public Ioc() {
    }

    static Logable createLogableInstance() {
        InvocationHandler handler = new DemoInvocationHandler(new LogImpl());
        return (Logable) Proxy.newProxyInstance(Logable.class.getClassLoader(),
                new Class[]{Logable.class}, handler);
    }

    static class DemoInvocationHandler implements InvocationHandler {
        private final Logable logable;

        DemoInvocationHandler(Logable logable) {
            this.logable = logable;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if(method.isAnnotationPresent(Log.class)) {
                String argsStr = args != null ? Arrays.toString(args) : "[] (without arguments)";
                System.out.println("executed method: " + method.getName() + " " + argsStr);
            }
            return method.invoke(logable, args);
        }
    }
}