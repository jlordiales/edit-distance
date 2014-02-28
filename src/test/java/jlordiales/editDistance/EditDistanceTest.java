package jlordiales.editDistance;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public abstract class EditDistanceTest {
    
    private EditDistance editDistance;
    protected abstract EditDistance getImplementationInstance();
    
    @Before
    public void setup() {
        editDistance = getImplementationInstance();
    }

    @Test
    public void shouldReturn0ForEqualStrings() {
        assertEquals(0,editDistance .editDistance("aaa", "aaa"));
        assertEquals(0,editDistance.editDistance("", ""));
        assertEquals(0,editDistance.editDistance("aaaaaaaaaaaa", "aaaaaaaaaaaa"));
    }

    @Test
    public void shouldReturnTheLengthOfTheNonEmptyString() {
        assertEquals(4,editDistance.editDistance("abcd", ""));
        assertEquals(3,editDistance.editDistance("", "ase"));
    }
    
    @Test
    public void shouldReturn2ForCatAndCars() {
       assertEquals(2,editDistance.editDistance("cat", "cars")); 
    }
    
    @Test
    //This test takes a ridiculous amount of time for the brute force implementation
    public void shouldComputeTheResultFor2BigStrings() {
        assertEquals(19,editDistance.editDistance("Show me the money!", "You can't handle the truth!"));
    }
}
