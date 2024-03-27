package castle;

import java.util.HashMap;

public class Room {
    private String description;
    private HashMap<String,Room> exits = new HashMap<String,Room>();

    public Room(String description) 
    {
        this.description = description;
    }

    public void setExit(String dir,Room ret) 
    {
       exits.put(dir, ret);
    }
    
    public Room getExits(String direction) {
    	return exits.get(direction);
    }
    
    public String getExitDesc() {
    	StringBuffer sb = new StringBuffer();
    	for(String dir : exits.keySet()) {
    		sb.append(dir);
    		sb.append(' ');
    	}
    	return sb.toString();
    }

    @Override
    public String toString()
    {
        return description;
    }
}
