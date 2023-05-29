package org.hetatech.probstatslib.elstatsbluman;

public class ElStatsBluman {


    public double midpoint(double lowerBoundary, double upperBoundary) {
        return (lowerBoundary + upperBoundary) / 2;
    }

    public double percentageValue(long f, long n) {
        return ((double) f / n) * 100;
    }

    public double mean(double[] a) {
        double s = 0;
        for (double v : a) {
            s += v;
        }
        return s/a.length;
    }
}
