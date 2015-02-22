

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

}




