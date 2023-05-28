package ru.grigorevvn.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        private final List<String> annotatedMethodSignatures;

        DemoInvocationHandler(Logable logable) {
            this.logable = logable;
            this.annotatedMethodSignatures = Arrays.stream(logable.getClass().getMethods())
                    .filter(method -> method.isAnnotationPresent(Log.class))
                    .map(this::getMethodSignature)
                    .collect(Collectors.toList());
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if(annotatedMethodSignatures.contains(getMethodSignature(method))) {
                String argsStr = args != null ? Arrays.toString(args) : "[] (without arguments)";
                System.out.println("executed method: " + method.getName() + " " + argsStr);
            }
            return method.invoke(logable, args);
        }

        private String getMethodSignature(Method method) {
            return method.getName() + " " + Arrays.toString(method.getParameters());
        }
    }
}