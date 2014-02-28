package jlordiales.editDistance;

public class DPBottomUpEditDistanceTest extends EditDistanceTest {

    @Override
    protected EditDistance getImplementationInstance() {
        return new DPBottomUpEditDistance();
    }

}
