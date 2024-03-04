public class Maze {
    private final String start = "0,0";
    private String end = "";

    public Maze(String[][]maze ){
        end = maze.length + "," + maze[0].length;
    }

    public int[] getStart() {
        int[]log = new int[2];
        log[0] = Integer.parseInt(start.substring(0,1));
        log[1] = Integer.parseInt(start.substring(start.length()-1));

        return log;
    }

    public int[] getEnd() {
        int[] log = new int[2];
        log[0] = Integer.parseInt(end.substring(0,1));
        log[1] = Integer.parseInt(end.substring(end.length()-1));
        return log;
    }
}
