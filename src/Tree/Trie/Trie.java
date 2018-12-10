package Tree.Trie;

import java.util.TreeMap;

public class Trie {
    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        this.size = 0;
    }

    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) != null){
                cur = cur.next.get(c);
            }else {
                return false;
            }
        }
        return cur.isWord;
    }

    public boolean isPrefix(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    public int getSize() {
        return size;
    }

    private boolean

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("add");
        trie.add("pandas");
        trie.add("anacoda");
        trie.add("acooperate");
        System.out.println(trie.contains("pan"));
        System.out.println(trie.contains("anacoda"));
    }
}
