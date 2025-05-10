
// Implement your code in this file
import java.util.*;

public class MyAlgorithm extends Algorithm {

    public MyAlgorithm() {
        super();
    }

    public BST cloneTree(BST tree) {
        BST newTree = new BST();
        List<Integer> Order = preorder(tree);
        for (int i : Order) {
            newTree.insertNode(i);
        }
        return newTree;
    }

    public BST insertDuplicateTree(BST tree, int node) {
        BST newTree = cloneTree(tree);
        newTree.insertNode(node);
        return newTree;
    }

    public int findBalance(BST tree, int Node) {
        BinNode targetNode = findNode(tree.root, Node);
        if (targetNode == null)
            return -1;
        int leftHeight = findHeight(targetNode.leftChild);
        int rightHeight = findHeight(targetNode.rightChild);
        return leftHeight - rightHeight;
    }

    public int findHeight(BST tree, int Node) {
        BinNode targetNode = findNode(tree.root, Node);
        if (targetNode == null)
            return -1;
        int leftHeight = findHeight(targetNode.leftChild);
        int rightHeight = findHeight(targetNode.rightChild);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private int findHeight(BinNode curNode) {
        if (curNode == null)
            return 0;
        int leftHeight = findHeight(curNode.leftChild);
        int rightHeight = findHeight(curNode.rightChild);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private BinNode findNode(BinNode curNode, int Node) {
        if (curNode == null)
            return null;
        if (curNode.node == Node)
            return curNode;
        if (Node < curNode.node)
            return findNode(curNode.leftChild, Node);
        return findNode(curNode.rightChild, Node);
    }

    public List<Integer> preorder(BST tree) {
        List<Integer> result = new ArrayList<>();
        preorderUtil(tree.root, result);
        return result;
    }

    public void preorderUtil(BinNode curNode, List<Integer> result) {
        if (curNode != null) {
            result.add(curNode.node);
            preorderUtil(curNode.leftChild, result);
            preorderUtil(curNode.rightChild, result);
        }
    }

    public List<Integer> inorder(BST tree) {
        List<Integer> result = new ArrayList<>();
        inorderUtil(tree.root, result);
        return result;
    }

    public void inorderUtil(BinNode curNode, List<Integer> result) {
        if (curNode != null) {
            inorderUtil(curNode.leftChild, result);
            result.add(curNode.node);
            inorderUtil(curNode.rightChild, result);
        }
    }

    public List<Integer> postorder(BST tree) {
        List<Integer> result = new ArrayList<>();
        postorderUtil(tree.root, result);
        return result;
    }

    public void postorderUtil(BinNode curNode, List<Integer> result) {
        if (curNode != null) {
            postorderUtil(curNode.leftChild, result);
            postorderUtil(curNode.rightChild, result);
            result.add(curNode.node);
        }
    }

    public List<Integer> dfs(GraphM graph, int startNode) {
        List<Integer> result = new ArrayList<>();
        boolean[] isVisited = new boolean[graph.numVertices];
        dfsUtil(graph, startNode, isVisited, result);
        return result;
    }

    public void dfsUtil(GraphM graph, int curNode, boolean[] isVisited, List<Integer> result) {
        isVisited[curNode] = true;
        result.add(curNode);
        for (int i = 0; i < graph.numVertices; i++) {
            if (graph.matrix[curNode][i] != 0 && !isVisited[i]) {
                dfsUtil(graph, i, isVisited, result);
            }
        }
    }

    public List<Integer> bfs(GraphL graph, int startNode) {
        List<Integer> result = new ArrayList<>();
        boolean[] isVisited = new boolean[graph.numVertices];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startNode);
        isVisited[startNode] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);
            for (Pair<Integer, Integer> neighbor : graph.adjacencyList.getOrDefault(current, new ArrayList<>())) {
                if (!isVisited[neighbor.first]) {
                    queue.add(neighbor.first);
                    isVisited[neighbor.first] = true;
                }
            }
        }
        return result;
    }

    public int floyd(GraphM graph, int startNode, int destNode) {
        int[][] dist = new int[graph.numVertices][graph.numVertices];
        for (int i = 0; i < graph.numVertices; i++) {
            for (int j = 0; j < graph.numVertices; j++) {
                dist[i][j] = graph.matrix[i][j];
            }
        }
        // หรือใช้ int[][] dist = graph.matrix.clone(); แทนการลูปทั้งหมดก็ได้

        for (int k = 0; k < graph.numVertices; k++) {
            for (int i = 0; i < graph.numVertices; i++) {
                for (int j = 0; j < graph.numVertices; j++) {
                    if (dist[i][k] != 0 && dist[k][j] != 0 && i != j) {
                        if (dist[i][j] == 0) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        } else {
                            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        }
                    }
                }
            }
        }
        return dist[startNode][destNode];
    }

    public int[][] floydMatrix(GraphM graph) {
        int[][] dist = new int[graph.numVertices][graph.numVertices];
        for (int i = 0; i < graph.numVertices; i++) {
            for (int j = 0; j < graph.numVertices; j++) {
                dist[i][j] = graph.matrix[i][j];
            }
        }
        // หรือใช้ int[][] dist = graph.matrix.clone(); แทนการลูปทั้งหมดก็ได้

        for (int k = 0; k < graph.numVertices; k++) {
            for (int i = 0; i < graph.numVertices; i++) {
                for (int j = 0; j < graph.numVertices; j++) {
                    if (dist[i][k] != 0 && dist[k][j] != 0 && i != j) {
                        if (dist[i][j] == 0) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        } else {
                            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        }
                    }
                }
            }
        }
        return dist;
    }

    public boolean warshall(GraphM graph, int startNode, int destNode) {
        int[][] dist = new int[graph.numVertices][graph.numVertices];
        // หรือใช้ int[][] dist = graph.matrix.clone(); ก็ได้
        for (int k = 0; k < graph.numVertices; k++) {
            for (int i = 0; i < graph.numVertices; i++) {
                for (int j = 0; j < graph.numVertices; j++) {
                    if (dist[i][k] != 0 && dist[k][j] != 0) {
                        dist[i][j] = 1;
                    }
                }
            }
        }
        return (dist[startNode][destNode] == 1);
    }

    public int[][] warshallMatrix(GraphM graph) {
        int[][] dist = new int[graph.numVertices][graph.numVertices];
        // หรือใช้ int[][] dist = graph.matrix.clone(); ก็ได้
        for (int k = 0; k < graph.numVertices; k++) {
            for (int i = 0; i < graph.numVertices; i++) {
                for (int j = 0; j < graph.numVertices; j++) {
                    if (dist[i][k] == 1 && dist[k][j] == 1) {
                        dist[i][j] = 1;
                    }
                }
            }
        }
        return dist;
    }

    public int dijkstra(GraphL graph, int startNode, int destNode) {
        int[] result = new int[graph.numVertices];
        boolean[] isVisited = new boolean[graph.numVertices];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[startNode] = 0;
        for (int i = 0; i < graph.numVertices; i++) {
            int curNode = -1;
            int minDist = Integer.MAX_VALUE;
            for (int j = 0; j < graph.numVertices; j++) {
                if (!isVisited[j] && result[j] < minDist) {
                    minDist = result[j];
                    curNode = j;
                }
            }
            if (curNode == -1) {
                break;
            }

            isVisited[curNode] = true;
            for (Pair<Integer, Integer> neighbor : graph.adjacencyList.get(curNode)) {
                if (!isVisited[neighbor.first] && result[curNode] + neighbor.second < result[neighbor.first]) {
                    result[neighbor.first] = result[curNode] + neighbor.second;
                }
            }
        }
        return result[destNode];
    }
}