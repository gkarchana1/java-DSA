public class Trie{

	private TrieNode root;

	public class TrieNode{
		private TrieNode[] children;
		private boolean isWord;

	
		public TrieNode(){

			this.children = new TrieNode[26];
			this.isWord = false;
		}
	}

	public Trie(){

		this.root = new TrieNode();
	}

	public void insert( String word ){
		
		if( word == null || word.isEmpty() ){
			throw new IllegalArgumentException("Invalid input");
		}


		word = word.toLowerCase();
		TrieNode current = root;

		for( int i = 0 ; i < word.length(); i++ ){
			char c= word.charAt(i);
			int index = c - 'a';

			if( current.children[index] == null ){
				TrieNode node = new TrieNode();
				current.children[index] = node;
				current = node;
			}
			else{
				current = current.children[index];
			}

		}
		current.isWord = true;
	}

    public boolean search(String key)
    {
        int level;
        int length = key.length();
        int index;
        TrieNode current = root;
      
        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
      
            if (current.children[index] == null)
                return false;
      
            current = current.children[index];
        }
      
        return (current.isWord);
    }

	public static void main( String args[] ){

		Trie trie = new Trie();
		trie.insert("cat");
		trie.insert("dog");
		trie.insert("parrot");
		System.out.println("Inserted successfully");

		String word = "parrot";

      	if(trie.search(word) == true)
            System.out.println(word + " - Present in trie" );
        else System.out.println(word + " - Not present in trie");
	}
}