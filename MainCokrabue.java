import java.util.*;

public class MainCokrabue {
    public static void main(String[] args) {
        MyAlgorithm algorithm = new MyAlgorithm();
        Scanner sc = new Scanner(System.in);
        int numCase = sc.nextInt();
        GraphM graph = new GraphM(false, false, numCase + 1);

        while (true) {
            String i1 = sc.next();
            if (i1.equals("0"))
                break;
            String i2 = sc.next();
            graph.addEdge(i1.charAt(0) - 64, i2.charAt(0) - 64, 1);
        }

        int checkCase = sc.nextInt();

        List<String> result = new ArrayList<>();

        for (int i = 0; i < checkCase; i++) {
            String j1 = sc.next();
            String j2 = sc.next();

            List<Integer> find = algorithm.dfs(graph, j1.charAt(0) - 64);
            if (find.contains(j2.charAt(0) - 64)) {
                result.add("yes");
            } else {
                result.add("no");
            }
        }

        for (String opt : result) {
            System.out.println(opt);
        }
        sc.close();
    }
}