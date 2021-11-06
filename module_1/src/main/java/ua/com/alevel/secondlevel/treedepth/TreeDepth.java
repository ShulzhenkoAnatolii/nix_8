package ua.com.alevel.secondlevel.treedepth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TreeDepth {

    public void run() throws IOException {
        System.out.println("The program calculates the maximum depth of the binary tree.\n" +
                "Enter an array of integers, the first number will be the root.\n" +
                "Example ---> 24 16 38 12 8 ... ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Your array ---> ");
        String[] inputTree = reader.readLine().split("\\s");
        try {
            TreeNode root = new TreeNode(Integer.parseInt(inputTree[0]));
            for (int i = 1; i < inputTree.length; i++) {
                insert(root, Integer.parseInt(inputTree[i]));
            }
            System.out.println(maxDepth(root));
        } catch (Exception e) {
            System.out.println("Data entered incorrectly");
        }
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        return leftMaxDepth > rightMaxDepth ? leftMaxDepth + 1 : rightMaxDepth + 1;
    }

    private void insert(TreeNode node, int value) {
        if (value < node.val) {
            if (node.left != null) {
                insert(node.left, value);
            } else node.left = new TreeNode(value);
        } else if (value > node.val) {
            if (node.right != null) {
                insert(node.right, value);
            } else node.right = new TreeNode(value);
        }
    }
}
