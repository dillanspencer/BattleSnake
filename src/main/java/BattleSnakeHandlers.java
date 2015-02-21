

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
        return responseObject;
    }
    
    public Object handleEnd(Map<String, Object> requestBody) {
        // No response required
        Map<String, Object> responseObject = new HashMap<String, Object>();
        return responseObject;
    }
    
    public static int getVal(int x, int y, int snakeX, int snakeY, ArrayList<ArrayList<HashMap>> board){
        return food(x,y, board) + distance(x,y, snakeX, snakeY) + snake(x,y, board);
                
    }
    
    public static int food(int x, int y, ArrayList<ArrayList<HashMap>> board){
        if(board.get(x).get(y).get("state").equals("food")){
            return 10;
        } else {
            return 0;
        }     
    }
       
    public static int distance(int x, int y, int snakeX, int snakeY){

        int distanceX = Math.abs(snakeX-x);
        int distanceY = Math.abs(snakeY-y);
        
        return -1*(distanceX+distanceY);
    }
        	
    public int snake(int x, int y, Map<String, Object> requestBody) {
		
		String state = requestBody.get("board")[x][y].get("state");
		if (state.equals("body") || state.equals("head"))
			return -1000;
		
		return 0;
	}
    
}




