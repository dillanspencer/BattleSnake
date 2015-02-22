

import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.awt.Point;
import java.util.ArrayList;


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

	ArrayList<ArrayList<Map<String, Object>>> board = (ArrayList)requestBody.get("board");
	ArrayList<Map<String, Object>> snakes = (ArrayList)requestBody.get("snakes");
	DepthFirstSearch search_engine = new DepthFirstSearch(board, snakes);

	Map<String, Object> our_snake = new HashMap<String, Object>();
	for (int i = 0; i < snakes.size() ; i++)
	{
		Map<String, Object> snake = snakes.get(i);
		if (snake.get("name").equals("wecsssssnake"))
		{
			our_snake = snake;
		}
	}

	ArrayList<ArrayList<Integer>> our_coordinates = (ArrayList)our_snake.get("coords");
	ArrayList<Integer> head = our_coordinates.get(0); //[0];

	String move = search_engine.dfs(head.get(0), head.get(1)); // FIXME


	Map<String, Object> response = new HashMap<String, Object>();
	response.put("move", move);
	return response;

	/*
        // Dummy Response
        Map<String, Object> responseObject = new HashMap<String, Object>();
        responseObject.put("move", "down");
        responseObject.put("taunt", "going down!");
		
		//Object snakes = 
		//System.out.println("total score: " + getVal(10, 10, 2, 2, requestBody.get("board"), snakes));
		
        return responseObject;
	*/
    }

    public Object handleEnd(Map<String, Object> requestBody) {
        // No response required
        Map<String, Object> responseObject = new HashMap<String, Object>();
        return responseObject;
    }
<<<<<<< HEAD
    /*

    public static int getVal(int x, int y, int snakeX, int snakeY, Object board, Object[] snakes){
        System.out.println("Food val: " + food(x,y, (ArrayList<ArrayList<HashMap>>)board));
		//System.out.println("distance val: " + distance(x,y, snakeX, snakeY));
		System.out.println("snake?: " + snake(x,y, (ArrayList<ArrayList<HashMap>>)board), snakes);		
		
		//return food(x,y, (ArrayList<ArrayList<HashMap>>)board) + distance(x,y, snakeX, snakeY) + snake(x,y, (ArrayList<ArrayList<HashMap>>)board);
		return food(x,y, (ArrayList<ArrayList<HashMap>>)board) + snake(x,y, (ArrayList<ArrayList<HashMap>>)board, snakes);
=======

    public static int getVal(int x, int y, int snakeX, int snakeY, ArrayList<ArrayList<HashMap>> board){
        System.out.println("Food val: " + food(x,y, board));
		System.out.println("distance val: " + distance(x,y, snakeX, snakeY));
		System.out.println("snake?: " + snake(x,y, board));
>>>>>>> 93498af5adae9e9b66233ef54d7d8cd2179b6fcb

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
<<<<<<< HEAD
    }	
    public static int snake(int x, int y, ArrayList<ArrayList<HashMap>> board, Object[] snakes) {
		
		String state = (String)board.get(x).get(y).get("state");
		if (state.equals("body") || state.equals("head")) { // if there is a snake
			return -1000;
			//boolean tail = false;
		}
		
		return 0;
	}*/
    
=======
    }

    public static int snake(int x, int y, ArrayList<ArrayList<HashMap>> board) {
		String state = (String)board.get(x).get(y).get("state");
		if (state.equals("body") || state.equals("head"))
			return -1000;

		return 0;
	}

>>>>>>> 93498af5adae9e9b66233ef54d7d8cd2179b6fcb
}




