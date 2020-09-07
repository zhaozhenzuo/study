package algo;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));


//        ["LRUCache","put","put","get","put","get","put","get","get","get"]
//[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
    }

    /**
     * 无元素
     */
    private static final int NO_DATA = -1;

    /**
     * 头指针
     */
    private Node head;

    /**
     * 尾指针
     */
    private Node tail;

    /**
     * 容量
     */
    private int capacity;

    /**
     * 缓存
     */
    private Map<Integer, Node> cacheMap;

    /**
     * 当前元素数量
     */
    private int size;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new RuntimeException("容量必须大于等于0");
        }
        this.capacity = capacity;
        cacheMap = new HashMap<>(capacity);
        head = new Node(NO_DATA, NO_DATA);
        tail = new Node(NO_DATA, NO_DATA);
        head.next = tail;
        tail.next = head;
        size=0;
    }

    public int get(int key) {
        Node r = getInner(key);
        return r == null ? NO_DATA : r.getData();
    }

    public Node getInner(int key) {
        Node curNode = cacheMap.get(key);
        if (curNode == null || NO_DATA == key) {
            //找不到数据
            return null;
        }

        if (curNode.pre == head) {
            //当前元素就是顶部元素，不需要再处理上移操作
            return curNode;
        }

        //维护当前元素前一个结点与当前元素后一个结点关系
        Node preCur = curNode.pre;
        Node nextCur = curNode.next;
        preCur.next = nextCur;
        if (nextCur != null) {
            //当前元素非尾结点
            nextCur.pre = preCur;
        }

        if(nextCur == null){
            //当前元素是尾结点
            tail.next = preCur;
        }

        //将结点放到顶部
        Node headNode = head.next;
        curNode.next = headNode;
        headNode.pre = curNode;
        head.next = curNode;
        curNode.pre = head;

        //返回数据
        return curNode;
    }

    private void removeLast() {
        Node lastNode = tail.next;
        Node preLastNode = lastNode.pre;
        preLastNode.next = null;
        tail.next = preLastNode;
        cacheMap.remove(lastNode.key);
        size--;
    }

    public void put(int key, int value) {
        if (NO_DATA == key) {
            throw new RuntimeException("key值不能为-1");
        }
        Node curNodeExist = getInner(key);
        if (curNodeExist != null) {
            //存在元素则变更值，相应的元素上移到头部，由gerInner方法维护LRU特性
            curNodeExist.setData(value);
            return;
        }

        if (size >= capacity) {
            //超过容量，去除尾数结点指向的元素
            removeLast();
        }

        //放入元素到头部
        Node curNode = new Node(key, value);
        if (size == 0) {
            //没有元素的情况下
            head.next = curNode;
            curNode.pre = head;
            curNode.next = null;
            tail.next = curNode;
        } else {
            //有元素的情况，将元素加入头部
            Node headNext = head.next;
            curNode.next = headNext;
            headNext.pre = curNode;
            curNode.pre = head;
            head.next = curNode;
        }
        cacheMap.put(key, curNode);
        size++;
    }

    class Node {

        /**
         * next指针
         */
        private Node next;

        /**
         * pre指针
         */
        private Node pre;

        /**
         * key
         */
        private Integer key;

        /**
         * 数据
         */
        private Integer data;

        public Node(int key, int data) {
            this.key = key;
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }
    }
}
