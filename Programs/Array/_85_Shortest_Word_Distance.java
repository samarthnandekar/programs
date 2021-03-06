package Array;

/*
 243 LeetCode Java: Shortest Word Distance – Easy
Problem:
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = [“practice”, “makes”, “perfect”, “coding”, “makes”].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = “makes”, word2 = “coding”, return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class _85_Shortest_Word_Distance {

	public static void main(String args[])
	{
		_85_Shortest_Word_Distance obj= new _85_Shortest_Word_Distance();
		String []input= {"practice", "makes", "perfect", "coding", "makes"};
		int count=obj.shortestDistance(input,"coding","practice");
		System.out.println(count);
	}
	
	public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i ++) {
            if (words[i].equals(word1)) {
                if (index2 != -1) {
                    min = Math.min(i - index2, min);
                }
                index1 = i;
                continue;
            }
            if (words[i].equals(word2)) {
                if (index1 != -1) {
                    min = Math.min(i - index1, min);
                }
                index2 = i;
                continue;
            }
        }
        return min;
    }
}
