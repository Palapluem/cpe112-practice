import java.util.*;

public class MainTest {
    public static void main(String[] args) {
        MyAlgorithm algorithm = new MyAlgorithm();
        Scanner sc = new Scanner(System.in);
        BST tree = new BST();

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int node = sc.nextInt();
            tree.insertNode(node);
        }

        List<Integer> inorder = algorithm.inorder(tree);
        for (int num : inorder) {
            System.out.print(num + " ");
        }
    }
}
