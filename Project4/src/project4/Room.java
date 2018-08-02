
package project4;


public class Room {
    private String roomColor;
    private String message;
    private String[] adjRooms;
    private String roomOptions;
    private int code;
    
    public String returnRoomOptions(){
        String returned = adjRooms[0];
        for(int i = 1; i<adjRooms.length; i++){
            returned += ", " + adjRooms[i];
        }
        return returned;
    }
    
    public Room(String r){
        r = r.toUpperCase();
        roomColor = r;
        
        if("GREEN".equals(r)){
            adjRooms = new String[3];
            adjRooms[0] = "BROWN";
            adjRooms[1] = "PINK";
            adjRooms[2] = "BLUE";
            roomOptions = returnRoomOptions();
        } else if("PINK".equals(r)){
            adjRooms = new String[3];
            adjRooms[0] = "GREEN";
            adjRooms[1] = "BROWN";
            adjRooms[2] = "BLUE";
            roomOptions = returnRoomOptions();
        } else if("BROWN".equals(r)){
            adjRooms = new String[3];
            adjRooms[0] = "PINK";
            adjRooms[1] = "GREEN";
            adjRooms[2] = "RED";
            roomOptions = returnRoomOptions();
        } else if("BLUE".equals(r)){
            adjRooms = new String[3];
            adjRooms[0] = "GREEN";
            adjRooms[1] = "PINK";
            adjRooms[2] = "YELLOW";
            roomOptions = returnRoomOptions();
        } else if("RED".equals(r)){
            adjRooms = new String[2];
            adjRooms[0] = "BROWN";
            adjRooms[1] = "YELLOW";
            roomOptions = returnRoomOptions();
        } else if("YELLOW".equals(r)){
            adjRooms = new String[3];
            adjRooms[0] = "RED";
            adjRooms[1] = "BLUE";
            adjRooms[2] = "GOLD";
            roomOptions = returnRoomOptions();
        } else if("GOLD".equals(r)){
            adjRooms = new String[1];
            adjRooms[0] = "YELLOW";
            roomOptions = returnRoomOptions();
        }    
    }
    
    public String getRoomColor(){
        return roomColor;
    }
    
    public void setMessage(){
        if(!"GOLD".equals(roomColor)){
            message = "\nYou are in the " + roomColor + " room!" + "\nYou see doors to these other room(s): " + roomOptions + ".";
        } else{
            message = "\nYou are in the " + roomColor + " room!" + "\nYou have finally arrived! "
                    + "\nYou see the golden chalice and hastily pick it up!"
                    + "\nBehind you lies the yellow door."
                    + "\nI hope you remember your codes!";
        }
       
    }
    
    public String getMessage(){
        return message;
    }
    
    public String[] getAdjRooms(){
        return adjRooms;
    }
    
    public void setCode(int x){
        code = x;
    }
    
    public int getCode(){
        return code;
    }
}
