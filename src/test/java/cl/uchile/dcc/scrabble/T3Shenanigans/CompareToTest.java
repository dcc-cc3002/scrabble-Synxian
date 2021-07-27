package cl.uchile.dcc.scrabble.T3Shenanigans;

import cl.uchile.dcc.scrabble.AST.Nodes.*;
import cl.uchile.dcc.scrabble.types.ScrBool;
import cl.uchile.dcc.scrabble.types.ScrString;
import cl.uchile.dcc.scrabble.types.numbers.ScrBinary;
import cl.uchile.dcc.scrabble.types.numbers.ScrFloat;
import cl.uchile.dcc.scrabble.types.numbers.ScrInt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CompareToTest {
    @Test
    void compareIntTest(){
        var testStructure1 = new NodeInt(new ScrInt(12));
        var testStructure2 = new NodeFloat(new ScrFloat(145.7));
        var testStructure5 =  new NodeBinary(new ScrBinary("1001001010000111"));
        assertEquals(testStructure1.compareToInt(testStructure1),0);
        assertEquals(testStructure1.compareToBinary(testStructure5),-1);
        assertEquals(testStructure1.compareToFloat(testStructure2),1);
    }

    @Test
    void compareFloatTest(){
        var testStructure1 = new NodeInt(new ScrInt(12));
        var testStructure2 = new NodeFloat(new ScrFloat(145.7));
        var testStructure5 =  new NodeBinary(new ScrBinary("1001001010000111"));
        assertEquals(testStructure2.compareToFloat(testStructure2),0);
        assertEquals(testStructure2.compareToBinary(testStructure5),-1);
        assertEquals(testStructure2.compareToInt(testStructure1),-1);
    }

    @Test
    void compareBinaryTest(){
        var testStructure1 = new NodeInt(new ScrInt(12));
        var testStructure2 = new NodeFloat(new ScrFloat(145.7));
        var testStructure5 =  new NodeBinary(new ScrBinary("1001001010000111"));
        assertEquals(testStructure5.compareToInt(testStructure1),1);
        assertEquals(testStructure5.compareToBinary(testStructure5),0);
        assertEquals(testStructure5.compareToFloat(testStructure2),1);
    }
    @Test
    void compareBoolTest(){
        var testStructure1 = new NodeBool(new ScrBool(true));
        var testStructure2 = new NodeBool(new ScrBool(false));
        var testStructure3 = new NodeString(new ScrString("hola"));
        assertEquals(testStructure1.compareTo(testStructure1),0);
        assertEquals(testStructure1.compareToBool(testStructure2),-1);
        assertEquals(testStructure2.compareToBool(testStructure1),1);
        assertNull(testStructure1.compareToString(testStructure3));
    }

    @Test
    void compareStringTest(){
        var testStructure1 = new NodeString(new ScrString("hola"));
        var testStructure2 = new NodeString(new ScrString("holas"));
        var testStructure3 =  new NodeBinary(new ScrBinary("1001001010000111"));
        var testStructure4 = new NodeInt(new ScrInt(12));
        var testStructure5 = new NodeFloat(new ScrFloat(145.7));
        var testStructure6 = new NodeBool(new ScrBool(false));
        assertEquals(testStructure1.compareTo(testStructure1),0);
        assertEquals(testStructure1.compareToString(testStructure2),1);
        assertEquals(testStructure2.compareToString(testStructure1),-1);
        assertNull(testStructure1.compareToFloat(testStructure5));
        assertNull(testStructure1.compareToInt(testStructure4));
        assertNull(testStructure1.compareToBinary(testStructure3));
        assertNull(testStructure1.compareToBool(testStructure6));
    }
}
