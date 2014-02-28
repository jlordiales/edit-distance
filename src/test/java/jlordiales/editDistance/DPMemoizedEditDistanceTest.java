package jlordiales.editDistance;

public class DPMemoizedEditDistanceTest extends EditDistanceTest {

    @Override
    protected EditDistance getImplementationInstance() {
        return new DPMemoizedEditDistance();
    }

}
