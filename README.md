## TicTacToe

This is my implementation of Tic-Tac-Toe using Java & JavaFX on a Apple Silicon Macbook.

## To Do
1. Decriptive Variable Names (Done)
2. No Magic Numbers
3. Inline Comments

## Features

Version 1 Features:
1. Launching the app opens the Main Menu where you can start a new game (Done)
2. Implement the game and logic behind it (Done)
3. When the game ends it returns you to Main Menu (Done)

Version 2 Features:
- Add pause menu while in a game that allows you to return to the main menu (Done)
- Allow selection of names instead of player 1 and player 2 (Done)
- Add a score next to names in footer (Done)
- Show winning screen for player 1 or 2, or draw screen and allow play again or return to menu (Done)

Version 3 Features:
- Add option to view rules from Main Menu (Done)
- Add option to view rules from Pause Menu (Done)
- Improve UI and UX (Done)
- Add are you sure you want to quit? Menu (Done)

Potential Future Updates:

Version 4 Features:
- Indicate which player's turn it is
- keep same score and names if play again is selected 
- Add an option to save a game and load it from a file
- show timestamp of when game was saved and allow sorting
- Add single player and multiplayer
- Easy/medium/hard single player using random number generator

Version 5 Features:
- Add pop-up when new game starts that asks for name, settings, game format, etc.
- Add a leaderboard or stats based on the name chosen
- Add error messages (when someone clicks on a tile already used, name is inappropriate, etc.)

Version 6 Features:
- Add login, server, and database
- Allow person to play from multiple devices
- Allow two people from different devices to play against each other online

Features:
1. UI (Game Board, Tiles, Xs/Os, Title of Game, Player One/Two, Score, etc.)
2. Game Logic
2. Pause Menu (Restart, End Game)

## Troubleshooting Tips

1. Preferably use VS Code on a Apple Silicon Macbook.
2. Check to see if you have java installed on your device by running the    command 'java --version' in your terminal (without the '').
3. If your java version is less than 13 or you get the error message "No Java Runtime Present", download the correct version of Java for your device from https://www.oracle.com/java/technologies/downloads/.
4. Make sure you have the correct version of JavaFX for your device downloaded on your device from https://gluonhq.com/products/javafx/.
5. Delete all the files in the lib folder of this project and copy over all the files from your newly downloaded JavaFX lib folder into the lib folder of this project.
6. Update the path in .vscode/launch.json to reflect where your new JavaFX lib folder is located on your computer.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.