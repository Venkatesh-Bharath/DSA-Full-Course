# 1. Background, Introduction, and Application
Binary Search Tree (BST) is a binary tree data structure where each node has at most two children, referred to as the left child and the right child. In a BST, for every node:
- All elements in the left subtree are less than the node's value.
- All elements in the right subtree are greater than the node's value.

BSTs are commonly used for efficient searching, insertion, and deletion operations.

# 2. Implementation of Search in BST in CPP
In C++, search operation in BST typically involves recursive traversal based on the properties of the BST.

# 3. Implementation of Search in BST in Java
In Java, search in BST can be implemented as follows:

```java
class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

class BST {
    TreeNode root;

    public TreeNode search(TreeNode root, int key) {
        if (root == null || root.val == key) {
            return root;
        }

        if (key < root.val) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }
}
```

# 5. Insertion in BST in CPP
Insertion in BST in C++ involves finding the correct position for the new node and inserting it maintaining the BST properties.

# 6. Insertion in BST in Java
Insertion in BST in Java can be implemented as follows:

```java
class BST {
    TreeNode root;

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private TreeNode insertRec(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        if (key < root.val) {
            root.left = insertRec(root.left, key);
        } else if (key > root.val) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }
}
```

# 8. Deletion in BST in CPP
Deletion in BST in C++ involves cases like deleting a node with no children, one child, or two children, and then adjusting the tree structure accordingly.

# 10. Deletion in BST in Java
Deletion in BST in Java can be implemented as follows:

```java
class BST {
    TreeNode root;

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private TreeNode deleteRec(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.val) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.val) {
            root.right = deleteRec(root.right, key);
        } else {
            // Node to be deleted found

            // Case 1: Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 2: Node with two children
            root.val = minValue(root.right);

            root.right = deleteRec(root.right, root.val);
        }
        return root;
    }

    private int minValue(TreeNode node) {
        int minValue = node.val;
        while (node.left != null) {
            minValue = node.left.val;
            node = node.left;
        }
        return minValue;
    }
}
```

# 13. Floor in BST in Java
Floor in BST refers to the greatest element in the BST which is smaller than or equal to the given key.

```java
class BST {
    TreeNode floor(TreeNode root, int key) {
        TreeNode result = null;
        while (root != null) {
            if (root.val == key) {
                return root;
            } else if (root.val > key) {
                root = root.left;
            } else {
                result = root;
                root = root.right;
            }
        }
        return result;
    }
}
```

# 14. Self Balancing BST
Self-balancing BSTs maintain balance after insertions and deletions to ensure efficient operations.

# 15. AVL Tree
AVL Tree is a self-balancing binary search tree where the difference between heights of left and right subtrees cannot be more than one for all nodes.

# 16. Red Black Tree
Red-Black Tree is another self-balancing binary search tree with additional properties to ensure balance.

# 19. TreeSet in Java
TreeSet in Java is an implementation of SortedSet interface using a self-balancing BST.

# 20. TreeMap in Java
TreeMap in Java is an implementation of Map interface using a self-balancing BST.

# 22. The ceiling of a key in BST
Ceiling in BST refers to the smallest element in the BST which is greater than or equal to the given key.

# 23. Ceiling on the left side in an array
Ceiling on the left side in an array refers to the nearest greater element on the left side for each element in the array.

# 24. Find Kth Smallest in BST
Find the Kth smallest element in a BST.

# 25. Check for BST
Check whether a given binary tree is a BST or not.

# 26. Fix BST with Two Nodes Swapped
Fix a BST where two nodes are swapped.

# 27. Pair Sum with given BST
Find if there exists any pair of nodes in the BST that sum up to a given value.

# 28. Vertical Sum in a Binary Tree
Calculate the vertical sum of nodes in a binary tree.

# 29. Vertical Traversal of Binary Tree
Print nodes of binary tree in vertical order.

# 30. Top View of Binary Tree
Print nodes of binary tree in top-down manner from leftmost node to rightmost node in each vertical line.

# 31. Bottom View of Binary Tree
Print nodes of binary tree in bottom-up manner from leftmost node to rightmost node in each vertical line.
