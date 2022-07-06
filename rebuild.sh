#!/bin/zsh

mvn clean

mvn package

cd cygg-item-starter

docker-compose up