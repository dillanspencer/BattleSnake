

import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.awt.Point;


public class BattleSnakeHandlers {
    
    public Object handleStart(Map<String, Object> requestBody) {
        // Dummy Response
        Map<String, Object> responseObject = new HashMap<String, Object>();
        responseObject.put("name", "wecsssssnake");
        responseObject.put("color", "#00BFFF00");
        responseObject.put("head_url", "http://web.uvic.ca/~etcwilde/pacman-moving.gif");
        responseObject.put("taunt", "Omnomnomnom");
        return responseObject;
    }
    
    public Object handleMove(Map<String, Object> requestBody) {
        // Dummy Response
        Map<String, Object> responseObject = new HashMap<String, Object>();
        responseObject.put("move", "down");
        responseObject.put("taunt", "going down!");
		//System.out.println("total score: " + getVal(10, 10, requestBody));
        return responseObject;
    }
    
    public Object handleEnd(Map<String, Object> requestBody) {
        // No response required
        Map<String, Object> responseObject = new HashMap<String, Object>();
        return responseObject;
    }
    
    public static int getVal(int x, int y, ArrayList<ArrayList<HashMap>> board){
        System.out.println("Food val: " + food(x,y, board));
		System.out.println("distance val: " + distance(x,y, board));
		System.out.println("snake?: " + snake(x,y, board));		
		
		return food(x,y, board) + distance(x,y, board) + snake(x,y, board);
                
    }
    
    public static int food(int x, int y, ArrayList<ArrayList<HashMap>> board){
        Object[][] board = requestBody.get("board");
        if(board[x][y].get("state").equals("food")){
            return 10;
        } else {
            return 0;
        }     
    }
       
    public static int distance(int x, int y, ArrayList<ArrayList<HashMap>> board){
        int[] snakes = requestBody.get("snakes");
        int snakeX;
        int snakeY;
        for(int i=0; i<snakes.length; i++){
            if(snakes[i].get("name").equals("wecsssssnake")){
                snakeX = snakes[i].get("coords")[0][0];
                snakeY = snakes[i].get("coords")[0][1];
            }
        }
        
        int distanceX = Math.abs(snakeX-x);
        int distanceY = Math.abs(snakeY-y);
        
        return -1*(distanceX+distanceY);
    }
        	
    public static int snake(int x, int y, ArrayList<ArrayList<HashMap>> board) {
		
		String state = requestBody.get("board")[x][y].get("state");
		if (state.equals("body") || state.equals("head"))
			return -1000;
		
		return 0;
	}
    
}




