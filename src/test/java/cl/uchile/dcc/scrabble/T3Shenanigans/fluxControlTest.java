package cl.uchile.dcc.scrabble.T3Shenanigans;

import cl.uchile.dcc.scrabble.AST.Operations.Addition;
import cl.uchile.dcc.scrabble.AST.Operations.Mayor;
import cl.uchile.dcc.scrabble.AST.Operations.Menor;
import cl.uchile.dcc.scrabble.MemoryOpFactory.AstFactory.AssignableVariablesFactory;
import cl.uchile.dcc.scrabble.MemoryOpFactory.AstFactory.NodeTypeFactory;
import cl.uchile.dcc.scrabble.T3Shenanigans.ControlDeFlujo.*;
import cl.uchile.dcc.scrabble.types.numbers.ScrInt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class fluxControlTest {
    @Test
    void whileTest(){
        new AssignToVariable("x", NodeTypeFactory.getNodeIntFlyweight(0)).eval();
        new ScrWhile(new Menor(AssignableVariablesFactory.get("x"), NodeTypeFactory.getNodeIntFlyweight(5)),
                new AssignToVariable("x",new Addition(AssignableVariablesFactory.get("x"), NodeTypeFactory.getNodeIntFlyweight(1)))).eval();
        assertEquals(new ScrInt(5), AssignableVariablesFactory.get("x").getValue());

        new AssignToVariable("x", NodeTypeFactory.getNodeIntFlyweight(0)).eval();
        new ScrWhile(new Mayor(AssignableVariablesFactory.get("x"), NodeTypeFactory.getNodeIntFlyweight(5)),
                new AssignToVariable("x",new Addition(AssignableVariablesFactory.get("x"), NodeTypeFactory.getNodeIntFlyweight(1)))).eval();
        assertEquals(new ScrInt(0), AssignableVariablesFactory.get("x").getValue());
    }

    @Test
    void doWhileTest(){
        new AssignToVariable("x", NodeTypeFactory.getNodeIntFlyweight(0)).eval();
        new ScrDoWhile(new Mayor(AssignableVariablesFactory.get("x"), NodeTypeFactory.getNodeIntFlyweight(5)),
                new AssignToVariable("x",new Addition(AssignableVariablesFactory.get("x"), NodeTypeFactory.getNodeIntFlyweight(1)))).eval();
        assertEquals(new ScrInt(1), AssignableVariablesFactory.get("x").getValue());

        new AssignToVariable("x", NodeTypeFactory.getNodeIntFlyweight(0)).eval();
        new ScrDoWhile(new Menor(AssignableVariablesFactory.get("x"), NodeTypeFactory.getNodeIntFlyweight(5)),
                new AssignToVariable("x",new Addition(AssignableVariablesFactory.get("x"), NodeTypeFactory.getNodeIntFlyweight(1)))).eval();
        assertEquals(new ScrInt(5), AssignableVariablesFactory.get("x").getValue());
    }

    @Test
    void ifTest(){
        new ScrIf(NodeTypeFactory.getNodeBoolFlyweight(true),
                new AssignToVariable("x", NodeTypeFactory.getNodeIntFlyweight(12)),
                new AssignToVariable("x", NodeTypeFactory.getNodeIntFlyweight(11))).eval();
        assertEquals(new ScrInt(12), AssignableVariablesFactory.get("x").getValue());
        new ScrIf(NodeTypeFactory.getNodeBoolFlyweight(false),
                new AssignToVariable("x", NodeTypeFactory.getNodeIntFlyweight(12)),
                new AssignToVariable("x", NodeTypeFactory.getNodeIntFlyweight(11))).eval();
        assertEquals(new ScrInt(11), AssignableVariablesFactory.get("x").getValue());

    }

    @Test
    void whileElseTest(){
        new AssignToVariable("x", NodeTypeFactory.getNodeIntFlyweight(0)).eval();
        new WhileElse(new Menor(AssignableVariablesFactory.get("x"), NodeTypeFactory.getNodeIntFlyweight(5)),
                new AssignToVariable("x",new Addition(AssignableVariablesFactory.get("x"), NodeTypeFactory.getNodeIntFlyweight(1))),
                new AssignToVariable("y",NodeTypeFactory.getNodeIntFlyweight(0))).eval();
        assertEquals(new ScrInt(5), AssignableVariablesFactory.get("x").getValue());
        assertEquals(new ScrInt(0), AssignableVariablesFactory.get("y").getValue());

    }

   @Test
    void forTest(){
        new AssignToVariable("y", NodeTypeFactory.getNodeIntFlyweight(0)).eval();
        new ScrFor(new AssignToVariable("x", NodeTypeFactory.getNodeIntFlyweight(0)),
                new Menor(AssignableVariablesFactory.get("x"), NodeTypeFactory.getNodeIntFlyweight(5)),
                new AssignToVariable("x",new Addition(NodeTypeFactory.getNodeIntFlyweight(1),AssignableVariablesFactory.get("x"))),
                new AssignToVariable("y",new Addition(AssignableVariablesFactory.get("y"), NodeTypeFactory.getNodeIntFlyweight(1)))).eval();
        assertEquals(new ScrInt(5), AssignableVariablesFactory.get("x").getValue());
        assertEquals(new ScrInt(5), AssignableVariablesFactory.get("y").getValue());

    }


}
