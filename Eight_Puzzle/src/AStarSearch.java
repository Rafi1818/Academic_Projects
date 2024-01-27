import java.util.*;

public class AStarSearch{
    public static boolean aStarSearch(Node root, String[][] targetState, List<Node> path) {
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingInt(node ->
                node.cost + node.calculateHeuristicManhattan(targetState)));

        Set<Node> closedSet = new HashSet<>();

        openSet.add(root);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            if (isSolution(current.getState(), targetState)) {
                buildPath(path, current);
                return true;
            }

            closedSet.add(current);

            expandAndExplore(current, targetState, openSet, closedSet);
        }
        return false;
    }

    private static void expandAndExplore(Node node, String[][] targetState, PriorityQueue<Node> openSet, Set<Node> closedSet) {
        for (Node child : expand(node)) {
            if (closedSet.contains(child)) {
                continue;
            }

            int tentativeGCost = node.cost + 1;

            if (!openSet.contains(child) || tentativeGCost < child.cost) {
                child.cost = tentativeGCost;
                child.setParent(node);

                if (!openSet.contains(child)) {
                    openSet.add(child);
                }
            }
        }
    }

    private static List<Node> expand(Node node) {
        List<Node> children = new ArrayList<>();
        if(node.left != null){
            children.add(node.left);
        }
        if(node.right != null){
            children.add(node.right);
        }
        if(node.up != null){
            children.add(node.up);
        }
        if(node.down != null){
            children.add(node.down);
        }

        return children;
    }

    private static boolean isSolution(String[][] currentState, String[][] targetState) {
        for (int i = 0; i < currentState.length; i++) {
            for (int j = 0; j < currentState[i].length; j++) {
                if (!currentState[i][j].equals(targetState[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void buildPath(List<Node> path, Node node) {
        while (node != null) {
            path.add(0, node);
            node = node.getParent();
        }
    }
}
