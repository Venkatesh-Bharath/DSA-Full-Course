# 1. Introduction to Trees
Trees are hierarchical data structures composed of nodes. Each tree has a root node, from which other nodes branch downwards in a parent-child relationship.

# 2. Tree
A tree is a collection of nodes where each node has a value and a list of references to other nodes (children).

# 3. Application
Trees are widely used in computer science for organizing hierarchical data, such as file systems, organization structures, parsing expressions, etc.

# 4. Binary Tree
A binary tree is a type of tree where each node can have at most two children, referred to as the left child and the right child.

# 5. Tree Traversal
Tree traversal refers to the process of visiting (accessing and processing) all nodes in a tree in a specific order.

# 6. Implementation of:
Let's implement various tree traversals and solve related problems.

# 7. Inorder Traversal
Inorder traversal visits nodes in this order: left subtree, root, right subtree.

#### Explanation:
Inorder traversal is a depth-first traversal method that starts from the left subtree, then visits the root, and finally the right subtree.

#### Java Implementation:
```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class BinaryTree {
    void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }
}
```

# 8. Preorder Traversal
Preorder traversal visits nodes in this order: root, left subtree, right subtree.

#### Explanation:
Preorder traversal starts from the root, then visits the left subtree recursively, followed by the right subtree recursively.

#### Java Implementation:
```java
public class BinaryTree {
    void preorderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }
}
```

# 9. Postorder Traversal
Postorder traversal visits nodes in this order: left subtree, right subtree, root.

#### Explanation:
Postorder traversal visits the left subtree recursively, then the right subtree recursively, and finally the root.

#### Java Implementation:
```java
public class BinaryTree {
    void postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.val + " ");
        }
    }
}
```

# 10. Level Order Traversal (Line by Line)
Level order traversal visits nodes level by level from left to right.

#### Explanation:
Level order traversal uses a queue to visit each level of the tree from left to right, starting from the root.

#### Java Implementation:
```java
import java.util.*;

public class BinaryTree {
    void levelOrderTraversal(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            System.out.println(); // Move to the next line after each level
        }
    }
}
```

# 11. Tree Traversal in Spiral Form
Spiral traversal visits nodes level by level alternating direction (left to right, then right to left).

#### Explanation:
Spiral traversal alternates the direction of traversal at each level, starting from left to right for the first level, then right to left for the next level, and so on.

#### Java Implementation:
```java
import java.util.*;

public class BinaryTree {
    void spiralOrderTraversal(TreeNode root) {
        if (root == null)
            return;

        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();
        boolean leftToRight = true;

        stack1.push(root);

        while (!stack1.isEmpty()) {
            int size = stack1.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = stack1.pop();
                System.out.print(node.val + " ");

                if (leftToRight) {
                    if (node.left != null)
                        stack2.push(node.left);
                    if (node.right != null)
                        stack2.push(node.right);
                } else {
                    if (node.right != null)
                        stack2.push(node.right);
                    if (node.left != null)
                        stack2.push(node.left);
                }
            }

            System.out.println(); // Move to the next line after each level
            leftToRight = !leftToRight;
            Deque<TreeNode> temp = stack1;
            stack1 = stack2;
            stack2 = temp;
        }
    }
}
```
# 12. Problems (With Video Solutions):

# 13. Size of Binary Tree
Calculate the number of nodes in a binary tree.

```java
public class BinaryTree {
    int sizeOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + sizeOfBinaryTree(root.left) + sizeOfBinaryTree(root.right);
    }
}
```

# 14. Maximum in Binary Tree
Find the maximum value in a binary tree.

```java
public class BinaryTree {
    int maxInBinaryTree(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;
        return Math.max(root.val, Math.max(maxInBinaryTree(root.left), maxInBinaryTree(root.right)));
    }
}
```
# 15. Height of Binary Tree
Calculate the height (maximum depth) of a binary tree.

```java
public class BinaryTree {
    int heightOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(heightOfBinaryTree(root.left), heightOfBinaryTree(root.right));
    }
}
```

# 16. Print Nodes at K distance
Print nodes that are at a given distance K from the root.

```java
public class BinaryTree {
    void printNodesAtKDistance(TreeNode root, int k) {
        if (root == null)
            return;
        if (k == 0) {
            System.out.print(root.val + " ");
        } else {
            printNodesAtKDistance(root.left, k - 1);
            printNodesAtKDistance(root.right, k - 1);
        }
    }
}
```

# 17. Print Left View of Binary Tree
Print the leftmost nodes at each level of the binary tree.

```java
import java.util.*;

public class BinaryTree {
    void printLeftView(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) // First node in the current level
                    System.out.print(node.val + " ");

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
    }
}
```

# 18. Children Sum Property
Check if each node in the binary tree satisfies the children sum property (the value of each node is equal to the sum of its children).

```java
public class BinaryTree {
    boolean childrenSumProperty(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;

        int sumChildren = 0;
        if (root.left != null)
            sumChildren += root.left.val;
        if (root.right != null)
            sumChildren += root.right.val;

        return root.val == sumChildren && childrenSumProperty(root.left) && childrenSumProperty(root.right);
    }
}
```

# 19. Check for Balanced Binary Tree
Check if the binary tree is balanced (the heights of the two subtrees of every node never differ by more than 1).

```java
public class BinaryTree {
    boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int leftHeight = heightOfBinaryTree(root.left);
        int rightHeight = heightOfBinaryTree(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    int heightOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(heightOfBinaryTree(root.left), heightOfBinaryTree(root.right));
    }
}
```

# 20. Maximum Width of Binary Tree
Sure, let's continue with the explanations and Java implementations for the remaining topics in your module on trees.

# 21. Convert Binary Tree to Doubly Linked List
Convert a binary tree into a doubly linked list (in-place).

#### Explanation:
The conversion involves rearranging the pointers of the binary tree nodes to form a doubly linked list where the `left` pointer acts as the previous pointer and the `right` pointer acts as the next pointer.

#### Java Implementation:
```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class BinaryTree {
    TreeNode prev = null;

    TreeNode convertToDLL(TreeNode root) {
        if (root == null)
            return null;

        TreeNode head = convertToDLL(root.left);

        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        convertToDLL(root.right);

        return head;
    }
}
```

# 20. Maximum Width of Binary Tree
Calculate the maximum width of a binary tree (maximum number of nodes at any level).

#### Explanation:
To find the maximum width of a binary tree, we use level order traversal (BFS) and maintain a queue of nodes along with their corresponding indices. At each level, we calculate the width as the difference between the indices of the leftmost and rightmost nodes.

#### Java Implementation:
```java
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class BinaryTree {
    int maxWidth(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> indices = new LinkedList<>();
        queue.add(root);
        indices.add(1); // root's index is 1

        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int leftmost = indices.peek();
            int rightmost = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int index = indices.poll();
                rightmost = index;

                if (node.left != null) {
                    queue.add(node.left);
                    indices.add(2 * index); // left child index
                }
                if (node.right != null) {
                    queue.add(node.right);
                    indices.add(2 * index + 1); // right child index
                }
            }

            maxWidth = Math.max(maxWidth, rightmost - leftmost + 1);
        }

        return maxWidth;
    }
}
```
# 22. Construct Binary Tree from Inorder and Preorder Traversal
Construct a binary tree from its inorder and preorder traversal sequences.

#### Explanation:
Given the inorder and preorder traversal sequences of a binary tree, we can reconstruct the tree using recursion. The root of the tree can be found using the first element of the preorder traversal, and then recursively build the left and right subtrees.

#### Java Implementation:
```java
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class BinaryTree {
    int preIndex = 0;

    TreeNode buildTree(int[] inorder, int[] preorder) {
        return buildTree(inorder, preorder, 0, inorder.length - 1);
    }

    TreeNode buildTree(int[] inorder, int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;

        TreeNode node = new TreeNode(preorder[preIndex++]);

        if (inStart == inEnd)
            return node;

        int inIndex = search(inorder, inStart, inEnd, node.val);

        node.left = buildTree(inorder, preorder, inStart, inIndex - 1);
        node.right = buildTree(inorder, preorder, inIndex + 1, inEnd);

        return node;
    }

    int search(int[] inorder, int start, int end, int value) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == value)
                return i;
        }
        return -1;
    }
}
```

# 23. The Diameter of a Binary Tree
Find the diameter of a binary tree (longest path between any two nodes in terms of number of edges).

#### Explanation:
The diameter of a binary tree can be found by calculating the maximum of:
1. The diameter of the left subtree.
2. The diameter of the right subtree.
3. The longest path that goes through the root node.

#### Java Implementation:
```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class BinaryTree {
    int diameter(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        return Math.max(leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));
    }

    int height(TreeNode node) {
        if (node == null)
            return 0;

        return 1 + Math.max(height(node.left), height(node.right));
    }
}
```

# 24. LCA (Lowest Common Ancestor) Problem with an Efficient Solution
Find the lowest common ancestor of two nodes in a binary tree.

#### Explanation:
The lowest common ancestor (LCA) of two nodes in a binary tree is the deepest node that is an ancestor to both nodes. We can find the LCA using recursion and checking the existence of nodes in the left and right subtrees.

#### Java Implementation:
```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class BinaryTree {
    TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root == p || root == q)
            return root;

        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        if (left != null && right != null)
            return root;
        else
            return (left != null) ? left : right;
    }
}
```
