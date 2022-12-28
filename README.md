# Aerie Mission Model Template

This repo provides an Aerie mission model template for a fictitious mission called [FireSat](http://www.sme-smad.com/). It is meant as a starting point for building a new mission model in Aerie.

## Prerequisites

- Install [OpenJDK Temurin LTS](https://adoptium.net/temurin/). If you're on OSX you can use [brew](https://brew.sh/):

  ```sh
  brew install --cask temurin
  ```

  Make sure you update your `JAVA_HOME` environment variable. For example with [Zsh](https://www.zsh.org/) you can update your `.zshrc` with:

  ```sh
  export JAVA_HOME="/Library/Java/JavaVirtualMachines/temurin-19.jdk/Contents/Home"
  ```

- Set `GITHUB_USER` and `GITHUB_TOKEN` environment variables so you can download the Aerie Maven packages from the [GitHub Maven package registry](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry). For example with Zsh you can update your `.zshrc` with:

  ```sh
  export GITHUB_USER=""
  export GITHUB_TOKEN=""
  ```

## Building

To build a mission model JAR you can do:

```sh
./gradlew build --refresh-dependencies # Outputs 'build/libs/firesat.jar'
```

You can then upload the JAR to Aerie using either the UI or API. If you want to just try the model without building it yourself you can [download it here](./firesat.jar).

## Testing

To run unit tests under [./src/test](./src/test) against your mission model you can do:

```sh
./gradlew test
```
