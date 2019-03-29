package offer;

public class Problem37 {

    private String deserializeStr;

    String Serialize(TreeNode root) {
        if (root == null){
            return "#";
        }

        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }

    TreeNode Deserialize(String str) {
        deserializeStr = str;
        return Deserialize();
    }

    private TreeNode Deserialize(){
        // 如果长度为0，则直接返回null
        if (deserializeStr.length() == 0){
            return null;
        }

        // 获取第一个所在节点的位置
        int index = deserializeStr.indexOf(" ");
        // 获取节点信息
        String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
        // 重新复制定义序列字符串
        deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);

        if (node.equals("#")){
            // 如果发现节点的值为$,说明是空节点
            return null;
        }

        int val = Integer.valueOf(node);
        // 创建新的节点
        TreeNode root = new TreeNode();
        root.val = val;
        root.left = Deserialize();
        root.right = Deserialize();

        return root;
    }
}
