package Tries;

class Node {
    Node[] link = new Node[26];
    boolean flag = false;

    public Node() {}

    boolean containsKey(char ch) {
        return link[ch - 'a'] != null;
    }

    void put(char ch, Node node){
        link[ch - 'a'] = node;
    }

    Node get(char ch) {
        return link[ch - 'a'];
    }

    public void setEnd() {
        flag = true;
    }

    public boolean isEnd() {
        return flag;
    }
}

public class Trie {
    public static Node root;

    Trie() {
        root = new Node();
    }

    public static void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if(! node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public static boolean search(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++) {
            if(! node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        if (node.isEnd()) {
            return true;
        }
        return false;
    }

    public static boolean startsWith(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++) {
            if(! node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("Shantanu");
        obj.insert("Sakshi");
        System.out.println(obj.search("Sakshi"));
        System.out.println(obj.startsWith("Shant"));
    }
}


