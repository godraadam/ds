FROM openjdk:17
WORKDIR /dsproject
COPY . .
RUN chmod +x ./gradlew

# build the application jar
RUN ./gradlew assemble

ENV DB_IP :ec2-52-209-246-87.eu-west-1.compute.amazonaws.com
ENV DB_PORT :5432
ENV DB_USER :ahztgqmjarqktn
ENV DB_PASSWORD :5eaba1ff094dc957efdda479b7ac7219885fab7a20c63cb05617acd6844a820d
ENV DB_NAME :d45go7pldb1o92

#expose port 8080
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "./build/libs/ds-assingment-0.0.1-SNAPSHOT.jar"]