 # Use uma imagem base com Java (OpenJDK)
# FROM openjdk:17-jdk-slim

# # Define o diretório de trabalho no contêiner
# WORKDIR /app

# # Copia o arquivo JAR gerado pelo Maven/Gradle para o contêiner
# COPY target/crud-spring-0.0.1-SNAPSHOT.jar app.jar

# # Define o comando para rodar a aplicação
# ENTRYPOINT ["java", "-jar", "app.jar"]
