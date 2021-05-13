package cl.uchile.dcc.scrabble.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ScrBoolTest {
    private ScrBool bool1;
    private ScrBool bool2;
    boolean test1 = true;
    boolean test2 = false;

    @BeforeEach
    void SetUp(){
        bool1=new ScrBool(test1);
        bool2=new ScrBool(test2);
    }

    @Test
    void constructorTest(){
        var testStructure1 = new ScrBool(test1);
        var testStructure2 = new ScrBool(test2);
        assertEquals(bool1, testStructure1);
        assertEquals(bool2, testStructure2);
        assertNotEquals(bool1, testStructure2);
        assertEquals(bool1.hashCode(), testStructure1.hashCode());
        assertNotEquals(bool2.hashCode(), testStructure1.hashCode());
    }

    @Test
    void toStringTest(){
        assertEquals("true", bool1.toString());
        assertEquals("false", bool2.toString());
    }

    @Test
    void getValueTest(){
        assertEquals(true, bool1.getValue());
        assertEquals(false, bool2.getValue());
    }

    @Test
    void boolToStringTest(){
        var testStructure1 = new ScrString("true");
        var testStructure2 = new ScrString("false");
        assertEquals(testStructure1, bool1.boolToString());
        assertEquals(testStructure2, bool2.boolToString());
    }

    @Test
    void boolToBoolTest(){
        assertEquals(bool1, bool1.boolToBool());
        assertEquals(bool2, bool2.boolToBool());
    }
}
