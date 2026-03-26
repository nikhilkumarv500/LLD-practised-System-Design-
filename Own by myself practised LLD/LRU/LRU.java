class Node {
    public int key,val;
    public Node prev,next;

    public Node(int _key, int _val) {
        key=_key;
        val=_val;
        prev=null;
        next=null;
    }
}

class DllList {
    public Node head;
    public Node tail;
    public int size;

    public DllList(){
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        size=0;
        head.next=tail;
        tail.prev=head;
    }

    public void addAtStart(Node cur) {
        Node oldFirst = head.next;
        head.next=cur;
        cur.prev=head;
        cur.next=oldFirst;
        oldFirst.prev=cur;
        size++;
    }

    public void removeFromLast(Node cur) {
        Node prevNode=cur.prev;
        Node nextNode = cur.next;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
        size--;
    }
}

class LRUCache {
    DllList dlist;
    Map<Integer, Node> keyNodeMap = new HashMap<>(); 
    int maxSize;

    public LRUCache(int capacity) {
        dlist = new DllList();
        maxSize=capacity;
    }
    
    public int get(int key) {
        if(keyNodeMap.containsKey(key)==false) return -1;

        Node curPosNode = keyNodeMap.get(key);
        dlist.removeFromLast(curPosNode);
        dlist.addAtStart(curPosNode);

        return curPosNode.val;

    }
    
    public void put(int key, int value) {
        if(keyNodeMap.containsKey(key)==true) {
            Node curPosNode = keyNodeMap.get(key);
            dlist.removeFromLast(curPosNode);
            curPosNode.val=value;
            dlist.addAtStart(curPosNode);
            return;
        }

        Node newNode = new Node(key, value);

        if(dlist.size == maxSize) {
            Node lastNode = dlist.tail.prev;
            keyNodeMap.remove(lastNode.key);
            dlist.removeFromLast(lastNode);
        }

        dlist.addAtStart(newNode);
        keyNodeMap.put(key,newNode);

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */