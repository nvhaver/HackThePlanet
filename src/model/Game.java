package model;

import model.enums.Direction;
import model.tiles.Tile;

public class Game 
{
	private Level currentLevel;
	private Player player;
	
	public Game(Level currentLevel) 
	{
		this.player = new Player();
		setCurrentLevel(currentLevel);
	}
	
	public Game()
	{
		this(null);
	}

	public Player getPlayer()
	{
		return player;
	}
	
	public Level getCurrentLevel() 
	{
		return currentLevel;
	}

	public void setCurrentLevel(Level currentLevel) 
	{
		if(currentLevel != null)
		{
			this.currentLevel = currentLevel;

			player.setCurrentX(currentLevel.getStartX());
			player.setCurrentY(currentLevel.getStartY());
		}

	}
	
	public boolean attemptToMove(int xModifier, int yModifier)
	{
		if(currentLevel!=null)
		{
			final int newX = player.getCurrentX() + xModifier;
			final int newY = player.getCurrentY() + yModifier;
		
			final Tile tileMovedTo = currentLevel.getTile(newX, newY);
		
			if(tileMovedTo.isVisitable() && !tileMovedTo.isVisited())
			{
				player.setCurrentX(newX);
				player.setCurrentY(newY);
				
				return tileMovedTo.attemptToVisit(this, Direction.getEnum(xModifier, yModifier));
			}
			else
			{
				return false;
			}
		}
		else
		{
			System.err.println("Player attempted to move but is not assigned to a level!");
			System.exit(-1);
			return false;	// Hush compiler
		}
	}
	public boolean attemptToMove(Direction moveDirection)
	{
		return attemptToMove(moveDirection.getxModifier(), moveDirection.getyModifier());
	}
}
