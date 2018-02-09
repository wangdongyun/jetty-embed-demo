#!/usr/bin/env bash

##这真的是一个demo 大量的参数需要指定
WORK_DIR=`dirname $0`

#切换到当前目录
cd ${WORK_DIR}

cd ..

CURRENT_PATH=`pwd`

java -cp .:WEB-INF/classes:WEB-INF/lib/* jetty.war.OneWebApp ${CURRENT_PATH}

