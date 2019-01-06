public class Node<T> {
    public T data;
    public Node<T>next;
    public Node(T p,Node<T>next) {
        this.data=(T) p;
        this.next=next;
    }
    public Node() {
        this(null,null);
    }
    public  java.lang.String toString() {
        return this.data.toString();
    }
}