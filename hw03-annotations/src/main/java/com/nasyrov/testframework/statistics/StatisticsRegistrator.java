package com.nasyrov.testframework.statistics;

public interface StatisticsRegistrator {

    void registerFailure();

    void registerSuccess();

    void setTotal(int total);

    Statistics getStatistics();

}
