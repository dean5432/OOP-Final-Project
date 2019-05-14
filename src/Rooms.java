import java.util.ArrayList;

class Rooms {

    public static void build(Room[][] room, final int WIDTH, final int HEIGHT) {

    	// Initialize rooms (a 2D array)
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                room[i][j] = new Room(i, "", "", null);
            }
        }

        //figure out how to lock this room until paper clip is used to pick lock
        room[4][2].setNumber(1);
        room[4][2].setName("Jail Cell");
        room[4][2].setDescription("You are locked in a jail cell. You frantically search for something to escape with.");
        room[4][2].setItems("paper clip");
        room[4][2].setItems("broken glass shard");
        
        room[4][1].setNumber(2);
        room[4][1].setName("Hallway");
        room[4][1].setDescription("You are in a hallway that continues to your right. There is a wall to your left and a dark room in front of you.");
        
        room[4][0].setNumber(3);
        room[4][0].setName("Lab Room");
        room[4][0].setDescription("You see a scientist standing alone. He sees you and panics.");
        room[4][0].setItems("scientist");
        
        room[3][0].setNumber(4);
        room[3][0].setName("Power Room");
        room[3][0].setDescription("You walk into a room with broken wires lying everywhere. You get shocked and instantly feel a burst of energy and strength.");
        
        room[3][1].setNumber(5);
        room[3][1].setName("Hallway");
        room[3][1].setDescription("You are in a hallway that continues to your left and right. There is a dark room in front of you and a lit one behind you.");
        
        room[3][2].setNumber(6);
        room[3][2].setName("Surveillance Room");
        room[3][2].setDescription("You walk into the surveillance room. A security guard instantly sees you and points his gun at you.");
        room[3][2].setItems("Security Guard");
        
        room[2][2].setNumber(7);
        room[2][2].setName("Power Room");
        room[2][2].setDescription("You walk into a room with broken wires lying everywhere. You get shocked and instantly feel a burst of energy and strength. You see a wire cutter on the ground - could make a good weapon.");
        room[2][2].setItems("wire cutter");
        
        room[2][1].setNumber(8);
        room[2][1].setName("Hallway");
        room[2][1].setDescription("You are in a hallway that continues to your left and right. There is a locked door in front of you and a dark room behind you.");
        
        //figure out how to "lock" this room and make the game end when you make it here
        room[2][0].setNumber(9);
        room[2][0].setName("Exit");
        room[2][0].setDescription("You unlock the door and go outside. You escaped!");
        
        room[0][0].setNumber(10);
        room[0][0].setName("Biohazard!");
        room[0][0].setDescription("You unknowingly walk into a biohazard disposal room. The exposure to toxins slowly degrades your flesh. Run!");

        room[0][1].setNumber(11);
        room[0][1].setName("Hallway");
        room[0][1].setDescription("You are in a hallway that continues to your left. There is a wall to your right and a dark room in front of you.");
        room[0][1].setItems("keys");
        room[0][1].setItems("flashlight");

        room[1][0].setNumber(12);
        room[1][0].setName("Surveillance Room");
        room[1][0].setDescription("You walk into the surveillance room. A security guard instantly sees you and points his gun at you.");
        room[1][0].setItems("Security Guard");

        room[1][1].setNumber(13);
        room[1][1].setName("Hallway");
        room[1][1].setDescription("You are in a hallway that continues to your left and right. There is a locked door in front of you and a dark room behind you.");
        
        room[1][2].setNumber(14);
        room[1][2].setName("Lab Room");
        room[1][2].setDescription("You see a scientist working with test tubes. He panics when he sees you, dropping a shiny key.");
        room[1][2].setItems("scientist");
        room[1][2].setItems("Key");
        
        room[0][2].setNumber(15);
        room[0][2].setName("Surveillance Room");
        room[0][2].setDescription("You see a security guard looking at camera footage. He sees you and points his gun at you.");
        room[0][2].setItems("Security Guard");
       
    }

    public static void print(Room[][] room, int x, int y) {

        System.out.println(room[x][y].getDescription());
        System.out.println("You see: " + room[x][y].getItems());
        System.out.println();
    }

    // Remove item from room when added to inventory
    public static void removeItem(Room[][] room, int x, int y, String item) {
    	
    	room[x][y].deleteItem(item);
    }
}

class Room {

    private int number;
    private String name;
    private String description;
    public ArrayList<String> items = new ArrayList<>();

    public Room(int number, String name, String description,
            ArrayList<String> items) {
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setItems(String item) {
        this.items.add(item);
    }

    public void deleteItem(String item) {
        this.items.remove(item);
    }

    public ArrayList<String> getItems() {
        return this.items;
    }
}