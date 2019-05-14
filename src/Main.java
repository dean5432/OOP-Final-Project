import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
    	//intro
    	System.out.println("Welcome to the Government Escape java text game!");
		System.out.println("You wake up in a strange government facility feeling sick and uneasy.");
		System.out.println("After struggling to open your eyes, you look at your hands and see skin peeling away at exposed flesh.");
		System.out.println("Horrified, you get up and realize you're locked in what seems to be a jail cell.");
		System.out.println("You stumble over to the sink and take a look in the mirror. A muscular and bloody monster looks back at you.");
		System.out.println("You're a zombie! How can this be! You suddenly have a strong desire to escape.");
    	System.out.println("");
    	System.out.println("Commands: take, use, look, inv, n, s, e, w, quit");
    	System.out.println("");
		
        // Build rooms
        final int WIDTH = 5;
        final int HEIGHT = 3;
        Room[][] room = new Room[WIDTH][HEIGHT];
        Rooms.build(room, WIDTH, HEIGHT);
        int x = 4;
        int y = 2;
        Rooms.print(room, x, y);
        boolean unlockedCell = false;
        boolean haveKey = false;

        // Load inventory
        ArrayList<String> inventory = new ArrayList<>();

        // Start game
        boolean playing = true;
        while (playing) {

            String input = Input.getInput();

            
            
            // Movement commands
            
            if ( ((x==3 && y==0 && input.equals("e")) || (x==1 && y==0 && input.equals("w")) || (x==2 && y==1 && input.equals("n")) ) 
            		&& haveKey==false) {
            	 System.out.println("There is a locked door. There must be a key somewhere...");
            }
            else if (input.equals("n") && unlockedCell == true) {
                if (y > 0) {
                    y--;
                    Rooms.print(room, x, y);
                } else {
                    System.out.println("You can't go that way.");
                }
            } else if (input.equals("s")) {
                if (y < HEIGHT - 1) {
                    y++;
                    Rooms.print(room, x, y);
                } else {
                    System.out.println("You can't go that way.");
                }
            } else if (input.equals("e") && unlockedCell ==true) {
                if (x > 0) {
                    x--;
                    Rooms.print(room, x, y);
                } else {
                    System.out.println("You can't go that way.");
                }
            } else if (input.equals("w")) {
                if (x < WIDTH - 1) {
                    x++;
                    Rooms.print(room, x, y);
                } else {
                    System.out.println("You can't go that way.");
                }
            } 

            // Look commands
            else if (input.equals("look")) {
                Rooms.print(room, x, y);
            }

            // Get commands
            else if (input.length() > 4  && input.substring(0, 4).equals("take")) {
            	if (input.substring(0, input.indexOf(' ')).equals("take")) {
            		if (input.substring(input.indexOf(' ')).length() > 1) {
            			String item = input.substring(input.indexOf(' ') + 1);
                    	Inventory.checkItem(x, y, item, inventory, room);
                    	
                    	if(item.equals("key")) {
                    		haveKey=true;
                    	}
            		}	
            	}
            }
            else if (input.length() > 3  && input.equals("use paper clip") && unlockedCell == false) {
            	
            	if (input.equals("use paper clip") && inventory.contains("paper clip")) {
            		unlockedCell = true;
            		System.out.println("You pick the jail cell's lock. The door opens.");
            	}
            }
            else if ( (( input.length() > 0  && input.equals("use broken glass shard") && inventory.contains("broken glass shard")) || (input.length() > 0  && input.equals("use wire cutter") && inventory.contains("wire cutter")) )) {
            	
            	if(x==3 && y==2) {
            		System.out.println("You kill the guard in the room.");
            		Rooms.removeItem(room, x, y, "security guard");
            	}
            	else if (x==0 && y==2) {
                	System.out.println("You kill the guard in the room.");
                	Rooms.removeItem(room, x, y, "security guard");
            	}
            	else if (x==1 && y==0) {
                	System.out.println("You kill the guard in the room.");
                	Rooms.removeItem(room, x, y, "security guard");
            	}
            	else if(x==1 && y==2) {
            		System.out.println("You kill the scientist in the room.");
            		Rooms.removeItem(room, x, y, "scientist");
            	}
            	else if (x==4 && y==0) {
                	System.out.println("You kill the scientist in the room.");
                	Rooms.removeItem(room, x, y, "scientist");
            	}
            	
            }
            // Inventory commands
            else if (input.equals("inv")) {
                Inventory.print(inventory);
            }
            
            // Quit commands
            else if (input.equals("quit")) {
                System.out.println("Goodbye!");
                playing = false;

            // Catch-all for invalid input
            } else {
                System.out.println("Please enter a valid command.");
            }
            
            if (x==2 && y==0 && haveKey==true) {
            	playing = false;
            	break;
            }
        }
        System.exit(0);
    }
}
