package org.usa.soc.si.jso;

import org.usa.soc.core.ds.Vector;
import org.usa.soc.util.Randoms;

public class Jellyfish {

    private Vector position;
    private double fitnessValue;

    public Jellyfish(int numberOfDimensions,double[] minBoundary, double[] maxBoundary) {
        this.position = Randoms.getRandomVector(numberOfDimensions, minBoundary, maxBoundary, 0,1);
    }

    public Vector getPosition() {
        return position.getClonedVector();
    }

    public void setPosition(Vector position) {
        this.position.setVector(position);
    }

    public double getFitnessValue() {
        return fitnessValue;
    }

    public void setFitnessValue(double fitnessValue) {
        this.fitnessValue = fitnessValue;
    }
}
