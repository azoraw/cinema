### setup
* download and install mongodb (preferably 4.2 )
##### Intellij setup:
* import via gradle in order to download all dependencies 
* install plugin: lombok 
* enable annotation processing in File | Settings | Build, Execution, Deployment | Compiler | Annotation Processors 
* run gradle build

### Assumptions 

* cinema room consists of seats that are placed in rows and columns
* between any seats we can have corridor. In that case seat is marked as 'edge'
* rows need to be unique strings and columns unique integers
* neighbour seats should have the same row and columns should differ by one. 