import java.util.*;

public class MainVindowsDuplicateMode {
    public static void main(String[] args) {
        MyAlgorithm algorithm = new MyAlgorithm();
        Scanner sc = new Scanner(System.in);
        BST tree = new BST();

        while (true) {
            int x = sc.nextInt();
            if (x == 0) {
                break;
            }
            tree.insertNode(x);
        }

        BST duplicateTree = new BST();
        duplicateTree.root = algorithm.duplicateTree(tree.root);
        sc.close();
    }
}
