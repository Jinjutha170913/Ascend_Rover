# Ascend_Rover
ABOUT THE ASSIGNMENT:

  Robot takes commands from the user either in a file passed as an argument or from the command line. If no file is passed as an argument, commands will be taken from command line. Commands can be given to the Robot in any order and Robot will move/turn/report accordingly. Any invalid command or commands before a PLACE command or commands resulting in Robot moving out of the table will be ignored.
  
SPECIFICATIONS:

1. Write a code that read a file in specific format.
  1.1. First line will always be a size of a maps represent in integer only.
  1.2. After that will be an instruction to move or rotate.
    i. F: Forward command makes the Robot move one unit in the direction it is facing. Code has to make sure the move does not make the Robot fall off the table. For example, if Robot is placed in (0,0) coordinate facing N (NORTH), a move would result in moving the Robot north resulting in coordinates (0,1). Similarly, a move for a Robot facing E (EAST) with (0,0) coordinates will take the Robot to (1,0) position.
    ii. L: Left command makes the Robot turn to its left. If Robot is facing N (NORTH), a left turn will make it face W (WEST).
    iii. R: Right command makes the Robot turn to its right. If Robot is facing N (NORTH), a right turn will make it face E (EAST).
    iv. REPORT: A Report command to the Robot will print the current position of the Robot and the direction it is facing. If Report command is given to the Robot which is not placed on the Table, the code will announce that "Rover is not placed on the table".
    v. After the turning it should stay on the same block. Just direction is move.
    vi.  When commands are given to the program using command line, "EXIT" can be used to exit from the program.
2. Rover always start in position 0,0 with facing north.
3. A rover cannot be in negative position.
4. Rover should always report a current direction and position in format of {direction}:
{position-x},{position-y}
  a. N for North
  b. E for East
  c. W for West
  d. S for South
5. If rover reaching the edge it must maintain the direction and position.
6. Reference with the unit tests : https://github.com/SharvariNagesh/RobotProject

RUN THE CODE:

1. javac [file name].java
2. java [file name]
