#!/bin/bash
export HSQLDB_LIB=hsqldb-1.8.0.7.jar
java -classpath $HSQLDB_LIB org.hsqldb.Server -database.0 file:projet1 -port 9003

