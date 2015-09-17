package LeetCode;

public class Q208_Implement_Trie_Prefix_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	//public class  {
	    private TrieNode root;

	    public Q208_Implement_Trie_Prefix_Tree() {
	        root = new TrieNode();
	    }

	    // Inserts a word into the trie.
	    public void insert(String word) {
	        TrieNode cur = root;
	        for(char letter : word.toCharArray()) {
	            if(cur.getChild(letter) == null) {
	                cur.setChid(cur, letter);
	            }
	            cur = cur.getChild(letter);
	        }
	        cur.item = word;
	    }
	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	        TrieNode cur = root;
	        for(char letter : word.toCharArray()) {
	            if(cur.getChild(letter) == null)
	                return false;
	            else 
	                cur = cur.getChild(letter);
	        }
	        return word.equals(cur.item);
	    }

	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	        TrieNode cur = root;
	        for(char letter : prefix.toCharArray()) {
	            if(cur.getChild(letter) == null)
	                return false;
	            else 
	                cur = cur.getChild(letter);
	        }
	        return true;
	    }
}
    // Inserts a word into the trie.
 
class TrieNode {
    //http://pisxw.com/algorithm/Implement-Trie-(Prefix%20Tree).html 
    // Initialize your data structure here.
    public final TrieNode[] children;
    public String item;
    public TrieNode() {
        children = new TrieNode[26];
        item = "";
    }
    
    public TrieNode getChild(char letter) {
        int index = letter - 'a';
        return children[index];
    }
    
    public void setChid(TrieNode node, char letter) {
        int index = letter - 'a';
        children[index] = node;
    }
}

