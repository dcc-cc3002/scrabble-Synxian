package cl.uchile.dcc.scrabble.T3Shenanigans;

import cl.uchile.dcc.scrabble.AST.Nodes.NodeBinary;
import cl.uchile.dcc.scrabble.AST.Nodes.NodeInt;
import cl.uchile.dcc.scrabble.AST.Operations.Mayor;
import cl.uchile.dcc.scrabble.AST.Operations.MayorIgual;
import cl.uchile.dcc.scrabble.AST.Operations.Menor;
import cl.uchile.dcc.scrabble.AST.Operations.MenorIgual;
import cl.uchile.dcc.scrabble.MemoryOpFactory.AstFactory.NodeTypeFactory;
import cl.uchile.dcc.scrabble.types.numbers.ScrBinary;
import cl.uchile.dcc.scrabble.types.numbers.ScrInt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparisonTest {
    @Test
    void mayorQueTest(){
        var test1=new Mayor(new NodeBinary(new ScrBinary("000000000000")), new NodeInt(new ScrInt( -1))).eval();
        var test2=new Mayor(new NodeBinary(new ScrBinary("000000000000")), new NodeInt(new ScrInt( 1))).eval();
        assertEquals(test1, NodeTypeFactory.getNodeBoolFlyweight(true));
        assertEquals(test2, NodeTypeFactory.getNodeBoolFlyweight(false));
    }

    @Test
    void mayorIgualTest(){
        var test1=new MayorIgual(new NodeBinary(new ScrBinary("000000000000")), new NodeInt(new ScrInt( -1))).eval();
        var test2=new MayorIgual(new NodeBinary(new ScrBinary("000000000000")), new NodeInt(new ScrInt( 1))).eval();
        var test3=new MayorIgual(new NodeBinary(new ScrBinary("000000000000")), new NodeInt(new ScrInt( 0))).eval();
        assertEquals(test1, NodeTypeFactory.getNodeBoolFlyweight(true));
        assertEquals(test2, NodeTypeFactory.getNodeBoolFlyweight(false));
        assertEquals(test3, NodeTypeFactory.getNodeBoolFlyweight(true));
    }

    @Test
    void menorQueTest(){
        var test1=new Menor(new NodeBinary(new ScrBinary("000000000000")), new NodeInt(new ScrInt( -1))).eval();
        var test2=new Menor(new NodeBinary(new ScrBinary("000000000000")), new NodeInt(new ScrInt( 1))).eval();
        assertEquals(test1, NodeTypeFactory.getNodeBoolFlyweight(false));
        assertEquals(test2, NodeTypeFactory.getNodeBoolFlyweight(true));
    }

    @Test
    void menorIgualTest(){
        var test1=new MenorIgual(new NodeBinary(new ScrBinary("000000000000")), new NodeInt(new ScrInt( -1))).eval();
        var test2=new MenorIgual(new NodeBinary(new ScrBinary("000000000000")), new NodeInt(new ScrInt( 1))).eval();
        var test3=new MenorIgual(new NodeBinary(new ScrBinary("000000000000")), new NodeInt(new ScrInt( 0))).eval();
        assertEquals(test1, NodeTypeFactory.getNodeBoolFlyweight(false));
        assertEquals(test2, NodeTypeFactory.getNodeBoolFlyweight(true));
        assertEquals(test3, NodeTypeFactory.getNodeBoolFlyweight(true));
    }
}
