class TreeNode<E> {
    protected E element; 
    protected TreeNode<E> left; 
    protected TreeNode<E> right;
    protected Node<Article> head;


    public TreeNode(E e) { 
        element = e;

    }
    public void addFirst(Article a) {
        Node<Article> newNode = new Node<>(a);
        newNode.next = head;
        head = newNode;

    }
}
