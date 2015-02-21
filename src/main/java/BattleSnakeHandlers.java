

import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.awt.Point;


public class BattleSnakeHandlers {
    
    public Object handleStart(Map<String, Object> requestBody) {
        // Dummy Response
        Map<String, Object> responseObject = new HashMap<String, Object>();
        responseObject.put("name", "wecsssssnake");
        responseObject.put("color", "#00BFFF");
        responseObject.put("head_url", "http://www.mapleprimes.com/DocumentFiles/95819/279486/pacman-moving.gif");
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
    
    public static int getVal(int x, int y, Map<String, Object> requestBody){
        return food(x,y, requestBody);
        
    }
    
    public static int food(int x, int y, Map<String, Object> requestBody){
        int[][] board = requestBody.get("board");
        if(board[x][y].get("state").equals("food")){
            return 10;
        } else {
            return 0;
        }     
    }
       
    public static int distance(int x, int y, Map<String, Object> requestBody){
        int[] snakes = requestBody.get("snakes");
        int snakeX;
        int snakeY;
        for(int i=0; i<snakes.length; i++){
            if(snakes[i].get("name").equals("wecsssssnake"){
                snakeX = snakes[i].get("coords")[0][0];
                snakeY = snakes[i].get("coords")[0][1];
            }
        }
        
        int distanceX = Math.abs(snakeX-x);
        int distanceY = Math.abs(snakeY-y);
        
        return -1*(distanceX+distanceY);
    }
        
    
}





}
