FROM markhobson/maven-chrome:jdk-11

#Copy root folder of the project
COPY pom.xml /home/simple-docker/
COPY src /home/simple-docker/src/
RUN ls /home/simple-docker/
RUN mvn -f home/simple-docker/pom.xml clean test -DskipTests=true