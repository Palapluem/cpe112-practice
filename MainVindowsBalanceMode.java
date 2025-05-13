import java.util.Scanner;

public class MainVindowsBalanceMode {
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

        int balance = sc.nextInt();
        BinNode current = tree.root;
        while (current != null) {
            if (current.node == balance) {
                int balanceFactor = getBalanceFactor(current);
                System.out.println(balanceFactor);
                break;
            }
            if (current.node > balance) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }
        sc.close();
    }
}