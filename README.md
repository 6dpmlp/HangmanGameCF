# HangmanGameCF

## Overview
HangmanGameCF is an implementation of the classic Hangman game with the help of Java's Collection Framework.

## Features
- **Random Word Selection**: Words are randomly selected from a predefined file.

## Installation
1. Clone the repository:
    ```sh
    git clone https://github.com/6dpmlp/HangmanGameCF
    ```
2. Navigate to the project directory:
    ```sh
    cd HangmanGameCF
    ```
3. Compile the project:
    ```sh
    javac -d bin src/*.java
    ```
4. Run the game:
    ```sh
    java -cp bin Main
    ```

## Usage
1. Start the game by running the `Main` class.
2. Guess the word by entering one letter at a time.
3. The game will display the current state of the word and the wrong guesses are listed.

## Code Structure
- **Main.java**: The entry point of the application.
- **QuitException.java**: The class helps the user to quit during the game.
- **Session.java**: Responsible for arranging one session.
- **TargetSetter.java**: Reads the Words.txt file from the root folder and randomly chooses the word to find.
- **UserInfo.java**: Informs the user about the rules of the game.
