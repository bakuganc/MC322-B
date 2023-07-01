#!/bin/sh 

set -xe 
clear
mvn package
java -jar target/Seguradora-1.0.jar
