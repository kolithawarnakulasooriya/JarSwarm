package examples.si.benchmarks.singleObjective;

import org.usa.soc.si.ObjectiveFunction;

public class SchafferFunctionN4 extends ObjectiveFunction {
    @Override
    public Double call() {

        Double x = (Double) super.getParameters()[0];
        Double y = (Double) super.getParameters()[1];

        double d = Math.pow(Math.cos(Math.sin(Math.abs( Math.pow(x, 2) - Math.pow(y, 2) ))),2) - 0.5;
        d = d / Math.pow(1 + (0.001 * (Math.pow(x, 2) + Math.pow(y, 2))), 2 );
        return 0.5 + d;
    }

    @Override
    public int getNumberOfDimensions() {
        return 2;
    }

    @Override
    public double[] getMin() {
        return new double[]{-100, -100};
    }

    @Override
    public double[] getMax() {
        return new double[]{100, 100};
    }

    @Override
    public double getExpectedBestValue() {
        return 0.292579;
    }

    @Override
    public double[] getExpectedParameters() {
        return new double[]{0,-1.25313, 0,1.25313, 1.25313,0, -1.25313, 0};
    }
}