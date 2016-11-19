package model;

import model.tiles.Tile;
import model.tiles.Wall;

public class Level 
{
	/*
	 *  field[x][y] = tile corresponding to coordinates pair (x,y) with (0,0) being the topleftmost tile
	 */
	private Tile[][] field;
	
	/*
	 * Coordinates of the tile the player starts at
	 */
	private int startX;
	private int startY;
	
	public Level(int width, int height, int startX, int startY)
	{
		field = new Tile[width][height];
		
		this.startX = startX;
		this.startY = startY;
	}
	
	public Level(Tile[][] field)
	{
		this.field = field;
	}
	
	public Tile[][] getField()
	{
		return field;
	}
	
	public Tile getTile(int x, int y) 
	{
		return field[x][y];
	}
	
	public void setTile(int x, int y, Tile tile)
	{
		field[x][y] = tile;
	}
	
	public int getStartX() 
	{
		return startX;
	}

	public int getStartY() 
	{
		return startY;
	}
	
	/*
	 * Instead of recalculating this every time,
	 * we could calculate the number of unvisited tiles at the start
	 * and decrease this number every time we visit one
	 * and check here whether the number == 0
	 */
	public boolean levelCompleted()
	{
		for(Tile[] row : field)
		{
			for(Tile tile : row)
			{
				if(tile.isVisitable() && !tile.isVisited())
				{
					return false;
				}
			}
		}
		return true;
	}
}	

