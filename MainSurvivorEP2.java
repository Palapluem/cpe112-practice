import java.util.*;

public class MainSurvivorEP2 {
    public static void main(String[] arg) {
        MyAlgorithm algorithm = new MyAlgorithm();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        GraphM graph = new GraphM(false, false, n);
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v, 1);
        }

        int Steve = sc.nextInt();
        int villain = sc.nextInt();
        int zombie = sc.nextInt();

        int[][] ans = algorithm.floydMatrix(graph);
        if (ans[Steve][villain] <= ans[zombie][villain]) {
            System.out.println("SAFE");
        } else {
            System.out.println("TOO LATE");
        }
        sc.close();
    }
}
