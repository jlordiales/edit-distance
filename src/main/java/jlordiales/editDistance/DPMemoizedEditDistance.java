package jlordiales.editDistance;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class DPMemoizedEditDistance implements EditDistance {

    public int editDistance(String word1, String word2) {
        return editDistance(word1, word2, new HashMap<StringTuple, Integer>());
    }
    
    private int editDistance(String word1, String word2, Map<StringTuple, Integer> computedSolutions) {
        if (word1.isEmpty()) return word2.length();
        if (word2.isEmpty()) return word1.length();

        StringTuple replaceTuple = new StringTuple(word1.substring(1), word2.substring(1));
        StringTuple deleteTuple = new StringTuple(word1.substring(1), word2);
        StringTuple insertTuple = new StringTuple(word1, word2.substring(1));

        int replace = Util.replaceCost(word1, word2, 0, 0) + transformationCost(replaceTuple, computedSolutions);
        int delete = 1 + transformationCost(deleteTuple, computedSolutions);
        int insert = 1 + transformationCost(insertTuple, computedSolutions);

        int minEditDistance = Util.min(replace, delete, insert);
        computedSolutions.put(new StringTuple(word1, word2), minEditDistance);
        return minEditDistance;
    }
    
    private int transformationCost(StringTuple tuple, Map<StringTuple, Integer> solutions) {
       if (solutions.containsKey(tuple)) return solutions.get(tuple);
       
       int result = editDistance(tuple.s1, tuple.s2, solutions);
       solutions.put(tuple, result);
       return result;
    }
    
    /**
     * Helper class to save previous solutions
     *
     */
    private class StringTuple {
        private final String s1;
        private final String s2;
        public StringTuple(String s1, String s2) {
            this.s1 = s1;
            this.s2 = s2;
        }
        
        @Override
        public int hashCode() {
            return HashCodeBuilder.reflectionHashCode(this);
        }
        
        @Override
        public boolean equals(Object obj) {
            return EqualsBuilder.reflectionEquals(this,obj);
        }
    }
}
