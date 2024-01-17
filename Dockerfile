# 1º estágio
# chamado `build-image`, imagem JDK temporária para compilar o código
FROM maven:3-openjdk-17 as build-image
# define o diretório de trabalho
WORKDIR /app
# copia o código-fonte para o diretório de trabalho
COPY . .
# executa o comando de empacotamento do maven
RUN ./mvnw clean package

# 2º estágio
# com imagem JRE, limpa e mais leve
FROM eclipse-temurin:17-jre-alpine
# copia o jar gerado no primeiro estágio para o diretório de trabalho
COPY --from=build-image /app/target/*.jar /app/app.jar
# expõe a porta 8080
EXPOSE 8080
# define o comando de execução da aplicação
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# comando para construir a imagem expondo a porta 8080
# docker build -t spring-boot-docker -f Dockerfile .

# comando para executar a imagem
# docker run -p 8080:8080 spring-boot-docker

# comando para executar a imagem em background
# docker run -d -p 8080:8080 spring-boot-docker

# comando para executar a imagem em background com nome
# docker run -d -p 8080:8080 --name spring-boot-docker spring-boot-docker

# comando para executar a imagem em background com nome e volume
# docker run -d -p 8080:8080 --name spring-boot-docker -v /home/fernando/ideaProjects/projects/spring-boot-docker/logs:/app/logs spring-boot-docker

# comando para executar a imagem em background com nome, volume e variável de ambiente
# docker run -d -p 8080:8080 --name spring-boot-docker -v /home/fernando/ideaProjects/projects/spring-boot-docker/logs:/app/logs -e LOG_PATH=/app/logs spring-boot-docker

# comando para executar a imagem em background com nome, volume, variável de ambiente e rede
# docker run -d -p 8080:8080 --name spring-boot-docker -v /home/fernando/ideaProjects/projects/spring-boot-docker/logs:/app/logs -e LOG_PATH=/app/logs --network=host spring-boot-docker

# comando para executar a imagem em background com nome, volume, variável de ambiente, rede e healthcheck
# docker run -d -p 8080:8080 --name spring-boot-docker -v /home/fernando/ideaProjects/projects/spring-boot-docker/logs:/app/logs -e LOG_PATH=/app/logs --network=host --health-cmd="curl -f http://localhost:8080/actuator/health || exit 1" --health-interval=5s --health-retries=3 --health-timeout=2s spring-boot-docker

# comando para executar a imagem em background com nome, volume, variável de ambiente, rede, healthcheck e restart
# docker run -d -p 8080:8080 --name spring-boot-docker -v /home/fernando/ideaProjects/projects/spring-boot-docker/logs:/app/logs -e LOG_PATH=/app/logs --network=host --health-cmd="curl -f http://localhost:8080/actuator/health || exit 1" --health-interval=5s --health-retries=3 --health-timeout=2s --restart=always spring-boot-docker

# comando para executar a imagem em background com nome, volume, variável de ambiente, rede, healthcheck, restart e limites de memória
# docker run -d -p 8080:8080 --name spring-boot-docker -v /home/fernando/ideaProjects/projects/spring-boot-docker/logs:/app/logs -e LOG_PATH=/app/logs --network=host --health-cmd="curl -f http://localhost:8080/actuator/health || exit 1" --health-interval=5s --health-retries=3 --health-timeout=2s --restart=always -m 512M --memory-swap=1G spring-boot-docker