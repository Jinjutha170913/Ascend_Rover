import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Rover {
	
    int map_size;			//size of map
	int x_position;			// x position of rover
	int y_position;			//y posotion of rover
	char direction;			//direction of rover
	
    public Rover(int map_size) {
		
        //Start Position of Rover is  N:(0,0)
		this.map_size = map_size;
		x_position=0;
		y_position=0;
		direction='N';
	}
	
    private void Forward() {
		
        //When current direction of Rover is North so increase y position
		if(direction=='N') {
			if(y_position+1>=0 && y_position+1<=map_size) {					//value of position is between 0 to map_size
				y_position++;
			}
		
        //When current direction of Rover is West so decrease x position
		}else if(direction=='W') {
			if(x_position-1>=0 && x_position-1<=map_size) {					//value of position is between 0 to map_size
				x_position--;
			}
		//When current direction of Rover is South so decrease y position
		}else if(direction=='S') {
			if(y_position-1>=0 && y_position-1<=map_size) {					//value of position is between 0 to map_size
				y_position--;
			}
		//When current direction of Rover is East so increase x position
		}else if(direction=='E') {
			if(x_position+1>=0 && x_position+1<=map_size) {					//value of position is between 0 to map_size
				x_position++;
			}
		}
	}
	
    private void TurnRight() {
		
        //When current direction of Rover is North so turnright to East
		if(direction=='N') {
			direction='E';
		
        //When current direction of Rover is East so turnright to South
		}else if(direction=='E') {
			direction='S';
		
        //When current direction of Rover is South so turnright to West
		}else if(direction=='S') {
			direction='W';
		
        //When current direction of Rover is West so turnright to North
		}else if(direction=='W') {
			direction='N';
		}
	}
	
    private void TurnLeft() {
		
        //When current direction of Rover is North so turnleft to West
		if(direction=='N') {
			direction='W';
		
        //When current direction of Rover is West so turnleft to South
		}else if(direction=='W') {
			direction='S';
		
        //When current direction of Rover is South so turnleft to East
		}else if(direction=='S') {
			direction='E';
		
        //When current direction of Rover is East so turnleft to North
		}else if(direction=='E') {
			direction='N';
		}
	}
	
    private void Report() {
		//Show Result --> Rover Position : {x_position},{y_position},{direction}
		System.out.println("Rover Position : "+x_position+","+y_position+","+Character.toString(direction));
	}
	
    public String toString() {
		//Show Result --> {direction}:{x_position},{y_position}
		return Character.toString(direction)+":"+x_position+","+y_position;
	}
	
    public static void main(String[] args) throws IOException {
		Rover rover = new Rover(0);	//initial
		int map_size;
		
        //** An input file. **
		if (args.length>0) {	
			
            //Read map size and commands from file
		    FileReader fr = new FileReader(new File(args[0]));
		    BufferedReader br=new BufferedReader(fr);    
		    String line;
		    int number_of_lines=0;
		   
            while((line=br.readLine())!=null) {  
		    	
                if(number_of_lines==0) {	//First Line
		    		map_size = Integer.parseInt(line);	//read size of map
		    		
                    if(map_size>0) {
		    			rover = new Rover(map_size);	//create map
		    		}
		    	}else{								//Another Line
		    		
                    if(line.equals("F")) {
						rover.Forward();
					
                    }else if(line.equals("L")) {
						rover.TurnLeft();
					
                    }else if(line.equals("R")) {
						rover.TurnRight();
					
                    }else if(line.toUpperCase().equals("REPORT")) {
						rover.Report();
					
                    }else if(line.toUpperCase().equals("EXIT")) {
						break;
					}
		    		
                    System.out.println(rover);		// {direction}:{x_position},{y_position}
		    	}
		    	number_of_lines++;		//count number of line in file
		    }  
		    fr.close();
		    br.close();
		
        }else {
			
            //Enter map size and commands from user input
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter map size");
			map_size = sc.nextInt();	//enter size of map
			
            if(map_size>0) {
				rover = new Rover(map_size);	//create map
				System.out.println("Enter commands to control your Rover(Enter Exit to exit the code)");
				String commands="";
				
                while(commands!="Exit") {
					commands = sc.nextLine();	//enter command
					
                    if(commands.equals("F")) {
						rover.Forward();
					
                    }else if(commands.equals("L")) {
						rover.TurnLeft();
					
                    }else if(commands.equals("R")) {
						rover.TurnRight();
					
                    }else if(commands.toUpperCase().equals("REPORT")) {
						rover.Report();
					
                    }else if(commands.toUpperCase().equals("EXIT")) {
						break;
					}
					
                    System.out.println(rover);		// {direction}:{x_position},{y_position}
				}
			}
		}
	}
}
