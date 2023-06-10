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
PERSISTENCE_HOST
PERSISTENCE_PORT
PERSISTENCE_USERNAME
PERSISTENCE_PASSWORD
PERSISTENCE_DATABASE
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
mvn clean package
```

- Then, you can run the jar command.

```bash
java -jar ./target/plot_manager.jar -Dspring.profiles.active=local
```

## Contributing

- This is a personal project, so any pull request would never be merged.
- No offense.

## License

[MIT](https://choosealicense.com/licenses/mit/)