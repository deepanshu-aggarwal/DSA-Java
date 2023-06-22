package Trie;

//class Node{
//    Node[] links = new Node[26];
//    boolean
//}
//
//class Trie{
//    private static Node root;
//}

import Trie.Implement;

public class LongestStringWithAllPrefix {
    public static void main(String[] args) {
        Trie trie = new Trie();
        Node root = trie.getRoot();
        String[] values = {"n", "ninja", "ninj", "ni", "nin", "ninga"};
        for (String value : values) {
            trie.insert(value);
        }

//        System.out.println(trie.search("ning"));

        String ans = "";
        int len = 0;
        for(int i=0; i<values.length; i++){
            Node node = root;
            String word = values[i];
            boolean isWord = true;
            for(int j=0; j<word.length(); i++){
                char ch = word.charAt(j);
                node = node.get(ch);
                if(!node.flag){
                    isWord = false;
                    break;
                }
            }
            if(isWord && word.length() > len){
                ans = word;
                len = word.length();
            }
        }

        System.out.println(ans);
    }
}
