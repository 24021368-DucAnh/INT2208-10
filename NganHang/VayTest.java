package NganHang;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VayTest {
    private final Vay vay = new Vay();

    @Test
    void testInvalidInputs() {
        assertEquals("Invalid Input", vay.processLoan(17, 20.0, 600, "C"));
        assertEquals("Invalid Input", vay.processLoan(66, 20.0, 600, "C")); 
        assertEquals("Invalid Input", vay.processLoan(30, 4.9, 600, "C")); 
        assertEquals("Invalid Input", vay.processLoan(30, 500.1, 600, "C"));
        assertEquals("Invalid Input", vay.processLoan(30, 20.0, 299, "C"));
        assertEquals("Invalid Input", vay.processLoan(30, 20.0, 851, "C"));
        assertEquals("Invalid Input", vay.processLoan(30, 20.0, 600, "X")); 
    }

    @Test
    void testRejectLogic() {
        assertEquals("REJECT", vay.processLoan(18, 5.0, 300, "F"));     
        assertEquals("REJECT", vay.processLoan(65, 500.0, 500, "C"));  
        assertEquals("REJECT", vay.processLoan(30, 14.9, 501, "C"));  
        assertEquals("REJECT", vay.processLoan(30, 14.9, 700, "F"));   
    }

    @Test
    void testManualReviewLogic() {
        assertEquals("MANUAL REVIEW", vay.processLoan(30, 14.9, 701, "C")); 
        assertEquals("MANUAL REVIEW", vay.processLoan(30, 15.0, 600, "F")); 
        assertEquals("MANUAL REVIEW", vay.processLoan(30, 500.0, 850, "F"));
    }

    @Test
    void testApproveLogic() {
        assertEquals("APPROVE", vay.processLoan(30, 15.0, 501, "C"));
        assertEquals("APPROVE", vay.processLoan(30, 20.0, 850, "C")); 
    }
}