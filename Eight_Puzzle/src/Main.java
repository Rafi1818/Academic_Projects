import java.util.*;

public class Main {
    public static void main(String[] args){
        String[][] state = new String[3][3];
        populateState(state);

        String[][] targetState = new String[3][3];
        getTargetState(targetState);

        Node root = new Node(state, 0);

        root.displayState("Initial State");

        createTree(root, 1);


        //DFS Solution
        List<Node> pathToSolution = new ArrayList<>();
        boolean solutionFound = DFS.depthFirstSearch(root, targetState, pathToSolution);

        if(solutionFound){
            System.out.println("DFS Solution:\n");
            int i = 0;
            for (Node node : pathToSolution) {
                node.displayState("State: " + Integer.toString(i));
                i++;
            }
            System.out.println("Number of moves = " + (i-1) + "\n");
        }
        else{
            System.out.println("Solution not found.");
        }


        //Iterative Deepening Search Solution
        pathToSolution = new ArrayList<>();
        solutionFound = IterativeDeepeningSearch.iterativeDeepeningSearch(root, targetState, pathToSolution);

        if(solutionFound){
            System.out.println("Iterative Deepening Search Solution:\n");
            int i = 0;
            for (Node node : pathToSolution) {
                node.displayState("State: " + Integer.toString(i));
                i++;
            }
            System.out.println("Number of moves = " + (i-1) + "\n");
        }
        else{
            System.out.println("Solution not found.");
        }

        //A* Search Solution Using Heuristic 1
        pathToSolution = new ArrayList<>();
        solutionFound = AStarSearch.aStarSearch(root, targetState, pathToSolution);

        if(solutionFound){
            int i = 0;
            System.out.println("A* Search Solution (Heuristic 1): \n");
            for (Node node : pathToSolution) {
                node.displayState("State: " + Integer.toString(i));
                i++;
            }
            System.out.println("Number of moves = " + (i-1) + "\n");
        }
        else{
            System.out.println("Solution not found.");
        }

        //A* Search Solution Using Heuristic 2
        pathToSolution = new ArrayList<>();
        solutionFound = AStarSearchTwo.aStarSearch(root, targetState, pathToSolution);

        if(solutionFound){
            int i = 0;
            System.out.println("A* Search Solution (Heuristic 2): \n");
            for (Node node : pathToSolution) {
                node.displayState("State: " + Integer.toString(i));
                i++;
            }
            System.out.println("Number of moves = " + (i-1) + "\n");
        }
        else{
            System.out.println("Solution not found.");
        }
    }

    public static String[][] populateState(String str[][]){
        str[0][0] = "1";
        str[0][1] = "2";
        str[0][2] = "3";
        str[1][0] = "4";
        str[1][1] = "5";
        str[1][2] = "*";
        str[2][0] = "7";
        str[2][1] = "8";
        str[2][2] = "6";
        return str;
    }

    public static String[][] getTargetState(String str[][]){
        str[0][0] = "1";
        str[0][1] = "2";
        str[0][2] = "3";
        str[1][0] = "4";
        str[1][1] = "5";
        str[1][2] = "6";
        str[2][0] = "7";
        str[2][1] = "8";
        str[2][2] = "*";
        return str;
    }

    public static void createTree(Node node, int level){
        if(level <= 15){
            String[][] str = node.getState();
            if(str[0][0].equals("*")){

                //right move
                String[][] strRight = moveRight(str, 0, 0);
                node.right = new Node(strRight, level);
                node.right.setParent(node);
                createTree(node.right, level + 1);

                //down move
                String[][] strDown = moveDown(str, 0, 0);
                node.down = new Node(strDown, level);
                node.down.setParent(node);
                createTree(node.down, level + 1);
            }
            else if(str[0][1].equals("*")){

                //left move
                String[][] strLeft = moveLeft(str, 0, 1);
                node.left = new Node(strLeft, level);
                node.left.setParent(node);
                createTree(node.left, level + 1);

                //right move
                String[][] strRight = moveRight(str, 0, 1);
                node.right = new Node(strRight, level);
                node.right.setParent(node);
                createTree(node.right, level + 1);

                //down move
                String[][] strDown = moveDown(str, 0, 1);
                node.down = new Node(strDown, level);
                node.down.setParent(node);
                createTree(node.down, level + 1);
            }
            else if(str[0][2].equals("*")){

                //left move
                String[][] strLeft = moveLeft(str, 0, 2);
                node.left = new Node(strLeft, level);
                node.left.setParent(node);
                createTree(node.left, level + 1);

                //down move
                String[][] strDown = moveDown(str, 0, 2);
                node.down = new Node(strDown, level);
                node.down.setParent(node);
                createTree(node.down, level + 1);
            }
            else if(str[1][0].equals("*")){

                //right move
                String[][] strRight = moveRight(str, 1, 0);
                node.right = new Node(strRight, level);
                node.right.setParent(node);
                createTree(node.right, level + 1);

                //up move
                String[][] strUp = moveUp(str, 1, 0);
                node.up = new Node(strUp, level);
                node.up.setParent(node);
                createTree(node.up, level + 1);

                //down move
                String[][] strDown = moveDown(str, 1, 0);
                node.down = new Node(strDown, level);
                node.down.setParent(node);
                createTree(node.down, level + 1);
            }

            else if(str[1][1].equals("*")){

                //left move
                String[][] strLeft = moveLeft(str, 1, 1);
                node.left = new Node(strLeft, level);
                node.left.setParent(node);
                createTree(node.left, level + 1);

                //right move
                String[][] strRight = moveRight(str, 1, 1);
                node.right = new Node(strRight, level);
                node.right.setParent(node);
                createTree(node.right, level + 1);

                //up move
                String[][] strUp = moveUp(str, 1, 1);
                node.up = new Node(strUp, level);
                node.up.setParent(node);
                createTree(node.up, level + 1);

                //down move
                String[][] strDown = moveDown(str, 1, 1);
                node.down = new Node(strDown, level);
                node.down.setParent(node);
                createTree(node.down, level + 1);
            }
            else if(str[1][2].equals("*")){

                //left move
                String[][] strLeft = moveLeft(str, 1, 2);
                node.left = new Node(strLeft, level);
                node.left.setParent(node);
                createTree(node.left, level + 1);

                //up move
                String[][] strUp = moveUp(str, 1, 2);
                node.up = new Node(strUp, level);
                node.up.setParent(node);
                createTree(node.up, level + 1);

                //down move
                String[][] strDown = moveDown(str, 1, 2);
                node.down = new Node(strDown, level);
                node.down.setParent(node);
                createTree(node.down, level + 1);
            }
            else if(str[2][0].equals("*")){

                //right move
                String[][] strRight = moveRight(str, 2, 0);
                node.right = new Node(strRight, level);
                node.right.setParent(node);
                createTree(node.right, level + 1);

                //up move
                String[][] strUp = moveUp(str, 2, 0);
                node.up = new Node(strUp, level);
                node.up.setParent(node);
                createTree(node.up, level + 1);
            }
            else if(str[2][1].equals("*")){

                //left move
                String[][] strLeft = moveLeft(str, 2, 1);
                node.left = new Node(strLeft, level);
                node.left.setParent(node);
                createTree(node.left, level + 1);

                //right move
                String[][] strRight = moveRight(str, 2, 1);
                node.right = new Node(strRight, level);
                node.right.setParent(node);
                createTree(node.right, level + 1);

                //up move
                String[][] strUp = moveUp(str, 2, 1);
                node.up = new Node(strUp, level);
                node.up.setParent(node);
                createTree(node.up, level + 1);
            }
            else if(str[2][2].equals("*")){

                //left move
                String[][] strLeft = moveLeft(str, 2, 2);
                node.left = new Node(strLeft, level);
                node.left.setParent(node);
                createTree(node.left, level + 1);

                //up move
                String[][] strUp = moveUp(str, 2, 2);
                node.up = new Node(strUp, level);
                node.up.setParent(node);
                createTree(node.up, level + 1);
            }
        }
        

    }

    public static String[][] moveUp(String[][] str, int m, int n){
        String[][] up = new String[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == m && j == n){
                    up[i][j] = str[m-1][n];
                }
                else if(i == m-1 && j == n){
                    up[i][j] = str[m][n];
                }
                else{
                    up[i][j] = str[i][j];
                }
            }
        }
        return up;
    }

    public static String[][] moveRight(String[][] str, int m, int n){
        String[][] right = new String[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == m && j == n){
                    right[i][j] = str[m][n+1];
                }
                else if(i == m && j == n+1){
                    right[i][j] = str[m][n];
                }
                else{
                    right[i][j] = str[i][j];
                }
            }
        }
        return right;
    }

    public static String[][] moveDown(String[][] str, int m, int n){
        String[][] down = new String[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == m && j == n){
                    down[i][j] = str[m+1][n];
                }
                else if(i == m+1 && j == n){
                    down[i][j] = str[m][n];
                }
                else{
                    down[i][j] = str[i][j];
                }
            }
        }
        return down;
    }

    public static String[][] moveLeft(String[][] str, int m, int n){
        String[][] left = new String[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == m && j == n){
                    left[i][j] = str[m][n-1];
                }
                else if(i == m && j == n-1){
                    left[i][j] = str[m][n];
                }
                else{
                    left[i][j] = str[i][j];
                }
            }
        }
        return left;
    }
}
