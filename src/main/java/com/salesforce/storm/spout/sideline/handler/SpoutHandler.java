package com.salesforce.storm.spout.sideline.handler;

import com.salesforce.storm.spout.sideline.FactoryManager;
import com.salesforce.storm.spout.sideline.metrics.MetricsRecorder;

import java.util.Map;

public interface SpoutHandler {

    default void open(Map config, FactoryManager factoryManager, MetricsRecorder metricsRecorder) {

    }

    default void close() {

    }

    default void onSpoutOpen() {

    }

    default void onSpoutClose() {

    }
}
