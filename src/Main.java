import java.io.File;
import java.io.FileNotFoundException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[][] maze = getMaze("src/maze");
        Maze puzzle = new Maze(maze);

        System.out.println("Starts" + Arrays.toString(puzzle.getStart()));
        System.out.println("Ends" + Arrays.toString(puzzle.getEnd()));
        ArrayList<String> an = mazeCoords(maze, puzzle);
        for (int i = 0; i < an.size()-1; i ++){
            System.out.print(an.get(i) + " ---> ");

        }
        System.out.println(an.get(an.size()-1));


    }

    public static ArrayList<String> mazeCoords(String[][] maze, Maze puzzle) {
        ArrayList<String> coords = new ArrayList<String>();
        coords.add(Arrays.toString(puzzle.getStart()));
        int[] current = puzzle.getStart();


        while (!(Maze.CoordsCheck(current[0], puzzle.getEnd()[0]) && Maze.CoordsCheck(current[1], puzzle.getEnd()[1]))) {;
            current = puzzle.getCurrent();
             if  (puzzle.goLeft(current)) {
                            coords.add(Arrays.toString(current));
//                            System.out.println(Arrays.toString(current));
                            maze[current[0]][current[1]] = "x";
                            //LEFT
                        }
            else if (puzzle.goRight(current)) {
                coords.add(Arrays.toString(current));
//                System.out.println(Arrays.toString(current));
                maze[current[0]][current[1]] = "x";
                //RIGHT
            }



            else if (puzzle.goUp(current)) {
                coords.add(Arrays.toString(current));
//                System.out.println(Arrays.toString(current));
                maze[current[0]][current[1]] = "x";
                //UP
            }

            else if  (puzzle.goDown(current)) {
                coords.add(Arrays.toString(current));
//                System.out.println(Arrays.toString(current));
                maze[current[0]][current[1]] = "x";
                //DOWN
            }
            else if (puzzle.deadEnd(current)) {
                coords.clear();

            }
//            mazePrint(maze);
        }
        coords.add(0, Arrays.toString(puzzle.getStart()));
        return coords;
    }

    public static void mazePrint(String[][] maze) {
        for (String[] r : maze) {
            for (String c : r) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static String[][] getMaze(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }

        ArrayList<String> fileData = new ArrayList<String>();
        while (s.hasNextLine())
            fileData.add(s.nextLine());

        int rows = fileData.size();
        int cols = fileData.get(0).length();

        String[][] maze = new String[rows][cols];

        for (int i = 0; i < fileData.size(); i++) {
            String d = fileData.get(i);
            for (int j = 0; j < d.length(); j++) {
                maze[i][j] = d.charAt(j) + "";
            }
        }
        return maze;

    }
}