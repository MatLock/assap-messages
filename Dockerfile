FROM gradle:4.7.0-jdk8-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon 

EXPOSE 8080

CMD ["gradle","run","-p","/home/gradle/src"] 

