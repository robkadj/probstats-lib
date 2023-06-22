package org.hetatech.probstatslib.elstatsbluman;

import org.hetatech.probstatslib.dm.DoubleClass;
import org.hetatech.probstatslib.dm.DoubleFrequencyClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ElStatsBlumanTest {

    @Test public void testMidpoint_Args_Int_Exact_Result() {
        ElStatsBluman testedClass = new ElStatsBluman();
        assertEquals( 3.0, testedClass.midpoint(4,2));
    }

    @Test public void testMidpoint_Args_Double_Exact_Result() {
        ElStatsBluman testedClass = new ElStatsBluman();
        assertEquals(20.05, testedClass.midpoint(17.3, 22.8));
    }

    @Test public void testPercentageValue_f_5_n_25() {
        ElStatsBluman testedClass = new ElStatsBluman();
        assertEquals(20, testedClass.percentageValue(5, 25));
    }

    @Test public void testPercentageValue_f_25_n_25() {
        ElStatsBluman testedClass = new ElStatsBluman();
        assertEquals(100, testedClass.percentageValue(25, 25));
    }

    @Test public void testPercentageValue_Division_By_0() {
        ElStatsBluman testedClass = new ElStatsBluman();
        assertEquals(Double.POSITIVE_INFINITY, testedClass.percentageValue(20, 0));
    }

    @Test public void testMean_4_values_all_2() {
        ElStatsBluman testedClass = new ElStatsBluman();
        assertEquals(2, testedClass.mean(new double[]{2, 2, 2, 2}));
    }

    @Test public void testMean_values_1_2_3_4_5() {
        ElStatsBluman testedClass = new ElStatsBluman();
        assertEquals(3, testedClass.mean(new double[]{1, 2, 3, 4, 5}));
    }

    @Test public void testMean_empty_array() {
        ElStatsBluman testedClass = new ElStatsBluman();
        assertEquals(Float.NaN, testedClass.mean(new double[]{}));
    }

    @Test public void testMean_array_with_1_value_1() {
        ElStatsBluman testedClass = new ElStatsBluman();
        assertEquals(1, testedClass.mean(new double[]{1}));
    }

    @Test public void testMeanArr_from_book_page100() {
        ElStatsBluman testedClass = new ElStatsBluman();
        DoubleFrequencyClass[] arr = new DoubleFrequencyClass[7];
        arr[0] = new DoubleFrequencyClass(new DoubleClass(5.5, 10.5), 1);
        arr[1] = new DoubleFrequencyClass(new DoubleClass(10.5, 15.5), 2);
        arr[2] = new DoubleFrequencyClass(new DoubleClass(15.5, 20.5), 3);
        arr[3] = new DoubleFrequencyClass(new DoubleClass(20.5, 25.5), 5);
        arr[4] = new DoubleFrequencyClass(new DoubleClass(25.5, 30.5), 4);
        arr[5] = new DoubleFrequencyClass(new DoubleClass(30.5, 35.5), 3);
        arr[6] = new DoubleFrequencyClass(new DoubleClass(35.5, 40.5), 2);
        assertEquals(24.5, testedClass.mean(arr));
    }
}
