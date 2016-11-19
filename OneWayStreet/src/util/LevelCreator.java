package util;

import model.Level;
import model.tiles.EmptyFloor;
import model.tiles.Wall;

public class LevelCreator 
{
	/*
	 * Fills a level with empty floor tiles
	 * 
	 * IMPORTANT: currently assumes the level is a rectangle.
	 * Will not work correctly for non-rectangular shaped levels!
	 */
	public static void fillWithEmptyFloor(Level level)
	{		
		final int WIDTH = level.getField().length;
		final int HEIGHT = level.getField()[0].length;
		
		for(int x=0; x<WIDTH; x++)
		{
			for(int y=0; y<HEIGHT; y++)
			{
				level.setTile(x, y, new EmptyFloor());
			}
		}
			
	}
	
	/*
	 * Constructs an outer wall that covers the edge of the level
	 * 
	 * IMPORTANT: currently assumes the level is a rectangle.
	 * Will not work correctly for non-rectangular shaped levels!
	 */
	public static void createOuterWall(Level level)
	{		
		final int WIDTH = level.getField().length;
		final int HEIGHT = level.getField()[0].length;
		
		// Horizontal walls
		for(int x=0; x<WIDTH; x++)
		{
			level.setTile(x, 0, new Wall()); 
			level.setTile(x, HEIGHT-1, new Wall()); 
		}
		
		// Vertical walls
		for(int y=1; y<HEIGHT-1; y++)
		{
			level.setTile(0, y, new Wall());
			level.setTile(WIDTH-1, y, new Wall()); 
		}
	}
}
