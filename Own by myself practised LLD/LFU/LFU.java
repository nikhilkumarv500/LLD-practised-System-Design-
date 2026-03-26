class Node {
    int key,val,cnt;
    Node prev, next;

    Node(int _key, int _val) {
        key=_key;
        val=_val;
        cnt=-1;
    }
}

class DllList {
    Node head,tail;
    int size;

    DllList() {
        size=0;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next=tail;
        tail.next=head;
    }

    void addAtFront(Node cur) {
        Node oldFirst = head.next;
        head.next=cur;
        cur.prev=head;
        cur.next=oldFirst;
        oldFirst.prev=cur;
        size++;
    }

    void removeFromBack(Node cur) {
        Node prevNode = cur.prev;
        Node nextNode = cur.next;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
        size--;
    }
}

class LFUCache {

    Map<Integer, Node> keyNode;
    Map<Integer, DllList> freqList;
    int curSize;
    int maxSize;
    int minFreq;

    public LFUCache(int capacity) {
        keyNode = new HashMap<>();
        freqList = new HashMap<>();
        curSize=0;
        maxSize=capacity;
        minFreq=0;
    }

    void lastToFirstANDupdateFreq(Node cur) {
        DllList currentLevelList = freqList.get(cur.cnt);

        currentLevelList.removeFromBack(cur);
        curSize--;

        if(cur.cnt==minFreq && currentLevelList.size==0) {
            freqList.remove(minFreq);
            minFreq++;
        }

        DllList nextLevelList = new DllList();
        cur.cnt = cur.cnt+1;

        if(freqList.containsKey(cur.cnt)==true) {
            nextLevelList = freqList.get(cur.cnt);
        }
        nextLevelList.addAtFront(cur);
        curSize++;

        freqList.put(cur.cnt, nextLevelList);
        if(keyNode.containsKey(cur.key)==false) {
            keyNode.put(cur.key,cur);
        }

    }
    
    public int get(int key) {
        if(keyNode.containsKey(key)==false) return -1;

        Node curNode = keyNode.get(key);
        lastToFirstANDupdateFreq(curNode);
        return curNode.val;

    }
    
    public void put(int key, int value) {
        
        if(keyNode.containsKey(key)==true) {
            Node curNode = keyNode.get(key);
            curNode.val=value;
            lastToFirstANDupdateFreq(curNode);
            return;
        }

        if(curSize==maxSize) {
            DllList curMinFreqList = freqList.get(minFreq);
            Node lastNode = curMinFreqList.tail.prev;

            keyNode.remove(lastNode.key);
            curMinFreqList.removeFromBack(lastNode);
            curSize--;

            if(lastNode.cnt==minFreq && curMinFreqList.size==0) {
                freqList.remove(minFreq);
                minFreq++;
            }
        }

        minFreq=1;
        Node newNode = new Node(key, value);
        newNode.cnt=1;

        DllList newMinFreqList = new DllList();
        if(freqList.containsKey(minFreq)==true) {
            newMinFreqList=freqList.get(minFreq);
        }
        
        newMinFreqList.addAtFront(newNode);
        freqList.put(minFreq, newMinFreqList);
        keyNode.put(key, newNode);
        curSize++;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */