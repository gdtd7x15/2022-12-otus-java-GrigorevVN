package ru.grigorevvn;

import ru.grigorevvn.annotations.After;
import ru.grigorevvn.annotations.Before;
import ru.grigorevvn.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {
//    java -jar hw03-L06-annotations-1.0-SNAPSHOT.jar FirstTestClass SecondTestClass
    public static void main(String[] args) {
        System.out.println("Hello Otus! Let's start!");

        Runner runner = new Runner();
        RunnerStatistic statistic = new RunnerStatistic();

        Arrays.asList(args).forEach(arg -> runner.runTestClass(arg, statistic));

        System.out.println(statistic);
    }

    private void runTestClass(String className,RunnerStatistic statistic) {
        try {
            String testPackageName = getClass().getPackage().getName() + '.' + "testClasses";
            Class<?> clazz = findClass(testPackageName, className);
            List<Method> beforeMethods = findMethodsByAnnotation(clazz.getDeclaredMethods(), Before.class);
            List<Method> afterMethods = findMethodsByAnnotation(clazz.getDeclaredMethods(), After.class);
            List<Method> testMethods = findMethodsByAnnotation(clazz.getDeclaredMethods(), Test.class);
            for (Method method : testMethods) {
                runTestMethod(clazz, beforeMethods, method, afterMethods, statistic);
            }
        } catch (ClassNotFoundException classNotFoundException) {
            statistic.addError(String.format("Class %s not found:", className), "", classNotFoundException.getCause().toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Class<?> findClass(String packageName, String className) throws ClassNotFoundException {
        return Class.forName(packageName + "." + className);
    }

    private List<Method> findMethodsByAnnotation(Method[] methods, Class<? extends Annotation> annotationClass) {
        return Arrays.stream(methods).filter(method -> method.isAnnotationPresent(annotationClass)).collect(Collectors.toList());
    }

    private void runTestMethod(Class<?> clazz, List<Method> beforeMethods, Method method, List<Method> afterMethods, RunnerStatistic statistic) {
        try {
            Object object = clazz.getDeclaredConstructor().newInstance();
            try {
                runConfigMethods(object, clazz.getSimpleName(), beforeMethods, statistic);
                runTestedMethod(object, clazz.getSimpleName(), method, statistic);
            } finally {
                runConfigMethods(object, clazz.getSimpleName(), afterMethods, statistic);
            }
        } catch (Exception e) {
            statistic.addFailed(clazz.getSimpleName(), method.getName());
            statistic.addError(clazz.getSimpleName(), method.getName(), e.getCause().toString());
        }
    }

    private void runConfigMethods(Object object, String className, List<Method> methods, RunnerStatistic statistic) {
        for (Method method : methods) {
            try {
                method.invoke(object);
            } catch (Exception e) {
                statistic.addError(className, method.getName(), e.getCause().toString());
            }
        }
    }

    private void runTestedMethod(Object object, String className, Method method,RunnerStatistic statistic) throws InvocationTargetException, IllegalAccessException {
            method.invoke(object);
            statistic.addSuccess(className, method.getName());
    }
}
