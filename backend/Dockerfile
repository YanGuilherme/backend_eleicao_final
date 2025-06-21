FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 80
ENTRYPOINT ["java", "-jar", "app.jar"]

