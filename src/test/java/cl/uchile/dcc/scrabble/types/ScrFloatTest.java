package cl.uchile.dcc.scrabble.types;

import cl.uchile.dcc.scrabble.types.numbers.ScrBinary;
import cl.uchile.dcc.scrabble.types.numbers.ScrFloat;
import cl.uchile.dcc.scrabble.types.numbers.ScrInt;
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
    void toScrString(){
        var testStructure1 = new ScrString("420.0");
        var testStructure2 = new ScrString("69.0");
        assertEquals(testStructure1, float1.toScrString());
        assertEquals(testStructure2, float2.toScrString());
    }

    @Test
    void toScrFloatTest(){
        assertEquals(float1, float1.toScrFloat());
        assertEquals(float2, float2.toScrFloat());
    }

    //cl.uchile.dcc.scrabble.AST.Operations Test
    @Test
    void additionTest(){
        var testStructure1 = new ScrFloat(12451.0);
        var testStructure2 = new ScrInt(12);
        var testStructure3 = new ScrInt(512);
        var testStructure4 = new ScrFloat(145.7);
        var testStructure5 = new ScrFloat(12354.5372);
        var testStructure6 = new ScrFloat(0.5);
        var testStructure7 = new ScrBinary("0000000110100100");
        var testStructure8 = new ScrBinary("0000000001000101");
        var testStructure9 = new ScrBinary("1001001010000111");//-28025
        assertEquals(new ScrFloat(432.0), float1.add(testStructure2));
        assertEquals(new ScrFloat(432.0), float1.addToScrInt(testStructure2));
        assertEquals(new ScrFloat(145.7+12354.5372), testStructure4.add(testStructure5));
        assertEquals(new ScrFloat(581.0), float2.addToScrInt(testStructure3));
        assertEquals(new ScrFloat(420.5), float1.addToScrFloat(testStructure6));
        assertEquals(new ScrFloat(840.0), testStructure7.addToScrFloat(float1));
        assertEquals(new ScrFloat(-15574.0), testStructure9.addToScrFloat(testStructure1));
        assertEquals(new ScrFloat(69.5), testStructure8.addToScrFloat(testStructure6));
    }

    @Test
    void subtractionTest(){
        var testStructure1 = new ScrFloat(12451.342);
        var testStructure2 = new ScrInt(12);
        var testStructure3 = new ScrInt(512);
        var testStructure4 = new ScrFloat(145.7);
        var testStructure5 = new ScrFloat(12354.5372);
        var testStructure6 = new ScrFloat(0.5);
        var testStructure7 = new ScrBinary("0000000110100100");
        var testStructure8 = new ScrBinary("0000000001000101");
        var testStructure9 = new ScrBinary("1001001010000111");//-28025
        assertEquals(new ScrFloat(408.0), float1.subtract(testStructure2));
        assertEquals(new ScrFloat(-408.0), float1.subtractToScrInt(testStructure2));
        assertEquals(new ScrFloat(443.0), float2.subtractToScrInt(testStructure3));
        assertEquals(new ScrFloat(-12208.8372), testStructure4.subtract(testStructure5));
        assertEquals(new ScrFloat(-419.5), float1.subtractToScrFloat(testStructure6));
        assertEquals(new ScrFloat(0.0), testStructure7.subtractToScrFloat(float1));
        assertEquals(new ScrFloat(12451.342+28025), testStructure9.subtractToScrFloat(testStructure1));
        assertEquals(new ScrFloat(-68.5), testStructure8.subtractToScrFloat(testStructure6));
    }

    @Test
    void multiplicationTest(){
        var testStructure1 = new ScrFloat(123.456);
        var testStructure2 = new ScrInt(12);
        var testStructure3 = new ScrInt(512);
        var testStructure4 = new ScrFloat(145.7);
        var testStructure5 = new ScrFloat(12354.5372);
        var testStructure7 = new ScrBinary("0000000110100100");
        var testStructure8 = new ScrBinary("0000000001000101");
        assertEquals(new ScrFloat(5040.0), float1.multiply(testStructure2));
        assertEquals(new ScrFloat(5040.0), float1.mulAScrInt(testStructure2));
        assertEquals(new ScrFloat(74598.4), testStructure4.mulAScrInt(testStructure3));
        assertEquals(new ScrFloat(1800056.07004), testStructure4.multiply(testStructure5));
        assertEquals(new ScrFloat(-869.4), float2.mulAScrFloat(new ScrFloat(-12.6)));
        assertEquals(new ScrFloat(176400.0), testStructure7.multiplyAScrFloat(float1));
        assertEquals(new ScrFloat(8518.464), testStructure8.multiplyAScrFloat(testStructure1));
    }

    @Test
    void divisionTest(){
        var testStructure1 = new ScrFloat(123.456);
        var testStructure2 = new ScrInt(12);
        var testStructure3 = new ScrInt(512);
        var testStructure4 = new ScrFloat(145.7);
        var testStructure5 = new ScrFloat(12354.5372);
        var testStructure7 = new ScrBinary("0000000110100100");
        var testStructure8 = new ScrBinary("0000000001000101");
        assertEquals(new ScrFloat(35.0), float1.divide(testStructure2));
        assertEquals(12.0/420.0, 0.02857142857142857);
        assertEquals(new ScrFloat(12.0/420.0), float1.divideAScrInt(testStructure2));
        assertEquals(new ScrFloat(512.0/145.7), testStructure4.divideAScrInt(testStructure3));
        assertEquals(new ScrFloat(145.7/12354.5372), testStructure4.divide(testStructure5));
        assertEquals(new ScrFloat(-12.6/69.0), float2.divideAScrFloat(new ScrFloat(-12.6)));
        assertEquals(new ScrFloat(1.0), testStructure7.divideAScrFloat(float1));
        assertEquals(new ScrFloat(123.456/69.0), testStructure8.divideAScrFloat(testStructure1));
    }
}
