import java.util.*;

public class MainSurvivorEP1 {
    public static void main(String[] arg) {
        MyAlgorithm algorithm = new MyAlgorithm();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        GraphM graph = new GraphM(true, false, n);
        for (int i = 0; i < n; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int dist = sc.nextInt();
            graph.addEdge(src, dest, dist);
        }

        int[][] ans = algorithm.floydMatrix(graph);
        for (int i = 0; i < n; i++) {
            List<Integer> result = new ArrayList<>();
            System.out.print("From Cave " + i + ", reachable caves:");
            for (int j = 0; j < n; j++) {
                if (ans[i][j] != 0 || i == j) {
                    result.add(j);
                }
            }
            System.out.println(result);
        }
        sc.close();
    }
}