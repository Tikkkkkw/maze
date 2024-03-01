public class Maze {
    private final String start = "0,0";
    private String end = "";

    public Maze(String[][]maze ){
        end = maze.length + "," + maze[0].length;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }
}
