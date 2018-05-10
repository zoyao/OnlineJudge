package com.lintcode;

import com.lintcode.basic.TreeNode;

import java.util.ArrayDeque;

public class _000070_Serialize_And_Deserialize_Binany_Tree {
    public static void main(String[] args) {
        String data = "{}";
        TreeNode a = deserialize(data);
        String b = serialize(a);
        System.out.println(a);
    }

    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public static String serialize(TreeNode root) {
        // write your code here
        if(root == null)
            return "{}";

        StringBuffer returnStr = new StringBuffer();
        returnStr.append("{");
        returnStr.append(root.val);
        returnStr.append(",");

        ArrayDeque<TreeNode> utmp = new ArrayDeque<>();
        utmp.add(root);
        while(utmp.size() != 0){
            TreeNode tmp = utmp.getFirst();
            String left = "#";
            String right = "#";
            if(tmp.left != null){
                left = String.valueOf(tmp.left.val);
                utmp.add(tmp.left);
            }
            if(tmp.right != null) {
                right = String.valueOf(tmp.right.val);
                utmp.add(tmp.right);
            }

            returnStr.append(left);
            returnStr.append(",");
            returnStr.append(right);
            returnStr.append(",");

            utmp.removeFirst();
        }

        returnStr.deleteCharAt(returnStr.length()-1).append("}");

        while(returnStr.indexOf(",#}") != -1){
            returnStr.delete(returnStr.length()-3,returnStr.length()-1);
        }
        return returnStr.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public static TreeNode deserialize(String data) {
        // write your code here
        String[] tmp = data.substring(1,data.length() - 1).split(",");

        if("".equals(tmp[0]))
            return null;

        TreeNode tmpTreeNode;
        TreeNode firstTreeNode = null;

        ArrayDeque<TreeNode> utmp = new ArrayDeque<>();

        tmpTreeNode = new TreeNode(Integer.valueOf(tmp[0]));
        firstTreeNode = tmpTreeNode;

        int i = 1;
        while(i<tmp.length) {
            if (i > tmp.length-1) {
                break;
            }
            if("#".equals(tmp[i])){
                tmpTreeNode.left = null;
            }else{
                TreeNode treeNode = new TreeNode(Integer.valueOf(tmp[i]));
                tmpTreeNode.left = treeNode;
                utmp.add(treeNode);
            }

            if (i+1 > tmp.length-1) {
                break;
            }
            if("#".equals(tmp[i+1])){
                tmpTreeNode.right = null;
            }else{
                TreeNode treeNode = new TreeNode(Integer.valueOf(tmp[i+1]));
                tmpTreeNode.right = treeNode;
                utmp.add(treeNode);
            }

            tmpTreeNode = utmp.getFirst();
            utmp.removeFirst();
            i = i+2;
        }
        return firstTreeNode;
    }


    /**
     *  {3,9,20,#,#,15,7}
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     *
     * */
}
