# Aerie Mission Model Template

This repo provides an Aerie mission model template for a fictitious mission called [FireSat](http://www.sme-smad.com/). It is meant as a starting point for building a new mission model in Aerie.

## Prerequisites

- Install [OpenJDK Temurin LTS](https://adoptium.net/temurin/releases/?version=19). If you're on macOS, you can install [brew](https://brew.sh/) instead and then use the following command to install JDK 19:

  ```sh
  brew tap homebrew/cask-versions
  brew install --cask temurin19
  ```

  Make sure you update your `JAVA_HOME` environment variable. For example with [Zsh](https://www.zsh.org/) you can update your `.zshrc` with:

  ```sh
  export JAVA_HOME="/Library/Java/JavaVirtualMachines/temurin-19.jdk/Contents/Home"
  ```

- Set `GITHUB_USER` and `GITHUB_TOKEN` environment variables to your credentials (first you need to create a [personal access token](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/managing-your-personal-access-tokens#creating-a-personal-access-token-classic) in your GitHub account) so you can download the Aerie Maven packages from the [GitHub Maven package registry](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry). For example with Zsh you can update your `.zshrc` to set the variables with:

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
