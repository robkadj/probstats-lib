package org.hetatech.probstatslib.elstatsbluman;

import org.hetatech.probstatslib.dm.DoubleFrequencyClass;

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

    public double mean(DoubleFrequencyClass[] arr) {
        long fSum = 0;
        double freqWithMidpointSum = 0;
        for(DoubleFrequencyClass v : arr) {
            fSum += v.f();
            double midpoint = midpoint(v.doubleClass().start(), v.doubleClass().end());
            freqWithMidpointSum += midpoint*v.f();
        }
        return freqWithMidpointSum / fSum;
    }
}
