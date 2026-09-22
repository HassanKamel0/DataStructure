package org.leetcode.learning.Tree;

import java.util.*;

public class BinarySearchTree {

    public Node root;

    public class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        } else {
            Node temp = root;
            while (true) {
                if (temp.value == value) return false;
                if (temp.value > value) {
                    if (temp.left == null) {
                        temp.left = newNode;
                        return true;
                    } else {
                        temp = temp.left;
                    }
                } else {
                    if (temp.right == null) {
                        temp.right = newNode;
                        return true;
                    } else {
                        temp = temp.right;
                    }
                }
            }
        }
    }

    public boolean contains(int value) {
        if (root == null) return false;
        Node temp = root;
        while (temp != null) {
            if (temp.value == value) return true;
            if (temp.value > value) temp = temp.left;
            else temp = temp.right;
        }
        return false;
    }

    private boolean rContains(Node current, int value) {
        if (current == null) return false;
        if (current.value == value) return true;
        if (value < current.value)
            return rContains(current.left, value);
        else return rContains(current.right, value);
    }

    public boolean rContains(int value) {
        return rContains(root, value);
    }

    public void rInsert(int value) {
        if (root == null) root = new Node(value);
        rInsert(root, value);
    }

    private Node rInsert(Node current, int value) {
        if (current == null) return new Node(value);
        if (value < current.value) current.left = rInsert(current.left, value);
        else if (value > current.value) current.right = rInsert(current.right, value);
        return current;
    }

    public void deleteNode(int value) {
        deleteNode(root, value);
    }

    private Node deleteNode(Node currentNode, int value) {
        if (currentNode == null) return null;
        if (value < currentNode.value) currentNode.left = deleteNode(currentNode.left, value);
        else if (value > currentNode.value) currentNode.right = deleteNode(currentNode.right, value);
        else {
            if (currentNode.left == null && currentNode.right == null) return null;
            else if (currentNode.left == null) currentNode = currentNode.right;
            else if (currentNode.right == null) currentNode = currentNode.left;
            else {
                int subTreeMinValue = minValue(currentNode.right);
                currentNode.value = subTreeMinValue;
                currentNode.right = deleteNode(currentNode.right, subTreeMinValue);
            }
        }
        return currentNode;
    }

    public int minValue(Node current) {
        while (current.left != null)
            current = current.left;
        return current.value;
    }

    public List<Integer> inorderTraversal() {
        List<Integer> result = new ArrayList<>();
        inorderHelper(this.root, result);
        return result;
    }

    private void inorderHelper(Node node, List<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result);
        result.add(node.value);
        inorderHelper(node.right, result);
    }

    public boolean isBalanced() {
        return height(this.root) != -1;
    }

    private int height(Node node) {
        if (node == null) return 0;
        int leftHeight = height(node.left);
        if (leftHeight == -1) return -1;
        int rightHeight = height(node.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public void sortedArrayToBST(int[] nums) {
        this.root = sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private Node sortedArrayToBST(int[] nums, int left, int right) {

        if (nums.length == 0 || right < left) return null;
        if (nums.length == 1 || left == right) return new Node(nums[right]);


        Node midNode;
        int mid = left + (right - left) / 2;
        midNode = new Node(nums[mid]);
        midNode.left = sortedArrayToBST(nums, left, mid - 1);
        midNode.right = sortedArrayToBST(nums, mid + 1, right);

        return midNode;
    }

    public ArrayList<Integer> BFS() {
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        if (currentNode != null) {
            queue.add(currentNode);
        }

        while (queue.size() > 0) {
            currentNode = queue.remove();
            if (currentNode != null) {
                results.add(currentNode.value);
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            }
        }
        return results;
    }

    public ArrayList<Integer> DFSPreOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                results.add(currentNode.value);
                if (currentNode.left != null) new Traverse(currentNode.left);
                if (currentNode.right != null) new Traverse(currentNode.right);
            }
        }
        new Traverse(root);
        return results;
    }

    public ArrayList<Integer> DFSPostOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) new Traverse(currentNode.left);
                if (currentNode.right != null) new Traverse(currentNode.right);
                results.add(currentNode.value);
            }
        }
        new Traverse(root);
        return results;
    }

    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) new Traverse(currentNode.left);
                results.add(currentNode.value);
                if (currentNode.right != null) new Traverse(currentNode.right);
            }
        }
        new Traverse(root);
        return results;
    }

    public void invert() {
        root = invertTree(root);
    }

    private Node invertTree(Node root) {
        if (root == null) return root;
        if (root.left == null && root.right == null) return root;
        if (root.left != null) invertTree(root.left);
        if (root.right != null) invertTree(root.right);
        Node temp = root.right;
        root.right = root.left;
        root.left = temp;
        return root;
    }

    public boolean isValidBST() {
        ArrayList<Integer> dfsInOrderList = DFSInOrder();
        if (dfsInOrderList.isEmpty()) return false;
        for (int i = 1; i < dfsInOrderList.size(); i++)
            if (dfsInOrderList.get(i) < dfsInOrderList.get(i - 1)) return false;

        return true;
    }

    public Integer kthSmallest(int k) {
        if (root == null || k<0 ) return null;

        Node currentNode = root;
        Stack<Node> stack = new Stack<>();


        while (!stack.isEmpty() || currentNode != null) {

            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            if (--k == 0) return currentNode.value;
            currentNode = currentNode.right;
        }
        return currentNode!=null?currentNode.value:null;
    }
}