# Plot Worker Project

Task: Worker
Subject: Plot

## Introduction

- This project is a worker, he does several tasks on the background.
- His purpose is to get plot data from state base and store then properly on our plot databases.

## Running Purpose

### Image

The image can be pull on Docker Hub through this command.

```bash
docker pull orionbeauny/plot_worker_project
```

### Requirements

- This image needs a MySQL database to work correctly.
- These environments are requirement to be filled properly.

```bash
PERSISTENCE_HOST
PERSISTENCE_PORT
PERSISTENCE_USERNAME
PERSISTENCE_PASSWORD
PERSISTENCE_DATABASE
```

## Developing Purpose

### System Requirements

- Minimum hardware requirements
    - Java 17 or higher
- Operating system requirements
- Network requirements
    - Ethernet connection

### Installation

- Clone this repository

```bash
cd ./plot_worker_project
```

## Contributing

- This is a personal project, so any pull request would never be merged.
- No offense.

## License

[MIT](https://choosealicense.com/licenses/mit/)