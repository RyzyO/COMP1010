## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

# COMP1010 Major Assingment - Music Player

## Project overview

This java based music library allows users to interact with a playlist of predefined tracks using a single command line interface. The player supports standard music navigation features such as playing the next or previous track, toggling shuffle mdoe, and exiting the application.

## Features
Track navigation: Move to next or previous track in the list
Shuffle mode: Enable or disable shuffle mode, allowing tracks to be played randomly
Track information: Displays track details such as title, artist, duration, track number and genre
User interaction: Commands are entered through the console to control track navigation
Exit functionality: User can quit the application by typing a specific command

# How to run the program

## Prerequisites 
To run this program you will need;
    - A terminal or command line interface (VS Code works fine)
    - Java Development Kit (JDK) version 8 or higher

## Program Flow
1. When the program starts, it initialises a list of predefined tracks, and the first track is played by default.
2. The current track information is displayed, including the song title, artist, duration, track number, and genre.
3. The user is prompted to input a command to navigate through the tracks or enable shuffle mode.
4. In shuffle mode, tracks are randomly selected, ensuring the same track is not played consecutively
5. Users can continue to navigate through the track list or exit the program by typing q.

## Track Class
Each track in the player is an instance of the Track class. The following properties are available for each track:
    - Title: The name of the track.
    - Artist: The name of the performing artist.
    - Album: The Album that the track is from.
    - Duration: The length of the track in seconds.
    - Track Number: The unique identifier for each track in the track list.
    - Genre: The music genre of the track (e.g, Pop, Rock, Dance Pop).

## Commands
The program listens for the following inputs from the user:
    - n: Move to the next track in the track selection.
    - p: Go back to the previous track.
    - s: Toggle shuffle mode on or off.
    - q: Quit the music player

## Shuffle Mode
Shuffle mode enables randomised playback of tracks. When shuffle is enabled, the system selects a random track from the playlist, ensuring the same track is not played twice in a row. You toggle shuffle mode by pressing the s key.

## Example Usage
Upon running the program, the user will see an output like this;

COMP1010 Major Assignment
Now Playing: 
Track: Never Gonna Give You Up
Artist: Risk Astley
Album: Whenever You Need Somebody
Duration: 211 seconds
Genre: Pop
Enter n for next track, p for previous track, q to quit or s to enable shuffle

    - If the user types n, the next track is played (Unless it's the last track).
    - If the user types p, the previous track is played (Unless it's the first track).
    - If the user types s, shuffle mode is toggled on/off.
    - If the user types q, the player will display a goodbye message and terminate.

## Playlist Creation
Create a playlist by typing "save" in the terminal. You will then be prompted to name your file however you want just make sure to add .csv at the end. After which you can start adding tracks to the playlist. You will then be prompted to one of three choices.

    - If the user types a, the current track they are playing will be added to the playlist.
    - If the user types r, to rename the current playlist with all the tracks.
    - If the user types d, it will display all the tracks in the playlist csv file you just created.

You can add tracks by going through the track playlist by entering "n" or "p" and when you reach a track you like simply enter "a" to add it to your playlist when. When you are staisfied with your current playlist type save again and re enter the name of the file you created. You can then see the playlist you created by entering "d" into the terminal.

## Exit The Program
To exit the player, enter q in the command line. The program will output:
    Exiting  player. Goodbye!  
