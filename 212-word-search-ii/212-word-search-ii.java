class TrieNode {
    public TrieNode children[];
    public String word;
    
    public TrieNode()
    {
        this.children = new TrieNode[26];
        this.word = null;
    }
}
class Solution {
    public char[][] board;
    public List<String> result;
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        this.board = board;
        this.result = new ArrayList<>();
        for(String word : words)
        {
            TrieNode crawl = root;
            for(char w : word.toCharArray())
            {
                if(crawl.children[w-'a']==null)
                    crawl.children[w-'a'] = new TrieNode();
                
                crawl = crawl.children[w-'a'];
            }
            crawl.word = word;
        }
        
        for(int i=0;i<this.board.length;i++)
        {
            for(int j=0;j<this.board[0].length;j++)
            {
                // if(root.children[this.board[i][j]-'a']!=null)
                    Backtrack(root, i,j);
            }
        }
        return this.result;
    }
    
    public void Backtrack(TrieNode root, int i, int j)
    {
        if(i<0 || j<0 || i>=this.board.length || j>=this.board[0].length|| this.board[i][j]=='#')
            return;
        
        TrieNode currNode = root.children[this.board[i][j]-'a'];
        
        if(currNode==null)
            return;
        
        if(currNode.word!=null)
        {
            this.result.add(currNode.word);
            currNode.word = null;
            // return;
        }
        char c = this.board[i][j];
        this.board[i][j] = '#';
        Backtrack(currNode, i-1,j);
        Backtrack(currNode, i+1,j);
        Backtrack(currNode, i,j-1);
        Backtrack(currNode, i,j+1);
        this.board[i][j] = c;
    }
}