import java.util.*;

public class MainMagicPowder {
    public static void main(String[] args) {
        MyAlgorithm algorithm = new MyAlgorithm();
        Scanner sc = new Scanner(System.in);
        int node = sc.nextInt();
        int edge = sc.nextInt();
        sc.nextLine();

        GraphL graph = new GraphL(false, false, node + 1, edge);
        List<Integer> doubleBonds = new ArrayList<>();

        for (int i = 0; i < edge; i++) {
            int a = sc.nextInt();
            String bond = sc.next();
            int b = sc.nextInt();

            if (bond.equals("=")) {
                doubleBonds.add(a);
                doubleBonds.add(b);
            }
            graph.addEdge(a, b, 1);
        }

        List<Integer> srcNode = new ArrayList<>();
        for (int vertex : graph.adjacencyList.keySet()) {
            List<Pair<Integer, Integer>> neighbor = graph.adjacencyList.get(vertex);
            if (neighbor != null && neighbor.size() == 1) {
                srcNode.add(vertex);
            }
        }

        List<Integer> dist = new ArrayList<>();
        for (int n2 : doubleBonds) {
            for (int n1 : srcNode) {
                int result = algorithm.dijkstra(graph, n1, n2);
                dist.add(result);
            }
        }
        System.out.println(Collections.min(dist) + 1);
        sc.close();
    }
}