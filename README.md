# Word Square App

Java application that generates a valid word square from the user's input.

## Structure

* **README.md** : this file
* **wordSquare / Main.java** : The file that executes the program.
* **wordSquare / wordSquareLogic** : Directory that contains the logic to generate the word square.
* **test / java / wordSquare / wordSquareLogic** : Directory for unit tests.

## Cloning the repository from GitHub
Please request access to the Git repository from myself.

## Running the application from the command line.
* Once the project has been cloned, we can compile the Java files and run the application using Gradle. Runnning this command from the root directory of the project to run the app with the specified arguments ```gradle run args="n xxxxxxxxxx"``` (n being the number of rows / columns of the word square and the second argument being the valid letters to create a word square).

## Running the unit tests
* To run the JUnit tests, type ```gradle test``` in the command line.

## Following word squares to test:

```gradle run args="4 aaccdeeeemmnnnoo"```
```gradle run args="5 aaaeeeefhhmoonssrrrrttttw"```
```gradle run args="5 aabbeeeeeeeehmosrrrruttvv"```
```gradle run args="7 aaaaaaaaabbeeeeeeedddddggmmlloooonnssssrrrruvvyyy"```


