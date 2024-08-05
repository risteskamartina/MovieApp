FROM maven:3.8.5-openjdk-17

WORKDIR /app
COPY . /app

RUN mvn clean install -DskipTests

ADD https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh /usr/local/bin/wait-for-it
RUN chmod +x /usr/local/bin/wait-for-it

CMD ["wait-for-it", "movieapp-db:5432", "--", "mvn", "spring-boot:run"]
