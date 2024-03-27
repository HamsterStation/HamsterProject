package castle;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private Room currentRoom;
    HashMap<String,Handler> handler = new HashMap<String,Handler>();
        
    public Game() 
    {
    	handler.put("bye", new handlerBye());
    	handler.put("help", new handlerHelp());
    	handler.put("go", new handlerGo());
        createRooms();
    }

    private void createRooms()
    {
        Room outside, lobby, pub, study, bedroom;
      
        //	制造房间
        outside = new Room("城堡外");
        lobby = new Room("大堂");
        pub = new Room("小酒吧");
        study = new Room("书房");
        bedroom = new Room("卧室");
        
        //	初始化房间的出口
        outside.setExit("east", lobby);
        outside.setExit("south",study);
        outside.setExit("west",pub);
        lobby.setExit("west", outside);
        lobby.setExit("up", pub);
        pub.setExit("down", lobby);
        pub.setExit("east", outside);
        study.setExit("north", outside);
        study.setExit("east", bedroom);
        bedroom.setExit("west", study);

        currentRoom = outside;  //	从城堡门外开始
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入 'help' 。");
        System.out.println();
        printExit();
    }

    // 以下为用户命令


    public void goRoom(String direction) 
    {
        Room nextRoom = currentRoom.getExits(direction);


        if (nextRoom == null) {
            System.out.println("那里没有门！");
        }
        else {
            currentRoom = nextRoom;
            printExit();
        }
    }
    
    public void printExit() {
    	System.out.println("你在" + currentRoom);
        System.out.print("出口有: ");
        System.out.print(currentRoom.getExitDesc());
        System.out.println();
    }
	
    public void play() {
    	Scanner in = new Scanner(System.in);
    	 while ( true ) {
     		String line = in.nextLine();
     		String[] words = line.split(" ");
     		String value = " ";
     		if(handler.get(words[0]) != null) {
     			handler.get(words[0]).doCmd(value);
	     		if(handler.get(words[0]).isBye())
	     			break;
	     		if(handler.get(words[0]).isGo()) {
		     		if(words[1].length()>1)
		     			value = words[1];
		     		goRoom(value);
		     	} 
	    	 }
    	 }
     in.close();
    }
    
	public static void main(String[] args) {
		
		Game game = new Game();
		game.printWelcome();
		game.play();
       
	}

}
