package Trie.Concept;

class Node{
    Node[] links = new Node[26];
    boolean flag = false;
    int cw = 0;
    int ew = 0;

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

    void incrCW(){
        cw++;
    }

    void incrEW(){
        ew++;
    }

    void decrCW() { cw--; }

    void decrEW() { ew--; }
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
            node.incrCW();
        }
        node.incrEW();
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

    int countStartsWith(String word){
        Node node = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch))   return 0;
            node = node.get(ch);
        }
        return node.cw;
    }

    int countWordsEqualTo(String word){
        Node node = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(node.containsKey(ch)){
                node = node.get(ch);
            }
            else    return 0;
        }
        return node.ew;
    }

    void erase(String word){
        Node node = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch))   return;
            node = node.get(ch);
            node.decrCW();
        }
        node.decrEW();
    }
}

public class Implement {
    public static void main(String[] args) {
        int type[] = {1,1,1,6,1,5};
        String value[] = {"hello", "help", "help", "help", "hel", "hel"};
        Trie trie = new Trie();
        for(int i=0; i<type.length; i++){
            if(type[i] == 1){
                trie.insert(value[i]);
            }
            else if(type[i] == 2){
                System.out.println(trie.search(value[i]));
            }
            else if(type[i] == 3){
                System.out.println(trie.startsWith(value[i]));
            }
            else if(type[i] == 4){
                System.out.println(trie.countWordsEqualTo(value[i]));
            }
            else if(type[i] == 5){
                System.out.println(trie.countStartsWith(value[i]));
            }
            else{
                trie.erase(value[i]);
            }
        }
    }
}
