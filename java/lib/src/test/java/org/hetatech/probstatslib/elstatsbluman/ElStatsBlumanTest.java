package org.hetatech.probstatslib.elstatsbluman;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ElStatsBlumanTest {

    @Test public void testMidpoint_Args_Int_Exact_Result() {
        ElStatsBluman testedClass = new ElStatsBluman();
        assertEquals( 3.0, testedClass.midpoint(4,2));
    }

    @Test public void testMidpoint_Args_Double_Exact_Result() {
        ElStatsBluman testedClass = new ElStatsBluman();
        assertEquals(20.05, testedClass.midpoint(17.3, 22.8));
    }
}
