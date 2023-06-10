# Plot Manager

## Introduction

Plot manager has several functionality such as storing data about department and municipality to be able to also store data plot specific to an asked municipality. And also provide an API to outside. 

## What do you need ?

### 1. I want to run this project.

* You might that to run this project you will need a database.
* The one used here is MySQL.
* So, please start an MySQL server the way you want.

#### Image

The image can be pull on Docker Hub through this command.

```bash
docker pull orionbeauny/plot_manager
```

### Requirements

- If you want that the image worked properly, please provide these environment variables.

```bash
SPRING_DATASOURCE_DRIVER-CLASS-NAME : com.mysql.cj.jdbc.Driver
SPRING_DATASOURCE_URL : jdbc:mysql://localhost:3306/plot_manage_database
SPRING_DATASOURCE_USERNAME : root
SPRING_DATASOURCE_PASSWORD : root-password
SPRING_JPA_DATABASE-PLATFORM : org.hibernate.dialect.MySQLInnoDBDialect
```

### 2. I need to develop on this project.

### System Requirements

- Minimum hardware requirements
    - Java 17 or higher
    - Maven
- Network requirements
    - Ethernet connection

### Installation

- Clone this repository

```bash
cd ./plot_manager
```

- You need to update this file with your database properties.

```bash
application-local.yml
```

- And then you can build the project with maven.

```bash
./mvnw clean package
```

- Then, you can run the jar command.

```bash
java -jar ./target/plot_manager-0.0.1-SNAPSHOT.jar -Dspring.profiles.active=local
```

## Contributing

- This is a personal project, so any pull request would never be merged.
- No offense.

## License

[MIT](https://choosealicense.com/licenses/mit/)