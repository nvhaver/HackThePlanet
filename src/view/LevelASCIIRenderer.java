package view;

import java.util.HashMap;
import java.util.Map;

import model.Game;
import model.tiles.DirectionalJumpPad;
import model.tiles.EmptyFloor;
import model.tiles.JumpPad;
import model.tiles.Tile;
import model.tiles.Wall;

public class LevelASCIIRenderer 
{
	/*
	 * If the number of tile types increases, change this to a Map <Tile class, Character>
	 */	
	
	private Map<Class<? extends Tile>, Character> tileTokenMap;
	private char playerToken;
	
	public LevelASCIIRenderer()
	{
		tileTokenMap = new HashMap<Class<? extends Tile>, Character>();
		
		tileTokenMap.put(Wall.class, 'X');
		tileTokenMap.put(JumpPad.class, 'O');
		tileTokenMap.put(EmptyFloor.class, ' ');
		tileTokenMap.put(DirectionalJumpPad.class, 'J');
		
		playerToken = 'P';
	}
	
	public void setTileToken(Class<? extends Tile> tileType, char token)
	{
		tileTokenMap.put(tileType, token);
	}

	public void setPlayerToken(char playerToken)
	{
		this.playerToken = playerToken;
	}
	
	public void renderGame(Game game)
	{
		final Tile[][] field = game.getCurrentLevel().getField();
		
		for(int y=0; y<field[0].length; y++)
		{
			for(int x=0; x<field.length; x++)
			{
				if(game.getPlayer()!=null && x==game.getPlayer().getCurrentX() && y==game.getPlayer().getCurrentY())
				{
					System.out.print(playerToken);
				}
				else
				{
					System.out.print(tileTokenMap.get(field[x][y].getClass()));	
				}
			}
			System.out.println();
		}
	}
}
