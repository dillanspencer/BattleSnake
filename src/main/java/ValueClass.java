

import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.awt.Point;
import java.util.ArrayList;


public class ValueClass {
    

    public static int getVal(int x, int y, int snakeX, int snakeY, Object board, Object[] snakes){
        System.out.println("Food val: " + food(x,y, (ArrayList<ArrayList<HashMap>>)board));
		//System.out.println("distance val: " + distance(x,y, snakeX, snakeY));
		System.out.println("snake?: " + snake(x,y, (ArrayList<ArrayList<HashMap>>)board), snakes);		
		
		//return food(x,y, (ArrayList<ArrayList<HashMap>>)board) + distance(x,y, snakeX, snakeY) + snake(x,y, (ArrayList<ArrayList<HashMap>>)board);
		return food(x,y, (ArrayList<ArrayList<HashMap>>)board) + snake(x,y, (ArrayList<ArrayList<HashMap>>)board, snakes);

                
    }
    
    public static int food(int x, int y, ArrayList<ArrayList<HashMap>> board){

        if(board.get(x).get(y).get("state").equals("food")){

            return 10;
        } else {
            return 0;
        }     
    }

    /*public static int distance(int x, int y, int snakeX, int snakeY){

        int distanceX = Math.abs(snakeX-x);
        int distanceY = Math.abs(snakeY-y);
        
        return -1*(distanceX+distanceY);
    }*/
        	
    public static int snake(int x, int y, ArrayList<ArrayList<HashMap>> board, Object[] snakes) {
		
		String state = (String)board.get(x).get(y).get("state");
		if (state.equals("body") || state.equals("head")) { // if there is a snake
			return -1000;
			//boolean tail = false;
		}
		
		return 0;
	}
    
}




