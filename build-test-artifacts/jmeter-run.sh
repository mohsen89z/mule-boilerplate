#!/bin/bash

HAMPAY_CORE_REPORT_HOME=$HAMPAY_REPORT_HOME/hampay-core/jmeter
if [ ! -d "$HAMPAY_CORE_REPORT_HOME" ]; then
mkdir -p "$HAMPAY_CORE_REPORT_HOME"
chmod -R 777 "$HAMPAY_CORE_REPORT_HOME"
fi

TEST_FNAME="User-Tests"

$JMETER_HOME/bin/jmeter.sh -n -t $1/${TEST_FNAME}.jmx -l $HAMPAY_CORE_REPORT_HOME/${TEST_FNAME}.jtl -j $HAMPAY_CORE_REPORT_HOME/${TEST_FNAME}.log

mkdir -p $1/jmeter-reports
chmod -R 777 $1/jmeter-reports

cp  $HAMPAY_CORE_REPORT_HOME/${TEST_FNAME}.jtl $1/jmeter-reports/
cp $HAMPAY_CORE_REPORT_HOME/${TEST_FNAME}.log  $1/jmeter-reports/

chmod 777 $HAMPAY_CORE_REPORT_HOME/${TEST_FNAME}.jtl
chmod 777 $HAMPAY_CORE_REPORT_HOME/${TEST_FNAME}.log
