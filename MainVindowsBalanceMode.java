public class MainVindowsBalanceMode {
    public static void main(String[] args) {
        MyAlgorithm algorithm = new MyAlgorithm();
        BST Tree = new BST();
        Tree.insertNode(4537);
        Tree.insertNode(3844);
        Tree.insertNode(8972);
        Tree.insertNode(1231);
        Tree.insertNode(4074);
        Tree.insertNode(1088);
        System.out.println(algorithm.findBalance(Tree, 4537));
        System.out.println(algorithm.findHeight(Tree, 4537));
    }
}