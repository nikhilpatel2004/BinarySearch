import java.util.ArrayList;

public class MergeBST {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = right = null;
        }
    }

    public static void getInorder(Node root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr); // Don't forget to traverse the right subtree
    }

    public static Node createBST(ArrayList<Integer> arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr, start, mid - 1);
        root.right = createBST(arr, mid + 1, end);
        return root;
    }

    public static Node merge(Node root1, Node root2) {
        // step1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        // step2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        // Merge two sorted arrays
        ArrayList<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) {
                merged.add(arr1.get(i));
                i++;
            } else {
                merged.add(arr2.get(j));
                j++;
            }
        }
        while (i < arr1.size()) {
            merged.add(arr1.get(i));
            i++;
        }
        while (j < arr2.size()) {
            merged.add(arr2.get(j));
            j++;
        }
        // Create a balanced BST from the merged sorted array
        return createBST(merged, 0, merged.size() - 1);
    }
public static  void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
}
    public static void main(String[] args) {
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node mergedRoot = merge(root1, root2);
        preorder(mergedRoot);

        // Optionally, you can print the inorder traversal of the merged BST to verify
//        ArrayList<Integer> result = new ArrayList<>();
//        getInorder(mergedRoot, result);
//        System.out.println(result); // Should print the merged BST in sorted order
    }
}