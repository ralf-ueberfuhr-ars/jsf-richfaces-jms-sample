# Java Server Faces with RichFaces and JMS - Sample

[![CI Build](https://github.com/ralf-ueberfuhr-ars/jsf-richfaces-jms-sample/actions/workflows/ci.yml/badge.svg)](https://github.com/ralf-ueberfuhr-ars/jsf-richfaces-jms-sample/actions/workflows/ci.yml)

## Introduction

The generation of the executable jar file can be performed by issuing the following command


    mvn clean package

This will create an executable jar file **richfaces-jms-sample.jar** within the _target_ maven folder. This can be started by executing the following command

    java -jar target/richfaces-jms-sample.jar


### Liberty Dev Mode

During development, you can use Liberty's development mode (dev mode) to code while observing and testing your changes on the fly.
With the dev mode, you can code along and watch the change reflected in the running server right away; 
unit and integration tests are run on pressing Enter in the command terminal; you can attach a debugger to the running server at any time to step through your code.

    mvn liberty:dev

To launch the test page, open your browser at the following URL

    http://localhost:9080/index.html  

## JMS

We can use Active MQ in a [Docker container](https://hub.docker.com/r/rmohr/activemq):

```bash
docker pull rmohr/activemq
docker run -p 61616:61616 -p 8161:8161 rmohr/activemq
```

Then, we can access the web UI using `http://localhost:8161/`.
For this sample, we need a topic named `blogpost-events`.
(administrative credentials are `admin` / `admin`)

A Jakarta EE / Liberty based consumer can be found [here](consumer).

Samples with different messaging systems can be found in this 
[GitHub-Repository](https://github.com/ueberfuhr-trainings/messaging-samples).
