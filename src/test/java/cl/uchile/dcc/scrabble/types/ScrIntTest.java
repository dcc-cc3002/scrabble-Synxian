package cl.uchile.dcc.scrabble.types;

import cl.uchile.dcc.scrabble.types.numbers.ScrBinary;
import cl.uchile.dcc.scrabble.types.numbers.ScrFloat;
import cl.uchile.dcc.scrabble.types.numbers.ScrInt;
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
    void toScrFloatTest(){
        var testStructure1 = new ScrFloat(420.0);
        var testStructure2 = new ScrFloat(69.0);
        assertEquals(testStructure1, int1.toScrFloat());
        assertEquals(testStructure2, int2.toScrFloat());
    }

    @Test
    void toScrIntTest(){
        assertEquals(int1, int1.toScrInt());
        assertEquals(int2, int2.toScrInt());
        assertNotEquals(int1.toScrInt(), int2.toScrInt());
    }

    @Test
    void toScrStringTest(){
        var testStructure1 = new ScrString("420");
        var testStructure2 = new ScrString("69");
        assertEquals(testStructure1, int1.toScrString());
        assertEquals(testStructure2, int2.toScrString());
        assertNotEquals(int1.toScrString(), int2.toScrString());
        assertNotEquals(int1.toScrString(), testStructure2);
    }

    @Test
    void toScrBinaryTest(){
        var testStructure1 = new ScrBinary("0000000110100100");
        var testStructure2 = new ScrBinary("0000000001000101");
        var testStructure3 = new ScrBinary("1001001010000111");
        var testStructure4 = new ScrInt(37511);
        var testStructure5 = new ScrInt(-701);
        assertEquals(testStructure3, testStructure4.toScrBinary());
        assertEquals(int1.toScrBinary(),testStructure1);
        assertEquals(int2.toScrBinary(),testStructure2);
        assertNotEquals(int1.toScrBinary(), int2.toScrBinary());
        assertNotEquals(int1.toScrBinary(), testStructure2);
        assertEquals(new ScrBinary("1111110101000011"), testStructure5.toScrBinary());
    }

    @Test
    void additionTest(){
        var testStructure1 = new ScrInt(12451);
        var testStructure2 = new ScrInt(12);
        var testStructure3 = new ScrInt(512);
        var testStructure4 = new ScrFloat(145.7);
        var testStructure5 = new ScrFloat(12354.5372);
        var testStructure6 = new ScrFloat(0.5);
        var testStructure7 = new ScrBinary("0000000110100100");//420
        var testStructure8 = new ScrBinary("0000000001000101");//69
        var testStructure9 = new ScrBinary("1001001010000111");//-28025
        var t10= new ScrInt(0);
        var t11=new ScrBinary("0000000000000000");
        assertEquals(new ScrInt(432), int1.add(testStructure2));
        assertEquals(new ScrInt(432), testStructure2.addToScrInt(int1));
        assertEquals(new ScrInt(12963), testStructure3.add(testStructure1));
        assertEquals(new ScrInt(581), int2.addToScrInt(testStructure3));
        assertEquals(new ScrFloat(157.7), testStructure2.add(testStructure4));
        assertEquals(new ScrFloat(12866.5372), testStructure3.addToScrFloat(testStructure5));
        assertEquals(new ScrFloat(420.5), int1.addToScrFloat(testStructure6));
        assertEquals(new ScrBinary("0000001101001000"), int1.addToScrBinary(testStructure7));
        assertEquals(new ScrBinary("1100001100101010"), testStructure1.addToScrBinary(testStructure9));
        assertEquals(new ScrBinary("0000001001000101"), testStructure3.addToScrBinary(testStructure8));
        assertEquals(new ScrBinary("0000000000000000"), t10.addToScrBinary(t11));

    }

    @Test
    void subtractionTest(){
        var testStructure1 = new ScrInt(12451);
        var testStructure2 = new ScrInt(12);
        var testStructure3 = new ScrInt(512);
        var testStructure4 = new ScrFloat(145.7);
        var testStructure5 = new ScrFloat(12354.5372);
        var testStructure6 = new ScrFloat(0.5);
        var testStructure7 = new ScrBinary("0000000110100100");
        var testStructure8 = new ScrBinary("0000000001000101");
        var testStructure9 = new ScrBinary("1001001010000111");//-28025
        assertEquals(new ScrInt(408), int1.subtract(testStructure2));
        assertEquals(new ScrInt(408), testStructure2.subtractToScrInt(int1));
        assertEquals(new ScrInt(-11939), testStructure3.subtract(testStructure1));
        assertEquals(new ScrInt(443), int2.subtractToScrInt(testStructure3));
        assertEquals(new ScrFloat(-133.7), testStructure2.subtract(testStructure4));
        assertEquals(new ScrFloat(11842.5372), testStructure3.subtractToScrFloat(testStructure5));
        assertEquals(new ScrFloat(-419.5), int1.subtractToScrFloat(testStructure6));
        assertEquals(new ScrBinary("0000000000000000"), int1.subtractToScrBinary(testStructure7));
        assertEquals(new ScrBinary("0110000111100100"), testStructure1.subtractToScrBinary(testStructure9));
        assertEquals(new ScrBinary("1111111001000101"), testStructure3.subtractToScrBinary(testStructure8));
    }

    @Test
    void multiplicationTest(){
        var testStructure1 = new ScrInt(12451);
        var testStructure2 = new ScrInt(12);
        var testStructure3 = new ScrInt(512);
        var testStructure4 = new ScrFloat(145.7);
        var testStructure5 = new ScrFloat(12354.5372);
        var testStructure6 = new ScrFloat(0.5);
        var testStructure7 = new ScrBinary("0000000110100100");
        var testStructure8 = new ScrBinary("0000000001000101");
        assertEquals(new ScrInt(5040), int1.multiply(testStructure2));
        assertEquals(new ScrInt(5040), testStructure2.mulAScrInt(int1));
        assertEquals(new ScrInt(6374912), testStructure3.mulAScrInt(testStructure1));
        assertEquals(new ScrInt(35328), int2.mulAScrInt(testStructure3));
        assertEquals(new ScrFloat(12*145.7), testStructure2.multiply(testStructure4));
        assertEquals(new ScrFloat(6325523.0464), testStructure3.mulAScrFloat(testStructure5));
        assertEquals(new ScrFloat(210.0), int1.mulAScrFloat(testStructure6));
        assertEquals(new ScrBinary("1000101000000000"), testStructure3.multiplyAScrBinary(testStructure8));
    }

    @Test
    void divisionTest(){
        var testStructure1 = new ScrInt(12451);
        var testStructure2 = new ScrInt(12);
        var testStructure3 = new ScrInt(512);
        var testStructure4 = new ScrFloat(145.7);
        var testStructure6 = new ScrFloat(0.4);
        var testStructure7 = new ScrBinary("0000000110100100");
        var testStructure8 = new ScrBinary("0000000001000101");
        var testStructure9 = new ScrBinary("1001001010000111");
        assertEquals(new ScrInt(35), int1.divide(testStructure2));
        assertEquals(new ScrInt(35), testStructure2.divideAScrInt(int1));
        assertEquals(new ScrInt(24), testStructure3.divideAScrInt(testStructure1));
        assertEquals(new ScrInt(7), int2.divideAScrInt(testStructure3));
        assertEquals(new ScrFloat(172.5), int2.divide(testStructure6));
        assertEquals(new ScrFloat(0.2845703125), testStructure3.divideAScrFloat(testStructure4));
        assertEquals(new ScrBinary("0000000000000001"), int1.divideAScrBinary(testStructure7));
        assertEquals(new ScrBinary("1111111111111110"), testStructure1.divideAScrBinary(testStructure9));
        assertEquals(new ScrBinary("0000000000000000"), testStructure3.divideAScrBinary(testStructure8));
    }

}
