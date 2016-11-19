package model.tiles;

import model.Game;
import model.Level;
import model.enums.Direction;

public class JumpPad extends Tile
{
	/*
	 * The number of tiles the jumppad carries a player
	 */
	protected int jumpSize;
	
	public JumpPad(int jumpSize) 
	{
		super();
		
		this.jumpSize = jumpSize;
	}

	@Override
	public boolean isVisitable() 
	{
		return true;
	}
	
	@Override
	public boolean attemptToVisit(Game currentGame, Direction moveDirection)
	{
		this.visited = true;
		
		/*
		 * If the player moves left, he jumps to the left...
		 */
		return currentGame.attemptToMove(moveDirection.getxModifier()*jumpSize, moveDirection.getyModifier()*jumpSize);
	}
}
