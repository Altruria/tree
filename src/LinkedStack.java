public  class LinkedStack<T> {
    private SinglyList<T>list;
    public LinkedStack() {
        this.list=new SinglyList<T>();
    }
    public boolean isEmpty() {
        return this.list.isEmpty();

    }
    public void push(T p) {
        this.list.insert(0,p);
    }
    public T peek() {
        return this.list.get(0);
    }
    public T pop() {
        return this.list.remove(0);
    }
}