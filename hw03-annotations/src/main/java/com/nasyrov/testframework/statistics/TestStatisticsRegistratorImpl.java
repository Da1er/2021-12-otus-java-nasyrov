package com.nasyrov.testframework.statistics;

public class TestStatisticsRegistratorImpl implements StatisticsRegistrator {

    private final TestStatisticsImpl testStatistics;

    public TestStatisticsRegistratorImpl() {
        testStatistics = new TestStatisticsImpl();
    }

    @Override
    public void registerFailure() {
        testStatistics.incFailed();
    }

    @Override
    public void registerSuccess() {
        testStatistics.incSucceded();
    }

    @Override
    public void setTotal(int total) {
        testStatistics.setTotal(total);
    }

    @Override
    public Statistics getStatistics() {
        return testStatistics;
    }

    private static class TestStatisticsImpl implements Statistics {

        private long succededTestCount = 0;
        private long failedTestCount = 0;
        private long totalTestCount = 0;

        @Override
        public long getSucceded() {
            return succededTestCount;
        }

        @Override
        public long getFailed() {
            return failedTestCount;
        }

        @Override
        public long getTotal() {
            return totalTestCount;
        }

        @Override
        public String toString() {
            return String.format("""
                            Result of %d test executions:\r
                            Succeded: %d\r
                            Failed: %d""",
                    totalTestCount, succededTestCount, failedTestCount);
        }


        private void incSucceded() {
            succededTestCount++;
        }

        private void incFailed() {
            failedTestCount++;
        }

        private void setTotal(int totalTestCount) {
            this.totalTestCount = totalTestCount;
        }

    }

}
