package model.tiles;

import model.Game;
import model.enums.Direction;

public class DirectionalJumpPad extends JumpPad 
{
	private Direction jumpDirection;
	
	public DirectionalJumpPad(int jumpSize, Direction jumpDirection)
	{
		super(jumpSize);
		
		this.jumpDirection = jumpDirection;
	}
	
	@Override
	public boolean attemptToVisit(Game currentGame, Direction moveDirection)
	{
		this.visited = true;
		
		/*
		 * The player jumps using the specified jump direction
		 */
		return currentGame.attemptToMove(jumpDirection.getxModifier()*jumpSize, jumpDirection.getyModifier()*jumpSize);
	}
}
