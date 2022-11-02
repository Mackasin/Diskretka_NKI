package com.nki.dzhurynskyi.homework.pr3;


    class Node {
        int key;
        Node left, right;

        public Node(int item)
        {
            key = item;
        }
    }

    class BinaryTree {
        // Root of Binary Tree
        Node root=null;


        /* Given a binary tree, print its nodes in inorder*/
        void printInorder(Node node) {
            if (node == null)
                return;

            /* first recur on left child */
            printInorder(node.left);

            /* then print the data of node */
            System.out.print(node.key + " ");

            /* now recur on right child */
            printInorder(node.right);
        }

        // Wrappers over above recursive functions
        void printInorder() {
            printInorder(root);
        }

        // Driver code
        public static void main(String[] args) {
            BinaryTree tree = new BinaryTree();
            tree.root = new Node(1);
            tree.root.left = new Node(3);
            tree.root.right = new Node(7);
            tree.root.left.left = new Node(4);
            tree.root.left.right = new Node(8);
            tree.root.left.right.left = new Node(5);
            tree.root.right.left=new Node(6);
            tree.root.right.right=new Node(2);

            // Function call
            System.out.println(
                    "\nInorder traversal of binary tree is ");
            tree.printInorder();
        }
    }



