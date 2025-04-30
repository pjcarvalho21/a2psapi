FROM openjdk:17-slim

WORKDIR /app

COPY target/*.jar /app/a2back.jar

#ENTRYPOINT ["java", "-jar", "/a2back.jar"]

EXPOSE 8080

CMD ["java", "-jar", "a2back.jar"]
