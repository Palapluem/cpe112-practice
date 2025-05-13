
// Implement your code in this file
import java.util.*;

public class MyAlgorithm extends Algorithm {

    public MyAlgorithm() {
        super();
    }

    public BinNode duplicateTree(BinNode node) {
        if (node == null) {
            return null;
        }
        BinNode newNode = new BinNode(node.node);
        newNode.leftChild = duplicateTree(node.leftChild);
        newNode.rightChild = duplicateTree(node.rightChild);
        return newNode;
    }

    public int height(BinNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.leftChild), height(node.rightChild)) + 1;
    }

    public int getBalanceFactor(BinNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.leftChild) - height(node.rightChild);
    }

    public BinNode searchNode(BinNode root, int key) {
        if (root == null || root.node == key) {
            return root;
        }

        if (key < root.node) {
            return searchNode(root.leftChild, key);
        } else {
            return searchNode(root.rightChild, key);
        }
    }

    public List<Integer> preorder(BST tree) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(tree.root, result);
        return result;
    }

    public void preorderTraversal(BinNode curNode, List<Integer> result) {
        if (curNode == null) {
            return;
        }
        result.add(curNode.node);
        preorderTraversal(curNode.leftChild, result);
        preorderTraversal(curNode.rightChild, result);
    }

    public List<Integer> inorder(BST tree) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(tree.root, result);
        return result;
    }

    public void inorderTraversal(BinNode curNode, List<Integer> result) {
        if (curNode == null) {
            return;
        }
        inorderTraversal(curNode.leftChild, result);
        result.add(curNode.node);
        inorderTraversal(curNode.rightChild, result);
    }

    public List<Integer> postorder(BST tree) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(tree.root, result);
        return result;
    }

    public void postorderTraversal(BinNode curNode, List<Integer> result) {
        if (curNode == null) {
            return;
        }
        postorderTraversal(curNode.leftChild, result);
        postorderTraversal(curNode.rightChild, result);
        result.add(curNode.node);
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
                int neighborNode = neighbor.first;
                if (!isVisited[neighbor.first]) {
                    isVisited[neighbor.first] = true;
                    queue.add(neighbor.first);
                }
            }
        }
        return result;
    }

    public int bfsDistance(GraphL graph, int startNode, int destNode) {
        List<Integer> result = new ArrayList<>();
        boolean[] isVisited = new boolean[graph.numVertices];
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[graph.numVertices];

        Arrays.fill(dist, -1);
        queue.add(startNode);
        isVisited[startNode] = true;
        dist[startNode] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);
            for (Pair<Integer, Integer> neighbor : graph.adjacencyList.getOrDefault(current, new ArrayList<>())) {
                int neighborNode = neighbor.first;
                if (!isVisited[neighbor.first]) {
                    isVisited[neighbor.first] = true;
                    dist[neighborNode] = dist[current] + 1;
                    queue.add(neighbor.first);
                }
            }
        }
        return -1;
    }

    public int floyd(GraphM graph, int startNode, int destNode) {
        int[][] dist = new int[graph.numVertices][graph.numVertices];
        for (int i = 0; i < graph.numVertices; i++) {
            for (int j = 0; j < graph.numVertices; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else if (dist[i][j] != 0) {
                    dist[i][j] = graph.matrix[i][j];
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int k = 0; k < graph.numVertices; k++) {
            for (int i = 0; i < graph.numVertices; i++) {
                if (dist[i][k] == Integer.MAX_VALUE) {
                    continue;
                }
                for (int j = 0; j < graph.numVertices; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        return dist[startNode][destNode] == Integer.MAX_VALUE ? -1 : dist[startNode][destNode];
    }

    public boolean warshall(GraphM graph, int startNode, int destNode) {
        boolean[][] reach = new boolean[graph.numVertices][graph.numVertices];
        for (int i = 0; i < graph.numVertices; i++) {
            for (int j = 0; j < graph.numVertices; j++) {
                if (i == j || graph.matrix[i][j] != 0) {
                    reach[i][j] = true;
                }
            }
        }

        for (int k = 0; k < graph.numVertices; k++) {
            for (int i = 0; i < graph.numVertices; i++) {
                for (int j = 0; j < graph.numVertices; j++) {
                    if (reach[i][k] && reach[k][j]) {
                        reach[i][j] = true;
                    }
                }
            }
        }
        return reach[startNode][destNode];
    }

    public int dijkstra(GraphL graph, int startNode, int destNode) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(pair -> pair[1]));
        int[] dist = new int[graph.numVertices + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startNode] = 0;

        pq.add(new int[] { startNode, 0 });

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int curNode = current[0];

            if (curNode == destNode) {
                break;
            }

            if (graph.adjacencyList.containsKey(curNode)) {
                for (Pair<Integer, Integer> neighbor : graph.adjacencyList.get(curNode)) {
                    int neighborNode = neighbor.first;
                    int weight = neighbor.second;

                    if (dist[curNode] + weight < dist[neighborNode]) {
                        dist[neighborNode] = dist[curNode] + weight;
                        pq.add(new int[] { neighborNode, dist[neighborNode] });
                    }
                }
            }
        }
        return dist[destNode] == Integer.MAX_VALUE ? -1 : dist[destNode];
    }
}