public class Maze {
    private final String start = "0,0";
    private String end;

    public Maze(String[][]maze ){
        end = maze.length-1 +","+ (maze[0].length-1) ;
    }

    public int[] getStart() {
        int[]log = new int[2];
        log[0] = Integer.parseInt(start.substring(0,1));
        log[1] = Integer.parseInt(start.substring(start.length()-1));

        return log;
    }

    public int[] getEnd() {
        String[] ends = end.split(",");
        int[] log = new int[2];
        log[0] = Integer.parseInt(ends[0]);
        log[1] =Integer.parseInt(ends[1]);
        return log;
    }

    public static boolean CoordsCheck(int a, int b){
        return a == b;
    }

}
