# Simple spark and mongo api java example

_You need run mongodb at **localhost:27017** to run this project_

## Install
`` mvn clean install ``

## Package
`` mvn clean package ``

_uses maven-shade-plugin to generate a .jar with all dependencies_

## Run
`` java -jar target/spark-api-1.0-SNAPSHOT.jar ``

## The api end points:
 * http://localhost:4567/init-users (Add some users in database)
 * http://localhost:4567/get-users (Gat all users from database)

## Todo

* Add jongo http://jongo.org/ to map java objects to mongo documents
* Unit test
* Add logs