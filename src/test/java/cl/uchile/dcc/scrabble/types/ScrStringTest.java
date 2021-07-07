package cl.uchile.dcc.scrabble.types;

import cl.uchile.dcc.scrabble.types.numbers.ScrBinary;
import cl.uchile.dcc.scrabble.types.numbers.ScrFloat;
import cl.uchile.dcc.scrabble.types.numbers.ScrInt;
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
    void toScrStringTest(){
        assertEquals(str1, str1.toScrString());
        assertEquals(str2, str2.toScrString());
    }

    //Concatenation tests
    @Test
    void addTest(){

        var testStructure1 = new ScrInt(12451);
        var testStructure2 = new ScrFloat(145.7);
        var testStructure3 = new ScrBinary("0000000110100100");
        var testStructure4 = new ScrBinary("1001001010000111");
        var testStructure5 = new ScrBool(true);
        var testStructure6 = new ScrBool(false);
        assertEquals(new ScrString("the cakeis a lie"), str1.add(str2));
        assertEquals(new ScrString("the cake12451"), testStructure1.addToString(str1));
        assertEquals(new ScrString("is a lie145.7"), testStructure2.addToString(str2));
        assertEquals(new ScrString("the cake0000000110100100"), testStructure3.addToString(str1));
        assertEquals(new ScrString("is a lie1001001010000111"), testStructure4.addToString(str2));
        assertEquals(new ScrString("is a lietrue"), testStructure5.addToString(str2));
        assertEquals(new ScrString("the cakeis a liefalse"), testStructure6.addToString(str2.addToString(str1)));
    }
}