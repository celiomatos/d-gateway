FROM openjdk:8u191-jre-alpine3.8
WORKDIR /app
COPY d-gateway.war .
CMD echo "172.17.0.3      d-server-auth\n172.17.0.4       d-server-main" >> /etc/hosts && java -jar d-gateway.war