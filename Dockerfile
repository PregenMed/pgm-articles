FROM openjdk:17-oracle
LABEL authors="mateusz-ochab"
RUN addgroup -S app && adduser -S app -G app
USER app
#
#RUN apt-get -y update; apt-get install -y sudo; apt-get install -y git wget
#RUN echo "Jenkins ALL=NOPASSWD: ALL" >> /etc/sudoers
#RUN wget http://get.docker.com/builds/Linux/x86_64/docker-latest.tgz
#RUN tar -xvzf docker-latest.tgz
#RUN mv docker/* /usr/bin/

COPY ./target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]