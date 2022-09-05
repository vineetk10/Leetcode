class Trie {
    public Trie trie[];
    public boolean endOfFlag;
    public Trie() {
        trie = new Trie[26];
        endOfFlag = false;
    }
    
    public void insert(String word) {
        Trie root = this;
        for(char c: word.toCharArray())
        {
            if(root.trie[c-'a']==null)
            {
                Trie t = new Trie();
                root.trie[c-'a'] = t;
            }
            
            root = root.trie[c-'a'];
        }
        root.endOfFlag = true;
    }
    
    public boolean search(String word) {
        boolean isPresent = false;
        Trie root = this;
        for(char c: word.toCharArray())
        {
            if(root.trie[c-'a']==null)
                return false;
            root = root.trie[c-'a'];
        }
        if(root.endOfFlag)
            return true;
        else
            return false;
    }
    
    public boolean startsWith(String prefix) {
        boolean isPresent = false;
        Trie root = this;
        for(char c: prefix.toCharArray())
        {
            if(root.trie[c-'a']==null)
                return false;
            root = root.trie[c-'a'];
        }
            return true;
        
      
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */