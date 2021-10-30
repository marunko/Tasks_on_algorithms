package Tree.AVL;

public class AVLTree {
    public static void main(String[] args) {
        Node root = null;
        TheAVLTree t = new TheAVLTree();
        root = t.insert(root, 11); root = t.insert(root, 9); root =t.insert(root, 7); root =t.insert(root, 8);
        root =t.insert(root,12); root =t.insert(root, 13);
        root =t.insert(root,14); root =t.insert(root, 15);
// Update root every time after rebalancing
        t.traverse(root);

    }
}
class TheAVLTree{


    int height(Node node) {
        if (node == null)
            return 0;

        return node.height;
    }

    // A utility function to get maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // balance factor
    int getBalance(Node node){
        if (node==null)
            return 0;
        return height(node.left) - height(node.right);
    }

    Node rightRotation(Node node){
        Node left = node.left;
        Node leftRight = left.right;

        left.right = node;
        node.left = leftRight;

        // Update heights
        node.height = max(height(node.right), height(node.left))+1;
        left.height = max(height(left.left), height(left.right))+1;

        return left;// new parent root of the tree
    }
    Node leftRotation(Node node){
        Node right = node.right;
        Node rightLeft = right.left;

        right.left = node;
        node.right= rightLeft;

        node.height = max(height(node.right), height(node.left))+1;
        right.height = max(height(right.left), height(right.right))+1;

        return right; // new parent root of the tree
    }

    Node insert(Node node, int data){
        if(node == null){
            return new Node(data);
        }
        if(data<node.key){
            node.left = insert(node.left, data);
        }
        else if(data > node.key){
            node.right = insert(node.right, data);
        }
        else{
            return node;
        }
        //Update height
        node.height = 1 + max(height(node.left), height(node.right));

        int blance = getBalance(node);

        // Left case
        if(blance>1 && data < node.left.key){
            return rightRotation(node);
        }
        //Right case
        if(blance < -1 && data > node.right.key){
            return leftRotation(node);
        }
        // Left Right Case
        if (blance>1&&data > node.left.key){
            node.left = leftRotation(node.left);
            return rightRotation(node);
        }
        //Right Left Case
        if (blance<-1&&data < node.right.key){
            node.right = rightRotation(node.right);
            return leftRotation(node);
        }

        return node;
    }

    public void traverse(Node node){
        if(node != null){
            System.out.println(node.key);
            traverse(node.left);
            traverse(node.right);
        }
    }

}
class Node {
    int key, height;
    Node left, right;

    Node(int d) {
        key = d;
        height = 1;
    }
}