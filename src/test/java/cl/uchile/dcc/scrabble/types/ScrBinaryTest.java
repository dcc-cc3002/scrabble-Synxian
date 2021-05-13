package cl.uchile.dcc.scrabble.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ScrBinaryTest {
    private ScrBinary binary1;
    private ScrBinary binary2;
    String test1 = "110001";
    String test2 = "11111";

    @BeforeEach
    void SetUp(){
        binary1=new ScrBinary(test1);
        binary2=new ScrBinary(test2);
    }

    @Test
    void constructorTest(){
        var testStructure1 = new ScrBinary(test1);
        var testStructure2 = new ScrBinary(test2);
        assertEquals(binary1, testStructure1);
        assertEquals(binary2, testStructure2);
        assertNotEquals(binary1, testStructure2);
        assertEquals(binary1.hashCode(), testStructure1.hashCode());
        assertNotEquals(binary2.hashCode(), testStructure1.hashCode());
    }

    @Test
    void toStringTest(){
        assertEquals("110001", binary1.toString());
        assertEquals("11111", binary2.toString());
    }

    @Test
    void getValueTest(){
        assertEquals("110001", binary1.getValue());
        assertEquals("11111", binary2.getValue());
    }

    @Test
    void binaryToStringTest(){
        var testStructure1 = new ScrString("110001");
        var testStructure2 = new ScrString("11111");
        assertEquals(testStructure1, binary1.binaryToString());
        assertEquals(testStructure2, binary2.binaryToString());
    }

    @Test
    void binaryToBinary(){
        assertEquals(binary1, binary1.binaryToBinary());
        assertEquals(binary2, binary2.binaryToBinary());
    }
}
