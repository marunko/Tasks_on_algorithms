  class AVLTree
    {
        public Node root;
        
        public int maxDepth(Node node)
        {
            if (node == null)
                return 0;
            else
            {
                /* compute the depth of each subtree */
                int lDepth = maxDepth(node.left);
                Console.WriteLine("left" + lDepth);
                int rDepth = maxDepth(node.right);
                Console.WriteLine("Right" + rDepth);

                /* use the larger one */
                if (lDepth > rDepth)
                {
                    Console.WriteLine("l"+lDepth);
                    return (lDepth + 1);
                }
                else
                {
                    Console.WriteLine("r"+rDepth);
                    return (rDepth + 1);
                }
            }
        }
        public Node rotateRight(Node a)
        {
            Node b = a.left;
            Node bR = a.right;
            Node c = b.left;
            Node d = b.right;

            b.left = bR;
            b.right = a;
            a.left = c;
            a.right = d;


            return b;
        }
        public Node rotateLeft(Node a)
        {
            Node b = a.right;
            Node aL = a.left;
            Node c = b.left;
            Node d = b.right;

            b.left = a;
            b.right = aL;
            a.left = c;
            a.right = d;

            return b;
        }
        // visit left then right legs recursivly
        public void print(Node n)
        {
            if(n != null)
            {
                print(n.left);
                Console.WriteLine(n.data);
                print(n.right);
            }
        }
        public int height(Node node)
        {
            /* base case tree is empty */
            if (node == null)
                return 0;

            /* If tree iss not empty then height = 1 + max of left
             height and right heights */
            return 1 + Math.Max(height(node.left), height(node.right));
        }
        public Node rebalance(Node a)
        {

            if(height(a.left) > (height(a.right)+2))
            {
                a = rotateRight(a);
               // a = rebalance(a);
            }
            else if(height(a.right) > (height(a.left)+2))
            {
                a = rotateLeft(a);
                //a = rebalance(a);
            }

            return a;
        }
    }
