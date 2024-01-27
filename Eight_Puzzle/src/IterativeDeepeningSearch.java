import java.util.*;
public class IterativeDeepeningSearch {
    public static boolean iterativeDeepeningSearch(Node root, String[][] targetState, List<Node> path) {
        int maxDepth = 0;

        while (true) {
            boolean solutionFound = depthLimitedSearch(root, targetState, maxDepth, path);

            if (solutionFound) {
                return true;
            }

            maxDepth++;
        }
    }

    private static boolean depthLimitedSearch(Node node, String[][] targetState, int depthLimit, List<Node> path) {
        Stack<Node> stack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();

        stack.push(node);
        depthStack.push(0);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            int currentDepth = depthStack.pop();

            if (isSolution(current.getState(), targetState)) {
                buildPath(path, current);
                return true;
            }

            if (currentDepth < depthLimit) {
                if (current.down != null) {
                    stack.push(current.down);
                    depthStack.push(currentDepth + 1);
                }
                if (current.right != null) {
                    stack.push(current.right);
                    depthStack.push(currentDepth + 1);
                }
                if (current.up != null) {
                    stack.push(current.up);
                    depthStack.push(currentDepth + 1);
                }
                if (current.left != null) {
                    stack.push(current.left);
                    depthStack.push(currentDepth + 1);
                }
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
