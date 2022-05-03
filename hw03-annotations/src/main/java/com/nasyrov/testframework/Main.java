package com.nasyrov.testframework;

import com.nasyrov.testframework.service.TestRunner;
import com.nasyrov.testframework.service.TestRunnerImpl;
import com.nasyrov.testframework.statistics.Statistics;
import com.nasyrov.testframework.statistics.StatisticsRegistrator;
import com.nasyrov.testframework.statistics.TestStatisticsRegistratorImpl;

public class Main {

    public static final String S_TEST_CLASS_NAME = "com.nasyrov.testframework.test.TestClassImpl";

    public static void main(String[] args) {
        StatisticsRegistrator statisticsRegistrator = new TestStatisticsRegistratorImpl();
        TestRunner testRunner = new TestRunnerImpl(statisticsRegistrator);
        Statistics testExecStatistics = testRunner.run(S_TEST_CLASS_NAME);
        System.out.println(testExecStatistics);
    }

}
