package cl.uchile.dcc.scrabble.types;

import cl.uchile.dcc.scrabble.types.numbers.ScrBinary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertTrue(bool1.getValue());
        assertFalse(bool2.getValue());
    }

    @Test
    void toScrStringTest(){
        var testStructure1 = new ScrString("true");
        var testStructure2 = new ScrString("false");
        assertEquals(testStructure1, bool1.toScrString());
        assertEquals(testStructure2, bool2.toScrString());
    }

    @Test
    void toScrBoolTest(){
        assertEquals(bool1, bool1.toScrBool());
        assertEquals(bool2, bool2.toScrBool());
    }

    //cl.uchile.dcc.scrabble.AST.Operations test
    @Test
    void logicAndTest(){
        var testStructure1 = new ScrBinary("0001011010011010");
        var testStructure2 = new ScrBinary("0000000000000001");
        var testStructure3 = new ScrBinary("1111111111111111");
        assertEquals(new ScrBool(false), bool1.logicAnd(bool2));
        assertEquals(new ScrBool(true), bool1.andByBool(bool1));
        assertEquals(testStructure1, bool1.logicAnd(testStructure1));
        assertEquals(new ScrBinary("0000000000000001"), bool1.andByBinary(testStructure2));
        assertEquals(new ScrBinary("0000000000000000"), bool2.andByBinary(testStructure3));
    }

    @Test
    void logicOrTest(){
        var testStructure1 = new ScrBinary("0001011010011010");
        var testStructure2 = new ScrBinary("0000000000000001");
        var testStructure3 = new ScrBinary("1111111111111111");
        assertEquals(new ScrBool(true), bool1.logicOr(bool2));
        assertEquals(new ScrBool(false), bool2.orByBool(bool2));
        assertEquals(testStructure1, bool2.logicOr(testStructure1));
        assertEquals(new ScrBinary("1111111111111111"), bool1.orByBinary(testStructure2));
        assertEquals(new ScrBinary("1111111111111111"), bool2.orByBinary(testStructure3));
    }

    @Test
    void negationTest(){
        assertFalse(bool1.neg().getValue());
        assertTrue(bool2.neg().getValue());
    }
}
