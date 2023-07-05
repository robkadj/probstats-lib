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

    public double populationVariance(double[] arr) {
        double s = 0;
        for(double v : arr) {
            s += v;
        }
        double mean = s/arr.length;

        double sum = 0;
        for(double v : arr) {
            sum += Math.pow((v - mean), 2);
        }
        return sum/arr.length;
    }

    public double populationStandardDeviation(double[] arr) {
        return Math.sqrt(populationVariance(arr));
    }

    public double sampleVariance(double[] arr) {
        double s = 0;
        for(double v : arr) {
            s += v;
        }
        double mean = s/arr.length;

        double sum = 0;
        for(double v : arr) {
            sum += Math.pow((v - mean), 2);
        }
        return sum/(arr.length - 1);
    }

    public double sampleStandardDeviation(double[] arr) {
        return Math.sqrt(sampleVariance(arr));
    }

    /**
     * Implementation of variance for grouped data as described on page 121. The formula has been implemented as shown
     * on page 122, Step 5
     * @param arr the array with input data
     * @return the variance of grouped data
     */
    public double sampleGroupedDataVariance(DoubleFrequencyClass[] arr) {
        double sumFreMidpointSq = 0;
        for (DoubleFrequencyClass v : arr) {
            sumFreMidpointSq += v.f() * Math.pow(midpoint(v.doubleClass().start(), v.doubleClass().end()), 2);
        }
        double sumFreqMidPoint = 0;
        for (DoubleFrequencyClass v : arr) {
            sumFreqMidPoint += v.f() * midpoint(v.doubleClass().start(), v.doubleClass().end());
        }
        long n = 0;
        for (DoubleFrequencyClass v : arr) {
            n += v.f();
        }
        return (sumFreMidpointSq - Math.pow(sumFreqMidPoint, 2) / n) / ( n - 1 );
    }

    /**
     * Implementation of standard deviation for grouped data as described on page 121.
     * The formula has been implemented as shown on page 122, Step 6
     * @param arr the array with input data
     * @return standard deviation of grouped data
     */
    public double sampleGroupedDataStandardDeviation(DoubleFrequencyClass[] arr) {
        return Math.sqrt(sampleGroupedDataVariance(arr));
    }
}
