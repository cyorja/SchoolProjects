package mazerunner;


public class MazeImpl implements Maze {

	/** 
	 * Dimension of maze in terms of spaces that you can occupy.
	 * Not the same as the dimensions of the array of slots.
	 */
	private final int width;
	private final int height;
	
	/**
	 * Location of starting point
	 */
	private int startx;
	private int starty;
	
	/**
	 * Location of ending point
	 */
	private int endx;
	private int endy;
	
	/**
	 * Location of current position moving through the map.
	 */
	private int currentx;
	private int currenty;
	
	private final boolean[][] mazeSquares; // A 2D array showing walls and open spaces in the maze
	private final boolean[][] footsteps; // A 2D array showing which squares the user has stepped on

	

	public MazeImpl(int inWidth, int inHeight) {
		width = 2*inWidth+1;
		height = 2*inHeight+1;
		mazeSquares = new boolean[width][height];
		footsteps = new boolean[width][height];
		
		// Put a wall around the outer edge
		for(int xctr=0; xctr<width; ++xctr) {
			mazeSquares[xctr][0] = false;
			mazeSquares[xctr][height-1] = WALL;
		}
		for(int yctr=0; yctr<height; ++yctr) {
			mazeSquares[0][yctr] = false;
			mazeSquares[width-1][yctr] = WALL;
		}
		
		// Make sure the rest of the maze starts clear
		for(int xctr=1; xctr<width-1; ++xctr) {
			for(int yctr=1; yctr<height-1; ++yctr) {
				mazeSquares[xctr][yctr] = OPEN;
			}
		}
	}
	
	public void start() {
		// Clear all footsteps
		for(int xctr=0; xctr<width; ++xctr) {
			for(int yctr=0; yctr<height; ++yctr) {
				footsteps[xctr][yctr] = false;
			}
		}
		
		// Move current to start
		currentx = startx;
		currenty = starty;
		footsteps[startx][starty]=true;
	}
	
	public boolean isClear(Direction d) {
		return mazeSquares[currentx + d.x][currenty + d.y] == OPEN;
	}
	
	public boolean move(Direction d) {
		if (!isClear(d)) {
			return false;
		} else {
			footsteps[currentx + d.x][currenty + d.y] = true;
			footsteps[currentx + 2*d.x][currenty + 2*d.y] = true;
			currentx += 2*d.x;
			currenty += 2*d.y;
			return true;
		}
	}
	
	public boolean isSolved() {
		return (currentx == endx) && (currenty == endy);
	}
	
	private boolean isInMaze(int x, int y) {
		return ((x >= 0) && (x < width) && (y >= 0) && (y < height));
	}
	
	public void display() {
		for (int yctr=height-1; yctr>=0; --yctr) {
			for(int xctr=0; xctr<width; ++xctr) {
				if ((xctr == startx) && (yctr == starty)) {
					System.out.print('S');
				} else if ((xctr == endx) && (yctr == endy)) {
					System.out.print('F');
				} else if (mazeSquares[xctr][yctr] == WALL) {
					System.out.print('O');
				} else if (footsteps[xctr][yctr]) {
					System.out.print('.');
				} else {
					System.out.print(' ');
				}
			}
			System.out.println();
		}
	}

	public void setWall(int x, int y, Direction d) {
		int realX = 2*x+1;
		int realY = 2*y+1;
		if (isInMaze(realX, realY)) {
			mazeSquares[realX+d.x][realY+d.y] = WALL;
			// Continue walls already there.
//			if (isInMaze(realX+2*d.y+d.x, realY+2*d.x+d.y) && 
//					(slots[realX+2*d.y+d.x][realY+2*d.x+d.y] == WALL)) {
//				slots[realX+d.y+d.x][realY+d.x+d.y] = WALL;
//			}
			mazeSquares[realX+d.y+d.x][realY+d.x+d.y] = WALL;
//			if (isInMaze(realX-2*d.y+d.x, realY-2*d.x+d.y) && 
//					(slots[realX-2*d.y+d.x][realY-2*d.x+d.y] == WALL)) {
//				slots[realX-d.y+d.x][realY-d.x+d.y] = WALL;
//			}
			mazeSquares[realX-d.y+d.x][realY-d.x+d.y] = WALL;
		}
	}
	
	public void setStart(int x, int y) {
		int realX = 2*x+1;
		int realY = 2*y+1;
		if (isInMaze(realX, realY)) {
			startx = realX;
			starty = realY;
			// If current hasn't been set yet, set it to start.
			if ((currentx == 0) && (currenty == 0)) {
				currentx = startx;
				currenty = starty;
			}
		}
	}

	public void setEnd(int x, int y) {
		int realX = 2*x+1;
		int realY = 2*y+1;
		if (isInMaze(realX, realY)) {
			endx = realX;
			endy = realY;
		}
	}
	
}
