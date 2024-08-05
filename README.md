# Aerie Template

This repo provides an Aerie mission model template, which is meant as a starting point for building a new mission model in Aerie.
Included in this repo is all the basic infrastructure required to generate a mission model `.jar` file.

#### Interested in learning how to develop a model yourself?
Check out the [Aerie Mission Modeling Tutorial](https://nasa-ammos.github.io/aerie-docs/tutorials/mission-modeling/introduction/)

#### Looking for some example models to play around with?
Try out the following models:
- [Simple Power Model](https://github.com/NASA-AMMOS/aerie-simple-model-power)
- [Tutorial Model](https://github.com/NASA-AMMOS/aerie-modeling-tutorial)
- Simple Data Model (coming soon)


## Prerequisites

- Install [OpenJDK Temurin LTS](https://adoptium.net/temurin/releases/?version=21). If you're on macOS, you can install [brew](https://brew.sh/) instead and then use the following command to install JDK 21:

  ```sh
  brew install --cask temurin@21
  ```

  First you need to create a [personal access token](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/managing-your-personal-access-tokens#creating-a-personal-access-token-classic) in your GitHub account that includes `read-packages` scope) so you can download the Aerie Maven packages from the [GitHub Maven package registry](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry).

  Then, copy the `.env.template` file to `.env`. This `.env` file will hold your `GITHUB_TOKEN` and `GITHUB_USER` variables. Note that this file is "`.gitignore`d" by default, so edits to this file won't be tracked in version control.

  Open up `.env` and fill in the just the missing variables with your Github information:

  ```sh
  # in .env file
  GITHUB_USER="your_github_username_here"
  GITHUB_TOKEN="your_personal_access_token"
  ```

## Building

To build a mission model JAR you can do:

```sh
./gradlew :missionmodel:build --refresh-dependencies
```

This will create the file `'missionmodel/build/libs/missionmodel.jar`, which you can upload to Aerie using the UI or API.

<!-- If you want to just try the model without building it yourself you can [download it here](./missionmodel.jar). -->

## Testing

To run unit tests under [./missionmodel/src/test](./missionmodel/src/test) against your mission model you can do:

```sh
./gradlew :missionmodel:test
```
