# Aerie Template

This repo provides a basic template for getting started with mission modeling and scheduling within the Aerie framework.

Included in this repo is all the basic infrastructure and scaffolding required to generate a mission model `.jar` file, as well as scheduling procedure `.jar`s that can be uploaded and run within Aerie.

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

### Mission Model
To build a mission model JAR you can do:

```sh
./gradlew :missionmodel:build --refresh-dependencies
```

This will create the file `'missionmodel/build/libs/missionmodel.jar`, which you can upload to Aerie using the UI or API.

<!-- If you want to just try the model without building it yourself you can [download it here](./missionmodel.jar). -->

### Scheduling Procedures
To build scheduling procedures, first you will need a completed mission model. You can accomplish this by following the [Aerie Mission Modeling Tutorial](https://nasa-ammos.github.io/aerie-docs/tutorials/mission-modeling/introduction/), or by using the included `complete-model-tutorial.patch`:

```sh
git apply complete-model-tutorial.patch
```

This is required since scheduling procedures will reference activity types (e.g. when placing activity directives), and the model in this repo, out of the box, has no registered activities.

Then, copy an example scheduling procedure into the procedures folder.

```sh
cp scheduling/examples/SampleProcedure.java scheduling/src/main/java/scheduling/procedures
```

(For a more involved example procedure, take a look at some [procedures in the Aerie repo](https://github.com/NASA-AMMOS/aerie/blob/develop/procedural/examples/foo-procedures/src/main/java/gov/nasa/ammos/aerie/procedural/examples/fooprocedures/procedures/StayWellFed.java))

The following will be your process every time you iterate on these procedures

```sh
./gradlew scheduling:compileJava
./gradlew scheduling:buildAllSchedulingProcedureJars
```

The first `gradle` command will expand `@SchedulingProcedure` annotations into new, verbose source code files that Aerie can process down the line.
The second `gradle` command then looks for those generated files, creates a task to build a `.jar` for each file, and then runs all those tasks.

Your procedure jars will then be in `scheduling/build/libs/OriginalSourceCodeFileName.jar`, which in this case will be `scheduling/build/libs/SampleProcedure.jar`.

## Running Procedures

Now that you have `.jar`'s, we need to upload them to Aerie so you can run them against plans.

The quickest way to upload a single JAR is to use the `aerie-ui`. On the `/scheduling/goals/new` page, you should now see a new tab option for creating a `jar` procedural goal. Once created, you will need to register the goal with a specific plan, just like you do with EDSL goals.

Then, from the manage goals page on your plan, you can pass arguments to your procedure using the drop down menu, and run your procedures using the schedule button. You can also right click to manage invocations (duplicate, delete, etc)

## Testing

To run unit tests under [./missionmodel/src/test](./missionmodel/src/test) against your mission model you can do:

```sh
./gradlew :missionmodel:test
```
