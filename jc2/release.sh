#!/bin/bash
mvn release:clean
mvn -e -DperformRelease=true release:prepare
mvn -e -DperformRelease=true release:perform
