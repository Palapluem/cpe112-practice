import java.util.*;

public class MainNetworkEngineer {
    public static void main(String[] args) {
        MyAlgorithm algorithm = new MyAlgorithm();
        Scanner sc = new Scanner(System.in);
        int ns = sc.nextInt();
        int c = sc.nextInt();

        GraphM graph = new GraphM(false, true, ns);

        for (int i = 0; i < c; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int time = sc.nextInt();
            graph.addEdge(src - 1, dest - 1, time);
        }

        int[][] dist = algorithm.floydMatrix(graph);
        List<Integer> answer = new ArrayList<>();
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            List<Integer> result = new ArrayList<>();
            int s = sc.nextInt();
            for (int j = 0; j < ns; j++) {
                result.add(dist[s - 1][j]);
            }
            answer.add(Collections.max(result));
        }

        for (int i : answer) {
            System.out.println(i);
        }
        sc.close();
    }
}
