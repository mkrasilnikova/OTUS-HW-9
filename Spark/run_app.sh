#!/bin/bash

echo "STARTING APPs"



# Run Spark Part1
${SPARK_HOME}/bin/spark-submit --class Part1 /usr/local/spark/app.jar \
    --conf spark.ui.prometheus.enabled=true \
    --conf spark.executor.processTreeMetrics.enabled=true \
    --conf spark.metrics.conf=${SPARK_HOME}/conf/metrics.properties

    # Run Spark Part2
${SPARK_HOME}/bin/spark-submit --class Part2 /usr/local/spark/app.jar \
    --conf spark.ui.prometheus.enabled=true \
    --conf spark.executor.processTreeMetrics.enabled=true \
    --conf spark.metrics.conf=${SPARK_HOME}/conf/metrics.properties

    # Run Spark Part3
${SPARK_HOME}/bin/spark-submit --class Part3 /usr/local/spark/app.jar \
    --conf spark.ui.prometheus.enabled=true \
    --conf spark.executor.processTreeMetrics.enabled=true \
    --conf spark.metrics.conf=${SPARK_HOME}/conf/metrics.properties

#    # Run custom python app with enabled metrics for Prometheus
##${SPARK_HOME}/bin/pyspark
#${SPARK_HOME}/bin/spark-submit app.py \
#    --conf spark.ui.prometheus.enabled=true \
#    --conf spark.executor.processTreeMetrics.enabled=true \
#    --conf spark.metrics.conf=${SPARK_HOME}/conf/metrics.properties


