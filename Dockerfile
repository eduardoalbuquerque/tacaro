# Etapa 1: Use a imagem base do Gradle
FROM gradle:7.3-jdk17 AS builder

# Defina o diretório de trabalho dentro do container
WORKDIR /app

# Copie os arquivos do seu projeto para dentro do container
COPY . .

# Execute o comando Gradle para construir o JAR (geralmente gerado em build/libs)
RUN gradle bootJar

# Etapa 2: Use uma imagem mais leve para rodar a aplicação (JDK 17)
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho dentro do container
WORKDIR /app

# Copie o JAR gerado na etapa anterior para o container
COPY --from=builder /app/build/libs/tacaro-1.0.0.jar tacaro.jar

# Exponha a porta em que o Spring Boot irá rodar
EXPOSE 8080

# Comando para rodar a aplicação Spring Boot
ENTRYPOINT ["java", "-jar", "tacaro.jar"]