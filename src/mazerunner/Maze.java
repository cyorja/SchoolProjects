package mazerunner;

/**
 * A maze and a cursor that you can move around within the maze.
 */
public interface Maze {

	public static class Direction {
		public final int x;
		public final int y;
		public Direction(int xValIn, int yValIn) {
			x = xValIn;
			y = yValIn;
		}
	}
	
	public static final Direction UP = new Direction(0, 1);
	public static final Direction DOWN = new Direction(0, -1);
	public static final Direction LEFT = new Direction(-1, 0);
	public static final Direction RIGHT = new Direction(1, 0);
	
	public static final boolean WALL = false;
	public static final boolean OPEN = true;
	
	/**
	 * Move the cursor to the start of the maze.
	 */
	public void start();
	
	/**
	 * Return whether the cursor can move in a given direction.
	 * @param d direction to move
	 * @return whether the cursor can move in that direction
	 */
	public boolean isClear(Direction d);
	
	/**
	 * Move the cursor one space in the given direction
	 * @param d the direction to move
	 * @return true if it was able to move in that direction, false if there was a wall there.
	 */
	public boolean move(Direction d);
	
	/**
	 * Whether the cursor is at the end of the maze.
	 */
	public boolean isSolved();
	
	/**
	 * Display this maze.
	 */
	public void display();
		
}
