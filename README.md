# amor(WIP)
> Like microservice providing a simple REST API in conjunction with Kafka.

*Maintainer: Joel Roxell &lt;joel.roxell@na-kd.com&gt;*

[TL;DR](#api)

## TOC
<!-- TOC depthFrom:2 depthTo:6 widthLinks:1 upateOnSave:1 orderedList:0 -->

- [Dependencies](#dependencies)
- [API](#api)
	- [Create Like](#create-like)
- [Development](#development)
	- [Prerequisites](#prerequisites)
	- [Setup](#setup)
	- [Tools & Scripts](#tools-scripts)
- [Environment](#environment)
- [Contributing](#contributing)

<!-- /TOC -->

## Dependencies
- Kafka
- MongoDB
- Redis

## API
This service provides a JSON REST API.

### Create Like
**POST /like**
Creates a new like.
:
**REQUEST BODY**

** NOTE:** `time` must be a string that can be parsed by `Date()`
```json
{
  "entity": "<string required>",
  "userIds": "<[string]>"
}
```

**RESPONSE**

HTTP 201 - *Like successfully created*
```json
{ "message": "success" }
```

HTTP 400 - *Severity input invalid*
```json
{ "message": "invalid request body" }
```

### Add User Like

### Remove User Like

### Update Like TYPE

## Models

### User

### Like

## Development
### Prerequisites
To be able to get this project up and running, you'll need:
* Docker
* Docker Compose
* Maven

### Usage
Follow these steps to get going:
* `git clone git@github.com:JoelRoxell/amor.git`
* `mvn package`
* `docker-compose up`

### Tools & Scripts
| **SCRIPT**            | **USAGE**                                           | **CAVEATS**
|----------------------:|-----------------------------------------------------|-------------
|**mvn clean**          | Runs all unit tests using mocha                     |            |
|**mvn package**        | Build a new jar file with dependecies.              |            |

## Environment
| **VARIABLE** | **DESCRIPTION**                                                      |
|-------------:|----------------------------------------------------------------------|
|**NODE_ENV**  |Sets the application to either **production** or **development** mode |
|**LOG_FILE**  |Decides where our log file will be stored                             |

## Contributing
This service has the following standards & workflows:
* Master branch should always be ready to deploy to production
* Pull requests with failing tests will be closed.
* This document should be filled out and up to date.

### Testing
TODO