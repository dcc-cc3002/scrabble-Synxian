package cl.uchile.dcc.scrabble.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ScrFloatTest {
    private ScrFloat float1;
    private ScrFloat float2;
    double test1 = 420.0;
    double test2 = 69.0;

    @BeforeEach
    void SetUp(){
        float1=new ScrFloat(test1);
        float2=new ScrFloat(test2);
    }

    @Test
    void constructorTest(){
        var testStructure1 = new ScrFloat(test1);
        var testStructure2 = new ScrFloat(test2);
        assertEquals(float1, testStructure1);
        assertEquals(float2, testStructure2);
        assertNotEquals(float1, testStructure2);
        assertEquals(float1.hashCode(), testStructure1.hashCode());
        assertNotEquals(float2.hashCode(), testStructure1.hashCode());
    }

    @Test
    void toStringTest(){
        assertEquals("420.0", float1.toString());
        assertEquals("69.0", float2.toString());
    }

    @Test
    void getValueTest(){
        assertEquals(420.0, float1.getValue());
        assertEquals(69.0, float2.getValue());
    }

    @Test
    void floatToStringTest(){
        var testStructure1 = new ScrString("420.0");
        var testStructure2 = new ScrString("69.0");
        assertEquals(testStructure1, float1.floatToString());
        assertEquals(testStructure2, float2.floatToString());
    }

    @Test
    void floatToFloat(){
        assertEquals(float1, float1.floatToFloat());
        assertEquals(float2, float2.floatToFloat());
    }
}
