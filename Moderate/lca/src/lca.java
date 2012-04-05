
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author richard
 */
public class lca {

    private Tree tree;

    public lca() {
        tree = new Tree();
        tree.addNode(30);
        tree.addNode(8);
        tree.addNode(52);
        tree.addNode(3);
        tree.addNode(20);
        tree.addNode(10);
        tree.addNode(29);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new lca().run(args[0]);
    }

    public void run(final String filename) {
        File file = new File(filename);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split("\\s");
                if (lineArray.length > 0) {
                    int firstNode = Integer.parseInt(lineArray[0]);
                    int secondNode = Integer.parseInt(lineArray[1]);
                    if (firstNode > secondNode) {
                        int temp = secondNode;
                        secondNode = firstNode;
                        firstNode = temp;
                    }
                    System.out.println(tree.findLCA(firstNode, secondNode));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(lca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class Tree {

        public final Node EMPTY_TREE = new Node();
        public final Node NOT_FOUND = new Node();
        private Node root;

        void addNode(int value) {
            if (tree.root == null) {
                tree.root = new Node();
                tree.root.value = value;
                return;
            }

            Node node = tree.root;
            boolean inserted = false;
            while (!inserted) {
                if (value < node.value) {
                    if (node.left != null) {
                        node = node.left;
                    } else {
                        node.left = new Node();
                        node.left.parent = node;
                        node.left.value = value;
                        inserted = true;
                    }
                } else {
                    if (node.right != null) {
                        node = node.right;
                    } else {
                        node.right = new Node();
                        node.right.parent = node;
                        node.right.value = value;
                        inserted = true;
                    }
                }
            }
        }

        int findLCA(final int firstValue, final int secondValue) {
            Node lca;
            for (lca = findNode(firstValue); !contains(lca, secondValue) && lca != root; lca = lca.parent) { }
            return lca.value;
        }

        Node findNode(Node startNode, int value) {
            if (startNode == null) {
                return EMPTY_TREE;
            }
            Node node = startNode;
            while (node.value != value) {
                if (value < node.value) {
                    if (node.left != null) {
                        node = node.left;
                    } else {
                        return NOT_FOUND;
                    }
                } else {
                    if (node.right != null) {
                        node = node.right;
                    } else {
                        return NOT_FOUND;
                    }
                }
            }
            return node;
        }

        Node findNode(int value) {
            return findNode(tree.root, value);
        }
        
        boolean contains(Node startNode, int value) {
            if (startNode == null) {
                return false;
            }
            Node node = startNode;
            while (node.value != value) {
                if (value < node.value) {
                    if (node.left != null) {
                        node = node.left;
                    } else {
                        return false;
                    }
                } else {
                    if (node.right != null) {
                        node = node.right;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }

        boolean contains(int value) {
            return contains(tree.root, value);
        }
    }

    private class Node {

        private int value;
        private Node left;
        private Node right;
        private Node parent;

        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }
}
