#!/usr/bin/env bash
rm /home/hampay/jmeter-logs/backend-report.jtl
rm /home/hampay/jmeter-logs/backend.log
$JMETER_HOME/bin/jmeter -n -t /var/lib/jenkins/jobs/hampay-core-functional-test/workspace/build-test-artifacts/back-end-functional.jmx -l /home/hampay/jmeter-logs/backend-report.jtl -j /home/hampay/jmeter-logs/backend.log -JmobileNo=827 -Jusers=1 -Jduration=1


