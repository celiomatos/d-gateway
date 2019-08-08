FROM openjdk:8u191-jre-alpine3.8
WORKDIR /app
ENV TZ=America/Manaus
RUN apk add tzdata
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
COPY d-gateway.war .
CMD echo "172.18.0.3      d-server-eureka" >> /etc/hosts && java -jar d-gateway.war