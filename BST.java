public class BST<E extends Comparable<E>> {
    protected TreeNode<E> root;
    protected int size = 0;
    public BST() {

    }
    public boolean search(E e) {
        TreeNode<E> current = root;
        while(current != null) {
            if(e.compareTo(current.element) < 0) {
                current = current.left; // Start from the root

            }
            else if (e.compareTo(current.element) > 0) {
                current =current.right; // Go right

            }
            else { //Element matches current.element
                print(current);
                return true; //Element is found
            }

        }


        System.out.printf("Keyword %s does not exist in the information database!", e);
        return false; //Element is not in the tree
    }
    public boolean insert(E e, Article a) { 
        //happens only first due to one database
        if (root == null) {
            //if root is null it creates a new node
            root = createNewNode(e);
            //added the addfirst in the tree class
            //first node inserted
            root.addFirst(a);
        }
        else {
            //creates the node for parent and current
            TreeNode<E> parent = null; 
            TreeNode<E> current = root; 

            //if parent is not null, we go to the left or the right
            while (current != null) {
                if (e.compareTo(current.element) < 0) { 
                    parent = current;
                    current = current.left;
                }
                else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
    
                }
                else {
                    //return false. Duplicate node not inserted
                    current.addFirst(a);
                    return false;
                }
            }
            //Create the new node and attach it to the parent node
            if (e.compareTo(parent.element) < 0) {
                parent.left = createNewNode(e);
                parent.left.addFirst(a);
            }
            else {
                parent.right = createNewNode(e);
                parent.right.addFirst(a);
            }
        }
        size++;
        return true; //Element created
    }
    protected TreeNode<E> createNewNode(E e) {

        return new TreeNode<>(e);
    }

    public void inorder() {
        inorder(root);
    }
    
    //Inorder traversal from subtree
    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.element + " ");
        Node<Article> artRec = root.head;
        System.out.println("\t");
        while (artRec != null) {
            System.out.printf("%s", artRec);
            artRec = artRec.next;
        }
        System.out.println();
        inorder(root.right);
    }

    //print the key and prints all the articles
    protected void print(TreeNode<E> t) {
        if(t == null) return;
        System.out.print(t.element + " ");
        Node<Article> artRec = root.head;
        System.out.println("\t");
        while(artRec != null) {
            System.out.printf("%s", artRec);
            artRec = artRec.next;

        }
        System.out.println();
    }
    

    

}

