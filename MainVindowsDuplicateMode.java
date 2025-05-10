import java.util.*;

public class MainVindowsDuplicateMode {
    public static void main(String[] args) {
        MyAlgorithm algorithm = new MyAlgorithm();
        BST Tree = new BST();
        Tree.insertNode(4537);
        Tree.insertNode(3844);
        Tree.insertNode(8972);
        Tree.insertNode(1231);
        Tree.insertNode(4074);
        System.out.println(algorithm.preorder(Tree));

        BST newTree = algorithm.insertDuplicateTree(Tree, 1088);
        System.out.println(algorithm.preorder(newTree));
    }
}
