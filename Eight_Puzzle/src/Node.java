
public class Node {
    Node left;
    Node right;
    Node up;
    Node down;
    Node parent;
    int cost;
    String[][] str = new String[3][3];
    public Node(String[][] str, int cost){
        this.str = str;
        this.cost = cost;
        this.parent = null;
    }
    public String[][] getState(){
        return str;
    }
    public void setParent(Node parent){
        this.parent = parent;
    }
    public Node getParent(){
        return parent;
    }

    public void displayState(String move){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == 1 && j == 2){
                    if (str[i][j].equals("*")) {
                        System.out.print("   " + "->" + "  " + move);
                    } else {
                        System.out.print(str[i][j] + "  " + "->" + "  " + move);
                    }

                }
                else {
                    if (str[i][j].equals("*")) {
                        System.out.print("  ");
                    }
                    else {
                        System.out.print(str[i][j] + " ");
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }


    public int calculateHeuristicManhattan(String[][] goalState) {
        int distance = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String tile = str[i][j];
                if (!tile.equals("*")) {
                    int[] goalPosition = findPosition(goalState, tile);
                    if (goalPosition == null) {
                        continue;
                    }
                    distance += Math.abs(i - goalPosition[0]) + Math.abs(j - goalPosition[1]);
                }
            }
        }

        return distance;
    }

    public int calculateHeuristicMisplacedTiles(String[][] goalState){
        int misplacedTiles = 0;

        String[][] currentState = getState();
        for (int i = 0; i < currentState.length; i++) {
            for (int j = 0; j < currentState[i].length; j++) {
                if (!currentState[i][j].equals("*") && !currentState[i][j].equals(goalState[i][j])) {
                    misplacedTiles++;
                }
            }
        }

        return misplacedTiles;
    }



    private int[] findPosition(String[][] state, String tile) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (state[i][j].equals(tile)) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
