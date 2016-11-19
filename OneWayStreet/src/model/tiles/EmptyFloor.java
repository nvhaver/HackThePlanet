package model.tiles;

import model.Game;
import model.enums.Direction;

public class EmptyFloor extends Tile
{
	public EmptyFloor() 
	{
		super();
	}

	@Override
	public boolean isVisitable() 
	{
		return true;
	}

	@Override
	public boolean attemptToVisit(Game game, Direction moveDirection)
	{
		this.visited = true;
		
		return true;
	}
}
