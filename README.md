# **Sonar Reporting Application**

## Overview

The Sonar Reporting Application is a Java and Spring Boot project that generates monthly PDF reports using the openpdf library. It leverages the SONARQUBE API to retrieve information about resolved issues and newly created issues within the last month.

## Tech Stack

- `Java 21`
- `Spring Boot 3.2.3`
- `OpenPDF`
- `SonarQube API`
- `Docker`
- `Docker Compose`
- `Slack API`

## Configuration

Update the docker-compose.yml file with your SonarQube server details.
Customize any other settings as needed.

## Build and Run

Follow the steps below to run the system locally.

```bash
git clone https://github.com/muratcanyeldan/sonar-reporter.git
cd sonar-reporter
mvn clean install
docker compose up -d
```