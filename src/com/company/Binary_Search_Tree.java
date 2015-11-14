package com.company;

import java.util.Comparator;

/**
 * Created by zhangsirui on 15/10/17.
 */
public class Binary_Search_Tree {
    //定义一个二叉树结点类
    class BinaryNode {
        int key;
        BinaryNode left;
        BinaryNode right;
        BinaryNode parent;

        BinaryNode(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        BinaryNode(int key, BinaryNode left, BinaryNode right, BinaryNode parent) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }

    BinaryNode root;  //根节点

    public Binary_Search_Tree()
    {
        root=null;
    }
    //将树置为空
    public void makeEmpty()
    {
        root=null;
    }
    //判断树是否为空
    public boolean isEmpty()
    {
        return root==null;
    }
    //查找结点
    public boolean contains(int k,BinaryNode t)
    {
        if (t==null)
            return false;
        if (k<t.key)
            return contains(k,t.left);
        else if (k>t.key)
            return contains(k,t.right);
        else
            return true;
    }
    //查找最小值
    public BinaryNode Tree_Minimum(BinaryNode t)
    {
        if (t==null)
            return null;
        else if (t.left==null)
            return t;
        else
            return Tree_Minimum(t.left);
    }
    //查找最大值
    public BinaryNode Tree_Maximum(BinaryNode t)
    {
        if (t==null)
            return null;
        else if(t.right==null)
            return t;
        else
            return Tree_Maximum(t.right);
    }
    //插入结点
//    public BinaryNode Tree_Insert(BinaryNode t,BinaryNode z)
//    {
//        //插入操作的非递归形式
//        BinaryNode y=null;
//        BinaryNode x=root;
//    }





}
