package Tree.BinaryTree;

import java.util.Random;

public class BinaryTree2{

    Node root;

    private Node insert(Node node, int data){
        if(node == null){
            node = new Node(data);
            return node;
        }
        else if(data > node.data){
            node.right = insert(node.right, data);
        }
        else if(data < node.data){
            node.left = insert(node.left, data);
        }
        else{
            throw new RuntimeException("Element exists");
        }
        return node;
    }
    void insert(int data){
        if (root == null) root = new Node(data);
        else insert(root, data);
    }

    private void traverse(Node node){
        if(node != null){
            traverse(node.left);
            System.out.println(node.data);
            traverse(node.right);

        }
    }
    void traverse(){
        traverse(root);
    }
    //remove

    void delete(Node node, int data){
        if(root == null){
            throw new RuntimeException("Empty");
        }
        else if(data > node.data){
            delete(node.right, data);
        }
        else if (data < node.data){
            delete(node.left, data);
        }
        else if(data == node.data){
            if(node.right == null && node.left == null){
                node = null;
            }
            else if(node.left == null || node.right == null){

            }
            else {
                // find lowest in right->left...
                // node.data = minValue(node.right);

                //delete(node.right, node.key);
            }
        }

    }

    // height
    private int getHeight(Node node){
        if(node == null) return 0;

        int left = getHeight(node.left);
        int right = getHeight(node.right);

        return Math.max(left, right)+1;
    }

    int getHeight(){
        return getHeight(root);
    }
    static class Node{
        Node left, right;
        int  data;

        Node(int t){
            this.data = t;
        }

    }
}
class Name22{
    public static void main(String[] args) {
        Random random = new Random();
        BinaryTree2 bt = new BinaryTree2();
        for (int i = 0; i < 5; i++){
            bt.insert(10+i);
        }
        bt.traverse();

        System.out.println(bt.getHeight());


    }
}
