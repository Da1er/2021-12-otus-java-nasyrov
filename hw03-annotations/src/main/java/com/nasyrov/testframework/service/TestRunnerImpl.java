package com.nasyrov.testframework.service;

import com.nasyrov.testframework.annotation.After;
import com.nasyrov.testframework.annotation.Before;
import com.nasyrov.testframework.annotation.Test;
import com.nasyrov.testframework.statistics.Statistics;
import com.nasyrov.testframework.statistics.StatisticsRegistrator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class TestRunnerImpl implements TestRunner {

    private final StatisticsRegistrator statisticsRegistrator;

    public TestRunnerImpl(StatisticsRegistrator statisticsRegistrator) {
        this.statisticsRegistrator = statisticsRegistrator;
    }

    @Override
    public Statistics run(String testClassName) {
        Class<?> testClass = getTestClass(testClassName);
        Method[] allClassMethods = testClass.getMethods();
        List<Method> beforeMethods = getAnnotatedMethods(allClassMethods, Before.class);
        List<Method> testMethods = getAnnotatedMethods(allClassMethods, Test.class);
        List<Method> afterMethods = getAnnotatedMethods(allClassMethods, After.class);
        statisticsRegistrator.setTotal(testMethods.size());
        for (Method testMethod : testMethods) {
            runTest(testClass, beforeMethods, afterMethods, testMethod);
        }
        return statisticsRegistrator.getStatistics();
    }

    private void runTest(Class<?> testClass, List<Method> beforeMethods, List<Method> afterMethods, Method testMethod) {
        try {
          Constructor<?> testClassConstructor = testClass.getConstructor();
          Object testClassObj = testClassConstructor.newInstance();
          for (Method beforeMethod : beforeMethods) {
              beforeMethod.invoke(testClassObj);
          }
          testMethod.invoke(testClassObj);
          for (Method afterMethod : afterMethods) {
              afterMethod.invoke(testClassObj);
          }
          statisticsRegistrator.registerSuccess();
        } catch (Exception ex) {
         statisticsRegistrator.registerFailure();
        }
    }

    private List<Method> getAnnotatedMethods(Method[] allMethods, Class<? extends Annotation> annotation)
    {
        return Arrays.stream(allMethods)
                .parallel()
                .filter(method -> method.isAnnotationPresent(annotation))
                .toList();
    }

    private Class<?> getTestClass(String testClassName) {
        try {
            return Class.forName(testClassName);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }


}
