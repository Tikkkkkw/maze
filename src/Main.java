import java.io.File;
import java.io.FileNotFoundException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] maze = getMaze("src/maze");
        mazePrint(maze);
        Maze puzzle = new Maze(maze);
        ArrayList<int[]> coords = mazeCoords(maze,puzzle);

        for(int[] coord: coords ){
            System.out.println(Arrays.toString(coord));
        }
        System.out.println(Arrays.toString(puzzle.getStart()));

        System.out.println(Arrays.toString(puzzle.getEnd()));
    }

        public static ArrayList<int[]> mazeCoords(String[][]maze, Maze puzzle){
        ArrayList<int[]> coords = new ArrayList<int[]>();
        coords.add(puzzle.getStart());
        int[] current = puzzle.getStart();
        while (!Arrays.equals(current, puzzle.getEnd())){

            while((current[0] > maze.length)&&(current[1] > maze[0].length)){
            if(maze[current[0]+1][current[1]].equals(".")){
                maze[current[0]][current[1]] = "+";
                current[0] = current[0]+1;
                coords.add(current);
//                right
            }
            if(maze[current[0]-1][current[1]].equals(".")){
                maze[current[0]][current[1]] = "+";
                current[0] = current[0]-1;
                coords.add(current);
//               left
            }
            if(maze[current[0]][current[1]+1].equals(".")){
                maze[current[0]][current[1]] = "+";
                current[1] = current[1]+1;
                coords.add(current);
//                up
            }

            if(maze[current[0]][current[1]-1].equals(".")){
                maze[current[0]][current[1]] = "+";
                current[1] = current[1]-1;
                coords.add(current);
//                down
            }
        }
        }
        return coords;
        }




        public static void mazePrint(String[][] maze){
            for(String[]r : maze){
                for(String c : r){
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
        }
        catch (FileNotFoundException e) {
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