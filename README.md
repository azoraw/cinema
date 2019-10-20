### setup
* download and install mongodb (preferably 4.2) 
* application will connect to db in default port 27017 
* run gradlew build (gradle wrapper is included)
* runnable jar file with application should be in path: build/libs
* run that jar file in order to run application
* demo shell script can be found in scripts/script.sh (notice that script.sh is depending on data.json)
##### Intellij setup (only for development):
* import via gradle in order to download all dependencies 
* install plugin: lombok 
* enable annotation processing in File | Settings | Build, Execution, Deployment | Compiler | Annotation Processors 
* run gradle build
* run spring boot task (main class  is  com.zoraw.cinema.CinemaApplication)
### Assumptions 
* cinema room consists of seats that are placed in rows and columns
* between any seats we can have corridor. In that case seat is marked as 'edge'
* rows need to be unique strings and columns unique integers
* neighbour seats should have the same row and columns should differ by one. 

###TODOs:
* AOP handlers for prettier rest exception handling (do not return whole stack trace)
* Security (impl some logic for cutting DDoS attacks,...)
* Add Mongobee for ChangeSets functionality (sth like liquibase)
* Separate Api for returning Seats layout for given room
