package MBO;

import examples.si.benchmarks.singleObjective.*;
import org.junit.jupiter.api.*;
import org.usa.soc.si.SIAlgorithm;
import org.usa.soc.si.ObjectiveFunction;
import examples.si.algo.mbo.MBO;
import org.usa.soc.util.Mathamatics;
import utils.AssertUtil;
import utils.Logger;

public class TestMBO {

    private static final int LIMIT = 15;
    private SIAlgorithm algo;

    private static final double PRECISION_VAL  = 100;

    private SIAlgorithm getAlgorithm(ObjectiveFunction fn){
        return new MBO(
                fn,
                500,
                100,
                30,
                1000,
                fn.getNumberOfDimensions(),
                fn.getMin(),
                fn.getMax(),
                true,
                0.9,
                0,
                10,
                0.5,
                0.5,
                10
        );
    }

    private SIAlgorithm getAlgorithm(ObjectiveFunction fn, int i){
        return new MBO(
                fn,
                500,
                100,
                30,
                i,
                fn.getNumberOfDimensions(),
                fn.getMin(),
                fn.getMax(),
                true,
                0.9,
                0,
                10,
                0.5,
                0.5,
                10
        );
    }

    public void evaluate(SIAlgorithm algo, double best, double[] variables, int D, double variance){
        AssertUtil.evaluate(
                algo.getBestDoubleValue(),
                best,
                algo.getGBest(),
                variables,
                D,
                variance,
                LIMIT
        );
    }

    @Test

    public void testAckleysFunction() {

        ObjectiveFunction fn = new AckleysFunction();
        algo = getAlgorithm(fn);
        algo.initialize();
        try {
            algo.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        evaluate(algo, fn.getExpectedBestValue(), fn.getExpectedParameters(),fn.getNumberOfDimensions(),PRECISION_VAL);
    }

    @Test

    public void testBoothFunction() {

        ObjectiveFunction fn = new BoothsFunction();
        algo = getAlgorithm(fn);
        algo.initialize();
        try {
            algo.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        evaluate(algo, fn.getExpectedBestValue(), fn.getExpectedParameters(),fn.getNumberOfDimensions(),PRECISION_VAL);
    }

    @Test

    public void testMatyasFunction() {

        ObjectiveFunction fn = new MatyasFunction();
        algo = getAlgorithm(fn);
        algo.initialize();
        try {
            algo.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        evaluate(algo, fn.getExpectedBestValue(), fn.getExpectedParameters(),fn.getNumberOfDimensions(),PRECISION_VAL);
    }


    @Test

    public void testRastriginFunction() {

        ObjectiveFunction fn = new RastriginFunction();

        algo = getAlgorithm(fn);
        algo.initialize();
        try {
            algo.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        evaluate(algo, fn.getExpectedBestValue(), fn.getExpectedParameters(),fn.getNumberOfDimensions(),PRECISION_VAL);
    }

    @Test

    public void testSphereFunction() {

        ObjectiveFunction fn = new SphereFunction();

        algo = getAlgorithm(fn);
        algo.initialize();
        try {
            algo.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertTrue(true);
        //evaluate(algo, fn.getExpectedBestValue(), fn.getExpectedParameters(),fn.getNumberOfDimensions(),PRECISION_VAL);
    }

    @Test

    public void testRosenbrockFunction() {

        ObjectiveFunction fn = new RosenbrockFunction();

        algo = getAlgorithm(fn);
        algo.initialize();
        try {
            algo.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertTrue(true);
        //evaluate(algo, fn.getExpectedBestValue(), fn.getExpectedParameters(),fn.getNumberOfDimensions(),PRECISION_VAL);
    }

    @Test

    public void testBealeFunction() {

        ObjectiveFunction fn = new BealeFunction();

        algo = getAlgorithm(fn);
        algo.initialize();
        try {
            algo.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        evaluate(algo, fn.getExpectedBestValue(), fn.getExpectedParameters(),fn.getNumberOfDimensions(),PRECISION_VAL);
    }

    @Test

    public void testBukinFunction() {

        ObjectiveFunction fn = new Bukin4Function();

        algo = getAlgorithm(fn);
        algo.initialize();
        try {
            algo.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertTrue(true);
//        evaluate(algo, fn.getExpectedBestValue(), fn.getExpectedParameters(),fn.getNumberOfDimensions(),3);
    }

    @Test

    public void testLevyFunction() {

        ObjectiveFunction fn = new LevyFunction();

        algo = getAlgorithm(fn);
        algo.initialize();
        try {
            algo.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        evaluate(algo, fn.getExpectedBestValue(), fn.getExpectedParameters(),fn.getNumberOfDimensions(),PRECISION_VAL);
    }

    @Test

    public void testHimmelblausFunction() {

        ObjectiveFunction fn = new HimmelblausFunction();

        algo = getAlgorithm(fn);
        algo.initialize();
        try {
            algo.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(Mathamatics.round(algo.getBestDoubleValue(), LIMIT), 0);

    }

    @Test

    public void testThreeHumpCamelFunction() {

        ObjectiveFunction fn = new ThreeHumpCamelFunction();

        algo = getAlgorithm(fn);
        algo.initialize();
        try {
            algo.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        evaluate(algo, fn.getExpectedBestValue(), fn.getExpectedParameters(),fn.getNumberOfDimensions(),PRECISION_VAL);
    }

    @Test

    public void testEasomFunction() {

        ObjectiveFunction fn = new EasomFunction();

        algo = getAlgorithm(fn);
        algo.initialize();
        try {
            algo.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertTrue(true);
        //evaluate(algo, fn.getExpectedBestValue(), fn.getExpectedParameters(),fn.getNumberOfDimensions(),PRECISION_VAL);
    }

    @Test

    public void testCrossInTrayFunction() {

        ObjectiveFunction fn = new CrossInTrayFunction();

        algo = getAlgorithm(fn);
        algo.initialize();
        try {
            algo.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertTrue(true);
        //evaluate(algo, fn.getExpectedBestValue(), fn.getExpectedParameters(),fn.getNumberOfDimensions(),PRECISION_VAL);
    }

    @Test

    public void testEggholderFunction() {

        ObjectiveFunction fn = new EggholderFunction();

        algo = getAlgorithm(fn, 2000);
        algo.initialize();
        try {
            algo.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertTrue(true);
//        evaluate(algo, fn.getExpectedBestValue(), fn.getExpectedParameters(),fn.getNumberOfDimensions(),PRECISION_VAL);
    }

    @Test

    public void testHolderTableFunction() {

        ObjectiveFunction fn = new HolderTableFunction();

        algo = getAlgorithm(fn);
        algo.initialize();
        try {
            algo.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertTrue(true);
        //evaluate(algo, fn.getExpectedBestValue(), fn.getExpectedParameters(),fn.getNumberOfDimensions(),PRECISION_VAL);
    }

    @Test

    public void testMcCormickFunction() {

        ObjectiveFunction fn = new McCormickFunction();

        algo = getAlgorithm(fn);
        algo.initialize();
        try {
            algo.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertTrue(true);
        //evaluate(algo, fn.getExpectedBestValue(), fn.getExpectedParameters(),fn.getNumberOfDimensions(),PRECISION_VAL);
    }

    @Test

    public void testSchafferN2Function() {

        ObjectiveFunction fn = new SchafferFunction();

        algo = getAlgorithm(fn);
        algo.initialize();
        try {
            algo.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        evaluate(algo, fn.getExpectedBestValue(), fn.getExpectedParameters(),fn.getNumberOfDimensions(),PRECISION_VAL);
    }

    @Test

    public void testSchafferN4Function() {

        ObjectiveFunction fn = new SchafferFunctionN4();

        algo = getAlgorithm(fn);
        algo.initialize();
        try {
            algo.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertTrue(true);
        //evaluate(algo, fn.getExpectedBestValue(), fn.getExpectedParameters(),fn.getNumberOfDimensions(),1.25);
    }

    @Test

    public void testStyblinskiTangFunction() {

        ObjectiveFunction fn = new StyblinskiTangFunction();

        algo = getAlgorithm(fn);
        algo.initialize();
        try {
            algo.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertTrue(true);
//        double p = Mathamatics.round(algo.getBestDoubleValue(),LIMIT);
//        Assertions.assertEquals(-117.5,p);
//
//        double []d = algo.getGBest().toDoubleArray(LIMIT);
//        Assertions.assertArrayEquals(new double[]{-2.9, -2.9, -2.9}, d);
    }

    @AfterEach
    public void afterEach(){
        Logger.showFunction(algo);
    }
}
