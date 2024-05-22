# BattleShip
This is a desktop version of the classic board game called BattleShip.

This project was implemented as a group project for the CS 320 course offered at Özyeğin University during the Spring Term of 2024.

# Run on Your Machine

## Prerequisites
1. **Java Development Kit (JDK)**: Ensure you have JDK installed on your machine. You can download it from [Oracle's official site](https://www.oracle.com/java/technologies/javase-downloads.html) or use a package manager:
    - **macOS**: `brew install openjdk`
    - **Linux**: Use your distribution's package manager, e.g., `sudo apt-get install openjdk-11-jdk`
    - **Windows**: Download from [Oracle's official site](https://www.oracle.com/java/technologies/javase-downloads.html)

## Instructions

### Using Command Line

#### Clone the Repository
Open your terminal (Command Prompt on Windows) and execute the following commands:

```sh
git clone https://github.com/FurkanOzdemir33759/BattleShip.git
cd BattleShip
```

#### Compile the Project

Navigate to the directory containing your src folder. Compile the Java files using the following command:

```sh
javac -d out -sourcepath src src/Main.java
```
#### Run the Project

Run the compiled main class using the following command:

```sh
java -cp out Main
```

### Platform Specific Notes

#### Linux and macOS

1. Ensure you have the necessary permissions to execute the scripts/commands. If needed, you can change file permissions using **chmod**, e.g., **chmod +x filename**.
2. Use a terminal application to run the commands.

#### Windows
1. Use Command Prompt or PowerShell to run the commands.
2. Ensure the environment variables are set correctly for Java. You can set the **JAVA_HOME** and update the **Path** variable in the System Properties.


# References
<!-- too add new reference =>  * [_REF-#: <Reference Title>_](<Reference link>) -->
* [_REF-1: Battleship (game)_](https://en.wikipedia.org/wiki/Battleship_(game))
* [_REF-2: Problem Statement: Battleship Game_](https://github.com/anomaly2104/battleship-game-low-level-design/blob/master/problem-statement.md)
* [_REF-3: Battleship - Design and Implementation_](https://rucforsk.ruc.dk/ws/portalfiles/portal/57612924/Report_formatted.pdf)
* [_REF-4: BattleShip Software Development Plan_](https://drive.google.com/drive/folders/1Zom2Gl5OUx4tThcSrvZhr8bPr_KC3VFl?usp=sharing)
* [_REF-5: BattleShip Software Requirements Specification_](https://drive.google.com/drive/folders/1Zom2Gl5OUx4tThcSrvZhr8bPr_KC3VFl?usp=sharing)
* [_REF-6: BattleShip Software Test Plan_](https://drive.google.com/drive/folders/1Zom2Gl5OUx4tThcSrvZhr8bPr_KC3VFl?usp=sharing)
* [_REF-7: BattleShip Software Design Document_](https://drive.google.com/drive/folders/1Zom2Gl5OUx4tThcSrvZhr8bPr_KC3VFl?usp=sharing)



