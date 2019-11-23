# ASAPP Chat Backend Challenge v1
### Overview
This is a java based boilerplate which runs an HTTP Server configured to answer the endpoints defined in 
[the challenge you received](https://asappinc.github.io/challenge-backend/).
All endpoints are configured in src/main/java/com/asapp/backend/challenge/Application.java and if you go deeper to the
Routes and Filters passed as second parameters, you will find a TODO comment where you are free to implement your solution.


### Build Docker image
```
docker build -t assap/test .  
```

### How to run it
```
docker run -d -p 8080:8080 assap/test:latest 
```

