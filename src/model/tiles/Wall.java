package model.tiles;

import model.Game;
import model.enums.Direction;

public class Wall extends Tile 
{
	public Wall() 
	{
		super();
	}

	@Override
	public boolean isVisitable() 
	{
		return false;
	}

	/*
	 * A wall should never be visited
	 */
	@Override
	public boolean attemptToVisit(Game currentGame, Direction moveDirection)
	{
		System.err.println("Player attempted to visit a wall!");
		System.exit(-2);
		return false;
	}
}
