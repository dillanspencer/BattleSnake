

import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.awt.Point;
import java.util.ArrayList;


public class ValueClass {


    public static int getVal(int x, int y, int snakeX, int snakeY, Object board){
	return food(x,y, (ArrayList<ArrayList<HashMap>>)board) + snake(x,y, (ArrayList<ArrayList<HashMap>>)board);


    }

    public static int food(int x, int y, ArrayList<ArrayList<HashMap>> board){

        if(board.get(x).get(y).get("state").equals("food")){

            return 10;
        } else {
            return 0;
        }
    }

    public static int snake(int x, int y, ArrayList<ArrayList<HashMap>> board) {

		String state = (String)board.get(x).get(y).get("state");
		System.out.println(state);

		if (state.equals("body") || state.equals("head")) { // if there is a snake
			return -1000;
			//boolean tail = false;
		}

		return 0;
	}

}




