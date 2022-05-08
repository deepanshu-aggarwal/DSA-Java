package Trie.Concept;

class Node{
    Node[] links = new Node[26];
    boolean flag = false;

    boolean containsKey(char ch){
        return (links[ch-'a'] != null);
    }

    void put(char ch, Node node){
        links[ch-'a'] = node;
    }

    Node get(char ch){
        return links[ch-'a'];
    }

    void setEnd(){
        flag = true;
    }
}

class Trie{
    private static Node root;

    Trie(){
        root = new Node();
    }

    void insert(String word){
        Node node  = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    boolean search(String word){
        Node node = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch))
                return false;
            node = node.get(ch);
        }
        return node.flag;
    }

    boolean startsWith(String word){
        Node node = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch))
                return false;
            node = node.get(ch);
        }
        return true;
    }
}

public class Implement {
    public static void main(String[] args) {
        int type[] = {1, 1, 2, 3, 2};
        String value[] = {"hello", "help", "help", "hel", "hel"};
        Trie trie = new Trie();
        for(int i=0; i<type.length; i++){
            if(type[i] == 1){
                trie.insert(value[i]);
            }
            else if(type[i] == 2){
                System.out.println(trie.search(value[i]));
            }
            else{
                System.out.println(trie.startsWith(value[i]));
            }
        }
    }
}
