import java.util.Scanner;

public class Maze {

    final static char[][] maze = {
            {'x','x','x','x','x','x','x'},
            {'x', 't', 'x', 't', 't', 't', 'x'},
            {'x', 't', 't', 't', 'x', 't', 'x'},
            {'x', 't', 'x','x','x','x','x'},
            {'x', 't', 't', 't', 't', 't', 'x'},
            {'x','x','x','x','x','t','x'},
            {'F', 't', 't', 't', 'x', 't', 'x'},
            {'x','x','t','t','t','t','x'},
            {'x','x','x','x','x','x','x'}};


    public static void main(String[] args){

        // pick a starting position (not on x) 2 points
        int xPos = 2;
        int yPos = 5;

        boolean notFinished = true;
        char up, down, left, right;
        Scanner scanner = new Scanner(System.in);
        String direction;

        // loop until done - 2 points
        while(notFinished){

            // precalculate - 4 points
            up = maze[xPos][yPos-1];
            down = maze[xPos][yPos+1];
            left = maze[xPos-1][yPos];
            right = maze[xPos+1][yPos];

            // prompt  - prompt 1 pt
            System.out.println("Which direction?");

            // with bonus hints
            System.out.println("Options are: "
                    // up
                    + (up != 'x' ? "up " : "")

                    // down
                    + (down != 'x' ? "down ": "")

                    // left
                    + (left != 'x' ? "left ": "")

                    // right
                    + (right != 'x' ? "right ": ""));

            // read 1 point
            direction = scanner.nextLine();

            // truncate loop - 4 points
            if((up == 'x' && direction.equals("up")) ||
                (down == 'x' && direction.equals("down")) ||
                (left == 'x' && direction.equals("left")) ||
                (right == 'x' && direction.equals("right"))){

                // notify - 1pt
                System.out.println("<<< Cant go " + direction);

                // dont update position after knowing its illegal - 1 point
                continue;
            }

            // notify - 1 point
            System.out.println(">>> Moving " + direction + "\n");

            //update position - 8 points
            switch(direction){
                case "up":
                    yPos--;
                    break;
                case "down":
                    yPos++;
                    break;
                case "right":
                    xPos++;
                    break;
                case "left":
                    xPos--;
            }

            // continue? - 1point
            notFinished = maze[xPos][yPos] != 'F';
        }

        // notify - 1 point
        System.out.println("Good job. All done");

    }
}