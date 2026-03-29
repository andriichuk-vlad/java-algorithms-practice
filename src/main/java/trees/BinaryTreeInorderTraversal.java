package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    static List<Integer> nodes = new ArrayList<>();
    public static List<Integer> inorderTraversalRecursive(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            nodes.add(root.val);
            inorderTraversal(root.right);
        }
        return nodes;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.empty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            nodes.add(current.val);
            current = current.right;
        }

        return nodes;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.left.left = new TreeNode(0);
        treeNode.right = new TreeNode(3);


        System.out.println(inorderTraversal(treeNode));
    }
}

