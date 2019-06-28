FROM openjdk:8u191-jre-alpine3.8
WORKDIR /app
COPY d-gateway.war .
CMD echo "172.18.0.4      d-server-auth" >> /etc/hosts \
    && echo "172.18.0.3      d-server-admin" >> /etc/hosts \
    && echo "172.18.0.6      d-server-main" >> /etc/hosts \
    && java -jar d-gateway.war