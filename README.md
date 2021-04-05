### DreamTrack

### Description

Currently, this application is limited to utilizing certain RESTful API endpoints. As time goes on, this application will allow a user to track the dreams they've had quickly when they wake up.

### Tools/Technologies Used

* RESTful API endpoints

* Repositores

* JPA Repositories

* Services

* Controllers

* Java Entity Class POJOs Modeling Database Tables

* Mapping POJOS Using JPA

* Spring Rest Annotations

* Use Spring Data JPA To Perform CRUD Ops

* Sending/Receiving JSON

* MySQL Database Schemas

* Gradle

* Spring Boot

### RESTful API Endpoints

http://3.140.26.22:8080/DreamTrack/'ENDPOINT'

| Find Dream By User Id & Is Active      | Create Dream | Update Dream     |
| :---        |    :----:   |          ---: |
| GET      | Post       | Put   |
| api/user/{userId}/{isActive}/dreams   | api/user/{userId}/dreams        | api/user/{userId}/{dreamId}/dreams      |
