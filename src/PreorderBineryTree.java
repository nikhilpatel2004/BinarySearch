import java.util.LinkedList;
import java.util.Queue;

public class PreorderBineryTree {
    static class Node {
        int data;
        Node left;
        Node right;


        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    static class BinaryTree {
        static int idx= -1;
        public static Node BuildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return  null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = BuildTree(nodes);
            newNode.right = BuildTree(nodes);
            return newNode;
        }
        public static void Preorder(Node root){
            if(root==null){
                return;
            }
            System.out.print(root.data+" ");
            Preorder(root.left);
            Preorder(root.right);
        }
        public static void Inorder(Node root){
            if(root==null){
                return;
            }
            Inorder(root.left);
            System.out.print(root.data+" ");
            Inorder(root.right);
        }
        public static void Postorder(Node root){
            if(root==null){
                return;
            }
            Postorder(root.left);
            Postorder(root.right);
            System.out.print(root.data+" ");
        }
        public static void levelOrder(Node root) {
            if(root==null){
                return;
            }
            Queue<Node> q = new LinkedList<Node>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                    Node currNode = q.remove();
                    if(currNode == null){
                        System.out.println();
                        if(q.isEmpty()){
                            break;
                        }else{
                            q.add(null);
                        }

                    }else{
                        System.out.print(currNode.data+" ");
                        if(currNode.left!=null){
                            q.add(currNode.left);
                        }
                        if(currNode.right!=null){
                            q.add(currNode.right);

                        }
                    }
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree  tree= new BinaryTree();
        Node root = tree.BuildTree(arr);
        //System.out.println(root.data);

        System.out.print("Preorder = ");
        tree.Preorder(root);

        System.out.print("Inorder = ");
        tree.Inorder(root);
        System.out.println("Postorder = ");
        tree.Postorder(root);
        System.out.println("Level order = ");
        tree.levelOrder(root);
    }
}
