package cl.uchile.dcc.scrabble.T3Shenanigans;

import cl.uchile.dcc.scrabble.AST.Operations.Igual;
import cl.uchile.dcc.scrabble.AST.Operations.Mayor;
import cl.uchile.dcc.scrabble.AST.Operations.Subtraction;
import cl.uchile.dcc.scrabble.AST.Transformations.Not;
import cl.uchile.dcc.scrabble.MemoryOpFactory.AstFactory.AssignableVariablesFactory;
import cl.uchile.dcc.scrabble.MemoryOpFactory.AstFactory.NodeTypeFactory;
import cl.uchile.dcc.scrabble.T3Shenanigans.ControlDeFlujo.ScrIf;
import cl.uchile.dcc.scrabble.T3Shenanigans.ControlDeFlujo.ScrWhile;
import cl.uchile.dcc.scrabble.types.numbers.ScrInt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EnunciadoTest {
    @Test
    void testDelEnunciado(){
        Seq seq =
                new Seq(
                        new AssignToVariable("a", NodeTypeFactory.getNodeIntFlyweight(10)),
                        new AssignToVariable("b", NodeTypeFactory.getNodeIntFlyweight(5)),
                        new ScrWhile( new Not(new Igual(AssignableVariablesFactory.get("b"), NodeTypeFactory.getNodeIntFlyweight(0))),
                                new ScrIf(new Mayor(AssignableVariablesFactory.get("a"), AssignableVariablesFactory.get("b")),
                                        new AssignToVariable("a", new Subtraction(AssignableVariablesFactory.get("a"),
                                                AssignableVariablesFactory.get("b"))),
                                        new AssignToVariable("b", new Subtraction(AssignableVariablesFactory.get("b"),
                                                AssignableVariablesFactory.get("a")))
                                )
                        )
                );
        seq.eval();
        var a = AssignableVariablesFactory.get("a").getValue();
        var b = AssignableVariablesFactory.get("b").getValue();
        System.out.println(a);
        System.out.println(b);
        Assertions.assertEquals(a,new ScrInt(5));
        Assertions.assertEquals(b,new ScrInt(0));
    }
}
