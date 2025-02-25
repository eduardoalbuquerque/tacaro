# Etapa 1: Use a imagem base do Gradle mais recente
FROM gradle:8.12.1-jdk17 AS builder

# Defina o diretório de trabalho dentro do container
WORKDIR /app

# Copie os arquivos do seu projeto para dentro do container
COPY . .

# Dê permissão de execução ao Gradle Wrapper (caso não tenha)
RUN chmod +x ./gradlew

# Baixe as dependências primeiro para otimizar o cache do Docker
RUN ./gradlew dependencies --no-daemon

# Execute o comando Gradle para construir o JAR (geralmente gerado em build/libs)
RUN ./gradlew bootJar --no-daemon

# Etapa 2: Use uma imagem mais leve para rodar a aplicação (JDK 17)
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho dentro do container
WORKDIR /app

# Copie o JAR gerado na etapa anterior para o container
COPY --from=builder /app/build/libs/*.jar tacaro.jar

# Exponha a porta em que o Spring Boot irá rodar
EXPOSE 8080

# Comando para rodar a aplicação Spring Boot
ENTRYPOINT ["java", "-jar", "tacaro.jar"]
