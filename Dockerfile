FROM openjdk:17-slim

WORKDIR /app

COPY target/*.jar /app/a2back.jar
COPY wait-for-it.sh /wait-for-it.sh

RUN chmod +x /wait-for-it.sh
#ENTRYPOINT ["java", "-jar", "/a2back.jar"]

EXPOSE 8080

CMD ["java", "-jar", "a2back.jar"]
