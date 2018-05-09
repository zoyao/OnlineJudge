package com.lintcode;

import com.lintcode.basic.TreeNode;

import java.util.ArrayDeque;

import static com.lintcode._00070_Serialize_And_Deserialize_Binany_Tree.deserialize;

public class _06320_Binary_Tree_Maximum_Node {
    public static void main(String[] args){
        TreeNode a = deserialize("{1,-5,3,1,2,-4,-5}");
        maxNode(a);
    }

    /*
     * @param root: the root of tree
     * @return: the max node
     */
    public static TreeNode maxNode(TreeNode root) {
        // write your code here
        ArrayDeque<TreeNode> utmp = new ArrayDeque<>();
        TreeNode maxNode = root;
        while(root != null){
            if(root.left != null){
                utmp.add(root.left);
                if(root.left.val > maxNode.val){
                    maxNode = root.left;
                }
            }
            if(root.right != null){
                utmp.add(root.right);
                if((root.right.val > maxNode.val && root.left == null) ||
                        (root.right.val > maxNode.val && root.right.val > root.left.val)){
                    maxNode = root.right;
                }
            }

            if(utmp.size() != 0){
                root = utmp.getFirst();
                utmp.removeFirst();
            }else{
                root = null;
            }
        }
        return maxNode;
    }
}
