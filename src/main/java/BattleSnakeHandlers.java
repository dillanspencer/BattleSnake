

import java.util.HashMap;
import java.util.Map;


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
	
	public int snake(int x, int y, Map<String, Object> requestBody) {
		
		String state = requestBody.get("board")[x,y].get("state");
		if (state.equals("body") || state.equals("head"))
			return -1000;
		
		return 0;
	}

}
