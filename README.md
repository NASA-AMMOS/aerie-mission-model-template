# Aerie Mission Model Template

This repo provides an Aerie mission model template for a fictitious mission called Firesat. It is meant as a starting off point for building a new mission model.

## Prerequisites

- Install [OpenJDK Temurin LTS](https://adoptium.net/temurin/). If you're on OSX you can use [brew](https://brew.sh/):

  ```sh
  brew install --cask temurin
  ```

  Make sure you update your `JAVA_HOME` environment variable. For example with [Zsh](https://www.zsh.org/) you can set your `.zshrc` to:

  ```sh
  export JAVA_HOME="/Library/Java/JavaVirtualMachines/temurin-19.jdk/Contents/Home"
  ```

- Set `GITHUB_USERNAME` and `GITHUB_TOKEN` environment variables so you can download the Aerie Maven packages from the [GitHub Maven package registry](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry). For example with Zsh you can set your `.zshrc`:

  ```sh
  export GITHUB_USERNAME=""
  export GITHUB_TOKEN=""
  ```

## Building

To build a mission model JAR you can upload into Aerie you can do:

```sh
./gradlew build # Outputs 'build/libs/firesat.jar'
```

## Testing

To run unit tests under [src/test](./src/test) against your mission model you can do:

```sh
./gradlew test
```
