

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _257 {

    public static void main(String[] args) {

    }

    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            ArrayList<String> paths = new ArrayList<>();
            if (root == null) {
                return paths;
            }
            dfs(root, paths, "");
            return paths;

        }

        public void dfs(TreeNode root, List<String> paths, String path) {
            if (root.left == null && root.right == null) {
                paths.add(path + root.val);
                return;
            }

            path += root.val + "->";
            if (root.left != null) {
                dfs(root.left, paths, path);
            }

            if (root.right != null) {
                dfs(root.right, paths, path);
            }
        }
    }
}
