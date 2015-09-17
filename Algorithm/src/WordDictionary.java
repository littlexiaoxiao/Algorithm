
public class WordDictionary {
     TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        for(char letter : word.toCharArray()) {
            if(cur.getChild(letter) == null)
                cur.setChild(new TrieNode(), letter);
            else
                cur = cur.getChild(letter);
        }
        cur.item = word;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public static boolean search(String word) {
        return searchWord(word.toCharArray(), root, 0);
    }
   
    private static boolean searchWord(char[] chars, TrieNode node, int index) {
        if(index == chars.length)
            return !node.item.equals("");
            
        if(chars[index] != '.') {
            int id = chars[index] - 'a';
            return node.children[id] != null && searchWord(chars, node.children[id], index + 1);
        } else {
            for(int i = 0; i < node.children.length; i++) {
                if(node.children[i] != null) {
                    if(searchWord(chars, node.children[i], index+1))
                        return true;
                }
            }
        }
        return false;
    }
    
    public class TrieNode {
        public final TrieNode[] children;
        public String item;
    
         public TrieNode() {
            children = new TrieNode[26];
            item = "";
        }
    
        public void setChild(TrieNode node, char letter) {
            int index = letter - 'a';
            children[index] = node;
        }
    
        public TrieNode getChild(char letter) {
            int index = letter - 'a';
            return children[index];
        }
    } 
}


// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
