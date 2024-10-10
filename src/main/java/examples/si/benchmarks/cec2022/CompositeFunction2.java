package examples.si.benchmarks.cec2022;

import examples.si.benchmarks.BaseFunctions;
import examples.si.benchmarks.WeightCalculator;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.usa.soc.si.ObjectiveFunction;
import org.usa.soc.util.Commons;
import org.usa.soc.util.FileHandler;

public class CompositeFunction2 extends ObjectiveFunction {

    private double fBias = 2400;
    private RealMatrix fShift;
    private RealMatrix fMatrix;

    double[] lambdas = new double[]{1, 1, 1};
    double[] bias = new double[]{0, 200, 100};
    double[] rhos = new double[]{20, 10, 10};

    public CompositeFunction2() {}
    @Override
    public ObjectiveFunction updateDimensions(int n){
        this.numberOfDimensions = 20;
        fShift = new FileHandler("src/main/java/examples/si/benchmarks/cecdata/cec2022/shift_data_10.txt").read().toRealMatrix().getSubMatrix(0,0, 0, 19);
        fMatrix = new FileHandler("src/main/java/examples/si/benchmarks/cecdata/cec2022/M_10_D20.txt").read().toRealMatrix();

        return this;
    }

    @Override
    public Double call() {
        RealMatrix rm = getParametersMatrix();

        RealMatrix rw0 = rm.subtract(fShift)
                        .scalarMultiply(10).multiply(fMatrix.getSubMatrix(0, numberOfDimensions-1, 0, numberOfDimensions-1));
        double g0 = lambdas[0] * BaseFunctions.ModifiedSchwefelFunction(rw0, bias[0], numberOfDimensions);
        double w0 = WeightCalculator.calculate(rm.subtract(fShift), rhos[0], numberOfDimensions);

        RealMatrix rw1 = rm.subtract(fShift).scalarMultiply(0.0512).multiply(fMatrix.getSubMatrix(numberOfDimensions, 2*numberOfDimensions-1, 0, numberOfDimensions-1));
        double g1 = lambdas[1] * BaseFunctions.RastriginsFunction(rw1, bias[1], numberOfDimensions);
        double w1 = WeightCalculator.calculate(rm.subtract(fShift), rhos[1], numberOfDimensions);

        RealMatrix rw2 = rm.subtract(fShift).scalarMultiply(0.005).multiply(fMatrix.getSubMatrix(2*numberOfDimensions, 3*numberOfDimensions-1, 0, numberOfDimensions-1));
        double g2 = lambdas[2] * BaseFunctions.HgBat(rw2, bias[2], numberOfDimensions);
        double w2 = WeightCalculator.calculate(rm.subtract(fShift), rhos[2], numberOfDimensions);

        double totalW = w0 + w1 + w2;

        RealVector ws = new ArrayRealVector(new double[]{w0/totalW, w1/totalW, w2/totalW});
        RealVector gs = new ArrayRealVector(new double[]{g0, g1, g2});

        return ws.dotProduct(gs) + fBias;
    }

    @Override
    public double[] getMin() {
        return Commons.fill(-100, numberOfDimensions);
    }

    @Override
    public double[] getMax() {
        return Commons.fill(100, numberOfDimensions);
    }

    @Override
    public double getExpectedBestValue() {
        return fBias;
    }

    @Override
    public double[] getExpectedParameters() {
        return new double[]{fShift.getEntry(0,0), fShift.getEntry(0,1)};
    }
}
