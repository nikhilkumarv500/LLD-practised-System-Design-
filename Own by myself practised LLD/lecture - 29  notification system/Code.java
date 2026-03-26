import java.util.*;

interface Iterator<T> {
    boolean hasNext();
    T next();
}

interface IterableDs<T> {
    Iterator<T> getIterator();
}

//Iterator and iterable for list

class ListIterableDs implements IterableDs<Integer> {

    public List<Integer> list = new ArrayList<>();

    public void addElement(int num) {
        list.add(num);
    }

    @Override
    public Iterator<Integer> getIterator() {
        return new ListIterator(this);
    }
}

class ListIterator implements Iterator<Integer> {
    IterableDs<Integer> obj;
    int index=0;

    public ListIterator(IterableDs<Integer> obj) {
        this.obj=obj;
    }

    @Override
    public boolean hasNext() {
        if(index<(((ListIterableDs)obj).list.size())) return true;
        return false;
    }

    @Override
    public Integer next() {
        return ((ListIterableDs)obj).list.get(index++);
    }
}

//Iterator and iterable for Linked list

class LinkedListIterableDs implements IterableDs<LinkedListIterableDs> {
    int data;
    LinkedListIterableDs next;

    public LinkedListIterableDs(int data) {
        this.data = data;
        this.next = null;
    }

    public Iterator<LinkedListIterableDs> getIterator() {
        return new LinkedListIterator(this);
    };
}

class LinkedListIterator implements Iterator<LinkedListIterableDs> {

    LinkedListIterableDs node;

    LinkedListIterator (LinkedListIterableDs node) {
        this.node=node;
    }

    @Override
    public boolean hasNext() {
        return node!=null; 
    }

    @Override
    public LinkedListIterableDs next() {
        LinkedListIterableDs prev = node;
        node=node.next;
        return prev;
    }
}

//Iterator and iterable for Binary tree inorder

class BinaryTreeIterableDs implements IterableDs<Integer> {
    int data;
    BinaryTreeIterableDs left;
    BinaryTreeIterableDs right;

    BinaryTreeIterableDs(int data) {
        this.data=data;
        left=null;
        right=null;
    }

    @Override
    public Iterator<Integer> getIterator() {
        return new BinaryTreeInorderIterator(this);
    }
}

class BinaryTreeInorderIterator implements Iterator<Integer> {
    BinaryTreeIterableDs node;
    Stack<BinaryTreeIterableDs> supportStack;

    BinaryTreeInorderIterator(BinaryTreeIterableDs node) {
        this.node=node;
        supportStack = new Stack<>();
        pushPresentAndAllLeftNode(node);
    }

    void pushPresentAndAllLeftNode(BinaryTreeIterableDs node) {
        while(node!=null) {
            supportStack.add(node);
            node=node.left;
        }
    }

    @Override
    public Integer next() {
        BinaryTreeIterableDs top = supportStack.peek();
        supportStack.pop();
        int ans = top.data;

        if(top.right!=null) {
            top=top.right;
            pushPresentAndAllLeftNode(top);
        }

        return ans;
    }

    @Override
    public boolean hasNext() {
        return supportStack.size()>0;
    }

    public void iterativeInorderTraversalUsingStack() {
        Stack<BinaryTreeIterableDs> st = new Stack<>();

        BinaryTreeIterableDs cur=node;
        st.add(cur);
        while(cur.left!=null) {
            st.add(cur.left);
            cur=cur.left;
        }



        while(st.size()>0) {
            BinaryTreeIterableDs top = st.peek();
            st.pop();
            System.out.print(top.data + " ");
            if(top.right!=null) {
                st.add(top.right);
                top=top.right;
                while(top.left!=null) {
                    st.add(top.left);
                    top=top.left;
                }
            }
        }
    }

    void dfs(BinaryTreeIterableDs node) {
        if(node==null) return;
        dfs(node.left);
        System.out.print(node.data + " ");
        dfs(node.right);
    }

    public void recursiveInorder() {
        dfs(node);
    }

    
}

class Client {
    void run() {

        //List iterator--------------------
        {
            ListIterableDs list = new ListIterableDs();
            list.addElement(10);
            list.addElement(2);
            list.addElement(30);
            list.addElement(4);
            list.addElement(50);

            Iterator<Integer> listIt = list.getIterator();
            System.out.println("List:");
            while(listIt.hasNext()) {
                System.out.print(listIt.next() + " ");
            }
            System.out.println("\n");
        }

        //LinkedList iterator--------------
        {
            LinkedListIterableDs linkedList = new LinkedListIterableDs(10);
            linkedList.next = new LinkedListIterableDs(2);
            linkedList.next.next = new LinkedListIterableDs(30);
            linkedList.next.next.next = new LinkedListIterableDs(4);
            linkedList.next.next.next.next = new LinkedListIterableDs(50);

            Iterator<LinkedListIterableDs> linkedListIt = linkedList.getIterator();
            System.out.println("Linked list:");
            while(linkedListIt.hasNext()) {
                System.out.print(linkedListIt.next().data + " ");
            }
            System.out.println("\n");
        }

        //BinaryTree iterator
        BinaryTreeIterableDs binaryTreeRoot = new BinaryTreeIterableDs(1);
        binaryTreeRoot.left = new BinaryTreeIterableDs(2);
        binaryTreeRoot.right = new BinaryTreeIterableDs(3);
        binaryTreeRoot.left.left = new BinaryTreeIterableDs(4);
        binaryTreeRoot.left.right = new BinaryTreeIterableDs(5);
        binaryTreeRoot.right.left = new BinaryTreeIterableDs(6);
        binaryTreeRoot.right.left.right = new BinaryTreeIterableDs(7);
        binaryTreeRoot.right.left.right.right = new BinaryTreeIterableDs(8);

        Iterator<Integer> binaryTreeInorderIterator = binaryTreeRoot.getIterator();

        System.out.println("stack iterative inorder");
        ((BinaryTreeInorderIterator)binaryTreeInorderIterator).iterativeInorderTraversalUsingStack();
        System.out.println();
        System.out.println("recursive inorder");
        ((BinaryTreeInorderIterator)binaryTreeInorderIterator).recursiveInorder();
        System.out.println();
        
        System.out.println("Binary Tree using iterator:");
        while(((BinaryTreeInorderIterator)binaryTreeInorderIterator).hasNext()) {
            System.out.print(((BinaryTreeInorderIterator)binaryTreeInorderIterator).next() + " ");
        }
        System.out.println();



    }
}



public class Code {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Client obj = new Client();
        obj.run();
        
        sc.close();
    }
}