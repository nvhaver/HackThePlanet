package model.enums;

public enum Direction 
{
	UP ( 0,-1),
	RIGHT  ( 1, 0),
	DOWN ( 0, 1),
	LEFT  (-1, 0);
	
	private final int xModifier;
	private final int yModifier;
	  
	private Direction(int xModifier, int yModifier) 
	{
	      this.xModifier = xModifier;
	      this.yModifier = yModifier;
	}

	public int getxModifier() 
	{
		return xModifier;
	}

	public int getyModifier() 
	{
		return yModifier;
	}
	
	public Direction getOpposite()
	{
		return getEnum(this.xModifier*-1,this.yModifier*-1);
	}
	
	public static Direction getEnum(int xModifier, int yModifier) 
	{
		xModifier = (int) Math.signum(xModifier);
		yModifier = (int) Math.signum(yModifier);
		
		final Direction[] enums = Direction.values();
		
		for(int i=0; i<enums.length; i++)
		{
			if(enums[i].getxModifier() == xModifier && enums[i].getyModifier() == yModifier)
			{
				return enums[i];
			}
		}
		return null;
	 }
}
