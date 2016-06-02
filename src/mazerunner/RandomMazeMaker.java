package mazerunner;


public class RandomMazeMaker {

	public static Maze makeMaze() {
		MazeImpl maze1 = new MazeImpl(5, 5);
		maze1.setWall(1, 4, Maze.DOWN);
		maze1.setWall(2, 2, Maze.DOWN);
		maze1.setWall(4, 4, Maze.DOWN);
		maze1.setWall(0, 0, Maze.UP);
		maze1.setWall(1, 0, Maze.UP);
		maze1.setWall(2, 0, Maze.UP);
		maze1.setWall(4, 0, Maze.UP);
		maze1.setWall(0, 1, Maze.UP);
		maze1.setWall(1, 2, Maze.UP);
		maze1.setWall(3, 2, Maze.UP);
		maze1.setWall(4, 3, Maze.UP);
		maze1.setWall(0, 2, Maze.RIGHT);
		maze1.setWall(0, 3, Maze.RIGHT);
		maze1.setWall(1, 1, Maze.RIGHT);
		maze1.setWall(2, 4, Maze.RIGHT);
		maze1.setWall(3, 2, Maze.RIGHT);
		maze1.setWall(3, 3, Maze.RIGHT);
		maze1.setStart(0, 1);
		maze1.setEnd(4, 3);
		
		return maze1;
	}
	
	public static void main(String[] args) {
		Maze maze1 = RandomMazeMaker.makeMaze();
		maze1.start();
		maze1.display();
		Maze.Direction[] solution = {Maze.RIGHT, Maze.UP, Maze.RIGHT, Maze.RIGHT, Maze.DOWN,
				Maze.RIGHT, Maze.UP, Maze.UP};
		boolean ok = true;
		for(int i=0; ok && (i<solution.length); ++i) {
			ok = maze1.move(solution[i]);
			if (!ok) {
				System.out.println("\nError.  Could not make move #" + (i+1) + "\n");
			}
		}
		if (ok && maze1.isSolved()) {
				System.out.println("\nSuccess!\n");
		} else {
			System.out.println("\nYou didn't finish.\n");
		}
		maze1.display();
	}
}
