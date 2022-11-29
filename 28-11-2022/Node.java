import java.util.*;

/*
This problem was asked by Google.

Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

For example, given the following Node class

class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
The following test should pass:

node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'
 */

public class Node {

    String val;
    Node left;
    Node right;

    public Node(String valParam) {
        this.val = valParam;
        this.left = null;
        this.right = null;
    }

    public Node(String valParam, Node leftParam) {
        this.val = valParam;
        this.left = leftParam;
        this.right = null;
    }

    public Node(Node rightParam, String valParam) {
        this.val = valParam;
        this.left = null;
        this.right = rightParam;
    }

    public Node(String valParam, Node leftParam, Node rightParam) {
        this.val = valParam;
        this.left = leftParam;
        this.right = rightParam;
    }

    public static void main(String[] args) {
        Node node = new Node("root", new Node("left", new Node("left.left")), new Node("right"));
        System.out.println(node.right.val);
        System.out.println(serialize(node));
    }

    public static String serialize(Node root) {
        String result = root.val;
        if (root.left != null || root.right != null) {

        }

        return result;
    }

    private static boolean hasLeft(Node node) {
        boolean isLeft = false;
        if (node.left != null) {
            isLeft = true;
        }
        return isLeft;
    }

    private static boolean hasRight(Node node) {
        boolean isRight = false;
        if (node.right != null) {
            isRight = true;
        }
        return isRight;
    }

    private static String leftContent(Node node) {
        String result = node.left.val;
        if (hasLeft(node.left.left)) {
            result += ", ";
        }
        return result;
    }

    private static String rightContent(Node node) {
        String result = node.right.val;
        if (hasRight(node.right.right)) {
            result += ", ";
        }
        return result;
    }

//    public static Node deserialize(String serializedString) {
//    }
}

/*
root:{left:{left:left.left},right}

"root": {
    "left": {
        "left": "left.left",
    }
    "right": "right"
}
 */
