## Build docker image
docker build -t testimage .

## Run docker container
docker run -it  testimage mvn -f /home/simple-docker/pom.xml clean test -Dbrowser="chrome"