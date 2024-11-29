public class HeightOfTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;


        }
    }
    public static  int height(Node root) {
        if (root == null) {
            return 0;

        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public static int CountNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return CountNodes(root.left) + CountNodes(root.right) +1;
    }
    public static int SumOfHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return SumOfHeight(root.left) + SumOfHeight(root.right)+root.data;
    }

    public static void main(String[] args) {
/*
                     1
                    / \
                   2   3
                  / \  / \
                 4   5 6  7

                   */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("Height of tree = "+height(root));
        System.out.println("Count Of tree = "+CountNodes(root));
        System.out.println("Sum of height of tree = "+SumOfHeight(root));
    }

}
