package org.hetatech.probstatslib.elstatsbluman;

import org.hetatech.probstatslib.dm.DoubleClass;
import org.hetatech.probstatslib.dm.DoubleFrequencyClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test public void testMeanArr_from_book_page111_ex15() {
        ElStatsBluman testedClass = new ElStatsBluman();
        DoubleFrequencyClass[] arr = new DoubleFrequencyClass[9];
        arr[0] = new DoubleFrequencyClass(new DoubleClass(34, 96), 13);
        arr[1] = new DoubleFrequencyClass(new DoubleClass(97, 159), 2);
        arr[2] = new DoubleFrequencyClass(new DoubleClass(160, 222), 0);
        arr[3] = new DoubleFrequencyClass(new DoubleClass(223, 285), 5);
        arr[4] = new DoubleFrequencyClass(new DoubleClass(286, 348), 1);
        arr[5] = new DoubleFrequencyClass(new DoubleClass(349, 411), 1);
        arr[6] = new DoubleFrequencyClass(new DoubleClass(412, 474), 0);
        arr[7] = new DoubleFrequencyClass(new DoubleClass(475, 537), 1);
        arr[8] = new DoubleFrequencyClass(new DoubleClass(538, 600), 2);
        assertEquals(188.48, testedClass.mean(arr));
    }

    @Test public void testMeanArr_from_book_page111_ex13() {
        ElStatsBluman testedClass = new ElStatsBluman();
        DoubleFrequencyClass[] arr = new DoubleFrequencyClass[6];
        arr[0] = new DoubleFrequencyClass(new DoubleClass(202, 204), 2);
        arr[1] = new DoubleFrequencyClass(new DoubleClass(205, 207), 7);
        arr[2] = new DoubleFrequencyClass(new DoubleClass(208, 210), 16);
        arr[3] = new DoubleFrequencyClass(new DoubleClass(211, 213), 26);
        arr[4] = new DoubleFrequencyClass(new DoubleClass(214, 216), 18);
        arr[5] = new DoubleFrequencyClass(new DoubleClass(217, 219), 4);
        assertEquals(212, Math.round(testedClass.mean(arr)));
    }

    @Test public void testMeanArr_from_book_page112_ex21() {
        ElStatsBluman testedClass = new ElStatsBluman();
        DoubleFrequencyClass[] arr = new DoubleFrequencyClass[6];
        arr[0] = new DoubleFrequencyClass(new DoubleClass(15.5, 18.5), 14);
        arr[1] = new DoubleFrequencyClass(new DoubleClass(18.5, 21.5), 7);
        arr[2] = new DoubleFrequencyClass(new DoubleClass(21.5, 24.5), 16);
        arr[3] = new DoubleFrequencyClass(new DoubleClass(24.5, 27.5), 26);
        arr[4] = new DoubleFrequencyClass(new DoubleClass(27.5, 30.5), 18);
        arr[5] = new DoubleFrequencyClass(new DoubleClass(30.5, 33.5), 4);
        assertEquals(24, Math.round(testedClass.mean(arr)));
    }
}
