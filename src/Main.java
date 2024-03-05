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

        System.out.println("Ends" + Arrays.toString(puzzle.getEnd()));
        System.out.println(Arrays.toString(puzzle.getStart()));
        ArrayList<int[]> coords = mazeCoords(maze,puzzle);

    }

        public static ArrayList<int[]> mazeCoords(String[][]maze, Maze puzzle){
        ArrayList<int[]> coords = new ArrayList<int[]>();
        coords.add(puzzle.getStart());

        int[] current = puzzle.getStart();

        while (!((Maze.CoordsCheck(current[0],puzzle.getEnd()[0]))&&(Maze.CoordsCheck(current[1],puzzle.getEnd()[1])))){


                if((current[0] + 1 < maze.length ) && (maze[current[0]+1][current[1]].equals("."))){
                maze[current[0]][current[1]] = "+";
                current[0] = current[0]+1;

                for(String[] row: maze){
                    for (String colum : row){
                        System.out.print(colum);
                    }
                    System.out.println();
                }

                    System.out.println();
                coords.add(current);
//                right
             }

                if((current[0]-1 > 0) && (maze[current[0]-1][current[1]].equals("."))){
                maze[current[0]][current[1]] = "+";
                current[0] = current[0]-1;
                    for(String[] row: maze){
                        for (String colum : row){
                            System.out.print(colum);
                        }
                        System.out.println();
                    }
                    System.out.println();
                coords.add(current);
//               left
            }
                if((current[1] + 1 < maze[0].length) && maze[current[0]][current[1]+1].equals(".")){
                maze[current[0]][current[1]] = "+";
                current[1] = current[1]+1;
                    for(String[] row: maze){
                        for (String colum : row){
                            System.out.print(colum);
                        }
                        System.out.println();
                    }
                    System.out.println();
                coords.add(current);
//                down
            }
                if((current[1] > 0) && maze[current[0]][current[1]-1].equals(".")){
                maze[current[0]][current[1]] = "+";

                current[1] = current[1]-1;
                    for(String[] row: maze){
                        for (String colum : row){
                            System.out.print(colum);
                        }
                        System.out.println();
                    }
                    System.out.println();
                coords.add(current);
//                up
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