package jlordiales.editDistance;

public class BruteForceEditDistance implements EditDistance {

    public int editDistance(String word1, String word2) {
        if (word1.isEmpty()) return word2.length();
        if (word2.isEmpty()) return word1.length();

        int replace = editDistance(word1.substring(1), word2.substring(1)) + Util.replaceCost(word1, word2, 0, 0);
        int delete = editDistance(word1.substring(1), word2) + 1;
        int insert = editDistance(word1, word2.substring(1)) + 1;
        return Util.min(replace, delete, insert);
    }
}
