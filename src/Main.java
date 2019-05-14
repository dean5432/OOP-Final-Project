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
    	System.out.println("Commands: take, look, i/inv, n, s, e, w, quit");
    	System.out.println("");
		
        // Build rooms
        final int WIDTH = 5;
        final int HEIGHT = 3;
        Room[][] room = new Room[WIDTH][HEIGHT];
        Rooms.build(room, WIDTH, HEIGHT);
        int x = 4;
        int y = 2;
        Rooms.print(room, x, y);

        // Load inventory
        ArrayList<String> inventory = new ArrayList<>();

        // Start game
        boolean playing = true;
        while (playing) {

            String input = Input.getInput();

            // Movement commands
            if (input.equals("n")) {
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
            } else if (input.equals("e")) {
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
            		}	
            	}
            }

            // Inventory commands
            else if (input.equals("i") || input.equals("inv")
                    || input.equals("inventory")) {
                Inventory.print(inventory);
            }
            
            // Quit commands
            else if (input.equals("quit")) {
                System.out.println("Goodbye!");
                playing = false;

            // Catch-all for invalid input
            } else {
                System.out.println("You can't do that.");
            }
        }
        System.exit(0);
    }
}
