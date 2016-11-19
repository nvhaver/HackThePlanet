package tests;
import model.Game;
import model.Level;
import model.enums.Direction;
import model.tiles.DirectionalJumpPad;
import util.LevelCreator;
import view.LevelASCIIRenderer;

public class SimpleTests 
{
	public static void testRenderer() 
	{
		/*		x x x x x x x 
		 * 		x P	J     	x
		 * 		x		    x
		 * 		x	J	    x
		 * 		x           x
		 * 		x           x
		 * 		x x x x x x x
		 */
		
		Game game = new Game();
		Level testLevel = new Level(7,7,1,1);
		LevelCreator.fillWithEmptyFloor(testLevel);
		LevelCreator.createOuterWall(testLevel);
		testLevel.setTile(2, 1, new DirectionalJumpPad(2, Direction.DOWN));
		testLevel.setTile(2, 3, new DirectionalJumpPad(2, Direction.RIGHT));
		game.setCurrentLevel(testLevel);
		
		LevelASCIIRenderer renderer = new LevelASCIIRenderer();
		
		renderer.renderGame(game);
		
		System.out.println();
		
		game.attemptToMove(Direction.RIGHT);
		renderer.renderGame(game);
	}
}
