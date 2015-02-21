/**
 * Depth First search
 *
 * Searches a map
 * DFS is fun!
 */

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DepthFirstSearch
{
	private int [][] weights;
	//private boolean[][] marked;
	private int parent[][][];
	private int count;
	private int max_depth;

	public DepthFirstSearch(Map<String, Object> board[][], int x, int y, int depth)
	{
		max_depth = depth;
		marked = new int[board.length][board[0].length];
		parent = new int[board.length][board[0].length][2];
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board.length; j++)
			{
				weights[i][j] = MIN_VALUE;
				parent[i][j][0] = -1;
				parent[i][j][1] = -1;
			}
		}
	}


	public String dfs(Map<String, Object> board[][], int x, int y)
	{
		PriorityQueue nodes = new PriorityQueue();
		nodes.add(Point(x, y,-1,-1,1));
		while (nodes.size() > 0)
		{
			Point node = nodes.poll();
			//Map<String, Object> n_content = board[node.x][node.y];
			int weight = getVal(node.x,node.y) - node.depth;
			if (weight > weights[node.x][node.y]){
				weights[node.x][node.y] = weight;
				parent[node.x][node.y][0] = node.parx;
				parent[node.x][node.y][1] = node.pary;
				nodes.add(node.x+1,node.y,node.x,node.y,node.depth+1);
				nodes.add(node.x-1,node.y,node.x,node.y,node.depth+1);
				nodes.add(node.x,node.y+1,node.x,node.y,node.depth+1);
				nodes.add(node.x,node.y-1,node.x,node.y,node.depth+1);
			}
		}
		int max_val = MIN_VALUE;
		int max_x, max_y;
		for (int i = 0; i < weights.length; i++)
		{
			for (int j = 0; j < weights[0].length; j++)
			{
				if (weights[i][j] > max)
				{
				       	max_val = weights[i][j];
					max_x = i;
					max_y = j;
				}
			}
		}

		int t_max_x;
		while (parent[max_x][max_y][0] != x
				|| parent[max_x][max_y][1] != y)
		{
			t_max_x = max_x;
			max_x = parent[t_max_x][max_y][0];
			max_y = parent[t_max_x][max_y][1];
		}

		if (max_x < x) return "Left";
		else if (max_x > x) return "Right";
		else if (max_y > y) return "Down";
		else if (max_y < y) return "Up"; // yes!
		else return "You are wrong!";
	}

	private class Point
	{
		public int x, y, parx, pary, depth;
		public Point(int x, int y, int parx, int pary, int depth)
		{
			this.x = x;
			this.y = y;
			this.parx = parx;
			this.pary = pary;
			this.depth = depth;
		}
	}
}
