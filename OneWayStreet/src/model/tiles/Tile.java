package model.tiles;

import model.Game;
import model.enums.Direction;

/*
 * General thought about tiles: a level of x by y tiles contains x*y Tile objects.
 * The flyweight pattern could be used instead to limit the number of objects by pulling out the
 * only data that a tile object truelly stores (whether it has been visited). In the case of some special tiles like 
 * jumppad, a configurable property is also stored which can be pulled out by storing a list of JumpPad of increasing jumpsizes
 */

public abstract class Tile 
{
	protected boolean visited;
	
	public Tile()
	{
		this.visited= false;
	}
	
	/*
	 * Returns whether this tile is actually visitable
	 */
	public abstract boolean isVisitable();
		
	/*
	 * Attempts to visit a tile. Returns whether the visit (or sequence of visits that trigger, for example, in the case of a
	 * jumppads) succeeds. The X and Y coordinates of the tile are passed to it, as tiles do not store their own coordinates
	 */
	public abstract boolean attemptToVisit(Game currentGame, Direction moveDirection);
	
	/*
	 * Returns whether this tile has been visited yet, used to check if the level has been completed
	 */
	public boolean isVisited()
	{
		return visited;
	}
}
