package com.nasyrov.testframework.service;

import com.nasyrov.testframework.statistics.Statistics;

@FunctionalInterface
public interface TestRunner {

    Statistics run(String testClassName);

}
