#FROM maven:3.6.3-openjdk-17-slim
#WORKDIR /opt
#ENV PORT 8081
#EXPOSE 8081
#COPY target/*.jar /opt/app.jar
#ENTRYPOINT exec java $JAVA_OPTS -jar app.jar
FROM maven:3.6.3-openjdk-17-slim as build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -B -f pom.xml clean package -DskipTests
# production stage
FROM openjdk:17-slim
COPY --from=build /workspace/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","app.jar"]