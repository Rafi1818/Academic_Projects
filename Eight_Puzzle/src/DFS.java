import java.util.*;

public class DFS {
    public static boolean depthFirstSearch(Node root, String[][] targetState, List<Node> path) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();


            if (isSolution(current.getState(), targetState)) {
                buildPath(path, current);
                return true;
            }

            if (current.down != null) {
                stack.push(current.down);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.up != null) {
                stack.push(current.up);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return false;
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
