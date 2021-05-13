package cl.uchile.dcc.scrabble.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class ScrStringTest {
    private ScrString str1;
    private ScrString str2;
    String test1 = "the cake";
    String test2 = "is a lie";

    @BeforeEach
    void SetUp(){
        str1=new ScrString(test1);
        str2=new ScrString(test2);
    }

    @Test
    void constructorTest(){
        var testStructure1 = new ScrString(test1);
        var testStructure2 = new ScrString(test2);
        assertEquals(str1, testStructure1);
        assertEquals(str2, testStructure2);
        assertNotEquals(str1, testStructure2);
        assertEquals(str1.hashCode(), testStructure1.hashCode());
        assertNotEquals(str2.hashCode(), testStructure1.hashCode());
    }

    @Test
    void toStringTest(){
        assertEquals("the cake", str1.toString());
        assertEquals("is a lie", str2.toString());
    }

    @Test
    void getValueTest(){
        assertEquals("the cake", str1.getValue());
        assertEquals("is a lie", str2.getValue());
    }

    @Test
    void stringToString(){
        assertEquals(str1, str1.stringToString());
        assertEquals(str2, str2.stringToString());
    }
}