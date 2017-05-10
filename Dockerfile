FROM java:8
EXPOSE 8080
ADD /target/AccountsService.jar AccountsService.jar
ENTRYPOINT [ "java", "-jar", "AccountsService.jar" ]