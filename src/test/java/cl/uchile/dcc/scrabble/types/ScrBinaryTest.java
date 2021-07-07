package cl.uchile.dcc.scrabble.types;

import cl.uchile.dcc.scrabble.types.numbers.ScrBinary;
import cl.uchile.dcc.scrabble.types.numbers.ScrFloat;
import cl.uchile.dcc.scrabble.types.numbers.ScrInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScrBinaryTest {
    private ScrBinary binary49;
    private ScrBinary binary31;
    String test1 = "0000000000110001";
    String test2 = "0000000000011111";

    @BeforeEach
    void SetUp(){
        binary49=new ScrBinary(test1);
        binary31=new ScrBinary(test2);
    }

    @Test
    void constructorTest(){
        var testStructure1 = new ScrBinary(test1);
        var testStructure2 = new ScrBinary(test2);
        assertEquals(binary49, testStructure1);
        assertEquals(binary31, testStructure2);
        assertNotEquals(binary49, testStructure2);
        assertEquals(binary49.hashCode(), testStructure1.hashCode());
        assertNotEquals(binary31.hashCode(), testStructure1.hashCode());
    }

    @Test
    void toStringTest(){
        assertEquals("0000000000110001", binary49.toString());
        assertEquals("0000000000011111", binary31.toString());
    }

    @Test
    void getValueTest(){
        assertEquals("0000000000110001", binary49.getValue());
        assertEquals("0000000000011111", binary31.getValue());
    }

    @Test
    void toScrStringTest(){
        var testStructure1 = new ScrString("0000000000110001");
        var testStructure2 = new ScrString("0000000000011111");
        assertEquals(testStructure1, binary49.toScrString());
        assertEquals(testStructure2, binary31.toScrString());
    }

    @Test
    void binaryToBinary(){
        assertEquals(binary49, binary49.toScrBinary());
        assertEquals(binary31, binary31.toScrBinary());
    }

    @Test
    void toScrIntTest(){
       assertEquals(new ScrInt(49), binary49.toScrInt());
       assertEquals(new ScrInt(31), binary31.toScrInt());
    }

    @Test
    void toScrFloatTest(){
        assertEquals(new ScrFloat(49.0), binary49.toScrFloat());
        assertEquals(new ScrFloat(31.0), binary31.toScrFloat());
    }

    //Logical operations test
    @Test
    void logicAndTest(){
        var testStructure1 = new ScrBinary("0001011010011010");
        var testStructure2 = new ScrBinary("1111111111111111");
        var testStructure3 = new ScrBool(true);
        var testStructure4 = new ScrBool(false);
        assertEquals(new ScrBinary("0000000000000000"), testStructure2.logicAnd(testStructure4));
        assertEquals(binary31, binary31.andByBool(testStructure3));
        assertEquals(new ScrBinary("0000000000010000"), binary49.logicAnd(testStructure1));
        assertEquals(testStructure1, testStructure1.andByBinary(testStructure2));
    }

    @Test
    void logicOrTest(){
        var testStructure1 = new ScrBinary("0001011010011010");
        var testStructure2 = new ScrBinary("1111111111111111");
        var testStructure3 = new ScrBool(true);
        var testStructure4 = new ScrBool(false);
        assertEquals(testStructure2, testStructure2.logicOr(testStructure4));
        assertEquals(testStructure2, binary31.orByBool(testStructure3));
        assertEquals(new ScrBinary("0001011010111011"), binary49.logicOr(testStructure1));
        assertEquals(testStructure2, testStructure1.orByBinary(testStructure2));
    }

    @Test
    void negationTest(){
        assertEquals(new ScrBinary("1111111111100000"),binary31.neg());
        assertEquals(new ScrBinary("1111111111001110"), binary49.neg());
    }

    //math operations test
    @Test
    void additionTest(){
        var testStructure1 = new ScrInt(1242);
        var testStructure2 = new ScrInt(-281);
        var testStructure3 = new ScrBinary("0000010100100001");//1313
        var testStructure4 = new ScrBinary("1111111001011100");//-420
        assertEquals(new ScrInt(-701), testStructure4.addToScrInt(testStructure2));
        assertEquals(new ScrInt(1242-420), testStructure4.addToScrInt(testStructure1));
        assertEquals(new ScrBinary("0000010101010010"), binary49.addToScrBinary(testStructure3));
        assertEquals(new ScrBinary("1111111001111011"), binary31.addToScrBinary(testStructure4));
    }

    @Test
    void subtractionTest(){
        var testStructure1 = new ScrInt(1242);
        var testStructure2 = new ScrInt(-281);
        var testStructure3 = new ScrBinary("0000010100100001");//1313
        var testStructure4 = new ScrBinary("1111111001011100");//-420
        assertEquals(new ScrInt(139), testStructure4.subtractToScrInt(testStructure2));//-139
        assertEquals(new ScrInt(1662), testStructure4.subtractToScrInt(testStructure1));
        assertEquals(new ScrBinary("0000010011110000"), binary49.subtractToScrBinary(testStructure3));
        assertEquals(new ScrBinary("1111111000111101"), binary31.subtractToScrBinary(testStructure4));
    }

    @Test
    void multiplicationTest(){
        var testStructure1 = new ScrInt(3);
        var testStructure2 = new ScrInt(-28);
        var testStructure4 = new ScrBinary("1111111001011100");//-420
        assertEquals(new ScrInt(-420*-28), testStructure4.multiplyAScrInt(testStructure2));
        assertEquals(new ScrInt(3*-420), testStructure4.multiplyAScrInt(testStructure1));
        assertEquals(new ScrBinary("1010111110011100"), binary49.multiplyAScrBinary(testStructure4));
        assertEquals(new ScrBinary("1100110100100100"), binary31.multiplyAScrBinary(testStructure4));
    }

    @Test
    void divisionTest(){
        var testStructure1 = new ScrInt(3);
        var testStructure2 = new ScrInt(-28);
        var testStructure3 = new ScrBinary("0000000000000010");
        var testStructure4 = new ScrBinary("1111111001011100");//-420
        assertEquals(new ScrInt(0), testStructure4.divideAScrInt(testStructure2));
        assertEquals(new ScrInt(0), testStructure4.divideAScrInt(testStructure1));
        assertEquals(new ScrBinary("1111111111111000"), binary49.divideAScrBinary(testStructure4));
        assertEquals(new ScrBinary("0000000000000000"), binary31.divideAScrBinary(testStructure3));
    }
}
