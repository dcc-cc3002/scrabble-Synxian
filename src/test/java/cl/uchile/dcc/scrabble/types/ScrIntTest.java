package cl.uchile.dcc.scrabble.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ScrIntTest {
    private ScrInt int1;
    private ScrInt int2;
    int test1 = 420;
    int test2 = 69;

    @BeforeEach
    void SetUp(){
        int1 = new ScrInt(test1);
        int2 = new ScrInt(test2);
    }

    @Test
    void constructorTest(){
        var testStructure1 = new ScrInt(test1);
        var testStructure2 = new ScrInt(test2);
        assertEquals(int1, testStructure1);
        assertEquals(int2, testStructure2);
        assertNotEquals(int1, testStructure2);
        assertEquals(int1.hashCode(), testStructure1.hashCode());
        assertNotEquals(int2.hashCode(), testStructure1.hashCode());
    }

    @Test
    void toStringTest(){
        assertEquals("420", int1.toString());
        assertEquals("69", int2.toString());
    }

    @Test
    void getValueTest(){
        assertEquals(420, int1.getValue());
        assertEquals(69, int2.getValue());
    }

    @Test
    void intToFloatTest(){
        var testStructure1 = new ScrFloat(420.0);
        var testStructure2 = new ScrFloat(69.0);
        assertEquals(testStructure1, int1.intToFloat());
        assertEquals(testStructure2, int2.intToFloat());
    }

    @Test
    void intToIntTest(){
        assertEquals(int1, int1.intToInt());
        assertEquals(int2, int2.intToInt());
    }

    @Test
    void intToStringTest(){
        var testStructure1 = new ScrString("420");
        var testStructure2 = new ScrString("69");
        assertEquals(testStructure1, int1.intToString());
        assertEquals(testStructure2, int2.intToString());
    }


}
