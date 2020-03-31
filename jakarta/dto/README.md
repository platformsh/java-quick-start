# mongodb-demo

A JNoSQL Atemis project with Java SE using Document API with MongoDB as driver implementation.

![MongoDB Project](http://www.jnosql.org/img/logos/mongodb.png)


**Mongodb**: MongoDB is a free and open-source cross-platform document-oriented database program. Classified as a NoSQL database program, MongoDB uses JSON-like documents with schemas.


To run this project a MongoDB instance is required, so you can use either a local instalation or using Docker.


## Manual instalation

Follow the instructions in: https://docs.mongodb.com/manual/installation/


## Using Docker

![Docker](https://www.docker.com/sites/default/files/horizontal_large.png)


1. Install docker: https://www.docker.com/
1. https://store.docker.com/images/mongo
1. Run docker command
1. Run MongoDB: verify MongoDB image name with the command `docker images`, it can be mongodb or mongo, and then execute this command:
   `docker run -d --name mongodb-instance -p 27017:27017 mongo`
   
## Start the Application

* `mvn clean package payara-micro:bundle`
* `java -jar target/microprofile-microbundle.jar`


## Run the tests


* `curl -X POST -H 'Content-Type: application/json' -i http://localhost:8080/users --data '{"birthday":"2020-03-10","languages":["Portuguese"],"nickname":"otaviojava","salary":"USD 10000"}'`
* `curl -X POST -H 'Content-Type: application/json' -i http://localhost:8080/users --data '{"birthday":"1980-03-10","languages":["Portuguese", "English"],"nickname":"elderjava","salary":"EUR 100000"}'`
* `{"birthday":"1800-03-10","languages":["Portuguese", "English"],"nickname":"brjavamana","salary":"USD 100000000"}`