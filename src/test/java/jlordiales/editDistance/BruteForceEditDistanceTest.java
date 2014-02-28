package jlordiales.editDistance;

public class BruteForceEditDistanceTest extends EditDistanceTest {

    @Override
    protected EditDistance getImplementationInstance() {
        return new BruteForceEditDistance();
    }

}
