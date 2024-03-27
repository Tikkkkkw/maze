public class Maze {
    private final int[] start = {0,0};
    private int[] end;
    private String[][] maze;
    private int[] current = {0,0};


    public Maze(String[][]maze ){
        int[]log = new int[2];
        log[0] = maze.length-1;
        log[1] = maze[1].length-1;
        end = log;
        this.maze = maze;
    }

    public int[] getStart() {
        return start;
    }

    public int[] getEnd() {
        return end;
    }
    public int[] getCurrent(){
        return current;
    }


    public boolean goRight(int[]current) {
        if((current[1] + 1 < maze[0].length) && maze[current[0]][current[1] + 1].equals(".")){
            current[1] = current[1] + 1;
            return true;
        }
        return false;
    }

    public boolean goLeft(int[]current) {
        if((current[1] > start[1]) && maze[current[0]][current[1] - 1].equals(".")){
            current[1] = current[1] - 1;
            return true;
        }
        return false;
    }

    public boolean goDown(int[]current) {
        if((current[0] - 1 > start[0]) && (maze[current[0] - 1][current[1]].equals("."))){
            current[0] = current[0] - 1;
            return true;
        }
        return false;
    }
    public boolean goUp(int[]current) {
        if((current[0] + 1 < maze.length) && (maze[current[0] + 1][current[1]].equals("."))){
            current[0] = current[0] + 1;
            return true;
        }
        return false;
    }
    public int multipleWay(int[]current){
        int i = 0;

        return i;
    }
    public boolean deadEnd(int[]current){
        if (!(goRight(current)) && (!(goLeft(current)) && (!(goUp(current)) && (!(goDown(current)))))){
            maze[current[0]][current[1]] = "O";
            current[0] = 0;
            current[1] = 0;
            for (int r = 0; r < maze.length; r ++) {
                for (int c = 0 ; c < maze[0].length; c ++) {
                    if (maze[r][c].equals("x")){
                        maze[r][c] = ".";
                    }
                    maze[0][0] = "x";
                }
            }
            return true;
        }
        return false;

    }



    public static boolean CoordsCheck(int a, int b){
        return a == b;
    }

}
