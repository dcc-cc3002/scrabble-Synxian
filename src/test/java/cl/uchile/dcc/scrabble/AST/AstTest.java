package cl.uchile.dcc.scrabble.AST;


import cl.uchile.dcc.scrabble.AST.Operations.*;
import cl.uchile.dcc.scrabble.AST.Transformations.*;
import cl.uchile.dcc.scrabble.MemoryOpFactory.AstFactory.AssignableVariablesFactory;
import cl.uchile.dcc.scrabble.MemoryOpFactory.AstFactory.NodeTypeFactory;

import cl.uchile.dcc.scrabble.types.SType;
import cl.uchile.dcc.scrabble.types.numbers.ScrBinary;
import cl.uchile.dcc.scrabble.types.numbers.ScrFloat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AstTest {
    @Test
    void Test1(){
        var a= new toNodeBinaryC(
                new Subtraction(NodeTypeFactory.getNodeIntFlyweight(25)
                        ,
                        NodeTypeFactory.getNodeBinaryFlyweight("0000000000001000")
                )

        );
        SType b=a.getValue();
        assertEquals("0000000000010001", b.toString());
    }

    @Test
    void Test2(){
        var ast= new Addition(
            new toNodeInt(
                    new Or(NodeTypeFactory.getNodeBinaryFlyweight("0000000000001000")
                            ,
                           new toNodeBinaryC(
                            new Subtraction(NodeTypeFactory.getNodeIntFlyweight(25)
                                   ,
                                   NodeTypeFactory.getNodeBinaryFlyweight("0000000000000101")
                            )

                    )
                    )
            ),
            NodeTypeFactory.getNodeFloatFlyweight(6.9)
        );
        SType b=ast.getValue();
        assertEquals(new ScrFloat(34.9), b);
    }

    @Test
    void Test3(){
        var ast= new And(
                new Not(NodeTypeFactory.getNodeBoolFlyweight(true))
                ,
                new Not(NodeTypeFactory.getNodeBinaryFlyweight("1111111111111111"))
        );
        SType b=ast.getValue();
        assertEquals(new ScrBinary("0000000000000000"), b);

        var ast2=new Addition(
                new toNodeString(
                NodeTypeFactory.getNodeIntFlyweight(783)
        )
                ,
                NodeTypeFactory.getNodeStringFlyweight("The cake is a lie")
                );
        SType c=ast2.getValue();
        assertEquals("783The cake is a lie", c.toString());

        var notT=new Not(NodeTypeFactory.getNodeBoolFlyweight(true));
        var d=notT.eval().getValue().toString();
        assertEquals("false",d);
        assertEquals("false",notT.getValue().toString());
    }
    @Test
    void TestNulls(){
        var nulld0=new Division(
                NodeTypeFactory.getNodeBoolFlyweight(true),
                NodeTypeFactory.getNodeIntFlyweight(12)
        );
        var nulld1=new Division(
                NodeTypeFactory.getNodeIntFlyweight(12) ,
                NodeTypeFactory.getNodeBoolFlyweight(true)
        );
        var nulld2=new Division(
                NodeTypeFactory.getNodeFloatFlyweight(13.0) ,
                NodeTypeFactory.getNodeBoolFlyweight(true)
        );
        var nulld3=new Division(
                NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000"),
                NodeTypeFactory.getNodeBoolFlyweight(true)
        );
        var nullm0=new Multiplication(
                NodeTypeFactory.getNodeBoolFlyweight(true)
                , NodeTypeFactory.getNodeIntFlyweight(12)
        );
        var nullm1=new Multiplication(
                NodeTypeFactory.getNodeIntFlyweight(12)
                ,NodeTypeFactory.getNodeBoolFlyweight(true)
        );
        var nullm2=new Multiplication(
                NodeTypeFactory.getNodeFloatFlyweight(13.0)
                ,NodeTypeFactory.getNodeBoolFlyweight(true)
        );
        var nullm3=new Multiplication(
                NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000")
                ,NodeTypeFactory.getNodeBoolFlyweight(true)
        );
        var nullA0=new Addition(
                NodeTypeFactory.getNodeBoolFlyweight(true)
                , NodeTypeFactory.getNodeIntFlyweight(12)
        );
        var nullA1=new Addition(
                NodeTypeFactory.getNodeIntFlyweight(12)
                ,NodeTypeFactory.getNodeBoolFlyweight(true)
        );
        var nullA2=new Addition(
                NodeTypeFactory.getNodeFloatFlyweight(13.0) ,
                NodeTypeFactory.getNodeBoolFlyweight(true)
        );
        var nullA3=new Addition(
                NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000")
                ,NodeTypeFactory.getNodeBoolFlyweight(true)
        );
        var nulls0=new Subtraction(
                NodeTypeFactory.getNodeBoolFlyweight(true)
                ,NodeTypeFactory.getNodeIntFlyweight(12)
        );
        var nulls1=new Subtraction(
                NodeTypeFactory.getNodeIntFlyweight(12)
                ,NodeTypeFactory.getNodeBoolFlyweight(true)
        );
        var nulls2=new Subtraction(
                NodeTypeFactory.getNodeFloatFlyweight(13.0)
                ,NodeTypeFactory.getNodeBoolFlyweight(true)
        );
        var nulls3=new Subtraction(
                NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000")
                ,NodeTypeFactory.getNodeBoolFlyweight(true)
        );
        var toNode1=new toNodeInt(NodeTypeFactory.getNodeBoolFlyweight(true));
        var toNode3=new toNodeBinaryC(NodeTypeFactory.getNodeBoolFlyweight(true));
        var toNode4=new toNodeBool(NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000"));
        var toNode5=new toNodeFloat(NodeTypeFactory.getNodeBoolFlyweight(true));

        var LogicNull1= new And(NodeTypeFactory.getNodeBoolFlyweight(true),
                NodeTypeFactory.getNodeIntFlyweight(12)
        );
        var LogicNull2= new And(NodeTypeFactory.getNodeIntFlyweight(12),
                NodeTypeFactory.getNodeBoolFlyweight(true)
        );
        var LogicNull3= new Or(NodeTypeFactory.getNodeBoolFlyweight(true),
                NodeTypeFactory.getNodeIntFlyweight(12)
        );
        var LogicNull4= new Or(NodeTypeFactory.getNodeIntFlyweight(12),
                NodeTypeFactory.getNodeBoolFlyweight(true)
        );
        var LogicNull5= new And(NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000"),
                NodeTypeFactory.getNodeIntFlyweight(12)
        );
        var LogicNull6= new Or(NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000"),
                NodeTypeFactory.getNodeIntFlyweight(12)
        );
        var LogicNull7= new Not(NodeTypeFactory.getNodeIntFlyweight(12)
        );

        assertNull(nulld0.eval());
        assertNull(nulld1.eval());
        assertNull(nulld2.eval());
        assertNull(nulld3.eval());
        assertNull(nullm0.eval());
        assertNull(nullm1.eval());
        assertNull(nullm2.eval());
        assertNull(nullm3.eval());
        assertNull(nullA0.eval());
        assertNull(nullA1.eval());
        assertNull(nullA2.eval());
        assertNull(nullA3.eval());
        assertNull(nulls0.eval());
        assertNull(nulls1.eval());
        assertNull(nulls2.eval());
        assertNull(nulls3.eval());
        assertNull(toNode1.eval());
        assertNull(toNode3.eval());
        assertNull(toNode4.eval());
        assertNull(toNode5.eval());
        assertNull(LogicNull1.eval());
        assertNull(LogicNull2.eval());
        assertNull(LogicNull3.eval());
        assertNull(LogicNull4.eval());
        assertNull(LogicNull5.eval());
        assertNull(LogicNull6.eval());
        assertNull(LogicNull7.eval());

    }

    @Test
    void transformationTest(){
        var t1=new toNodeInt(NodeTypeFactory.getNodeIntFlyweight(12));
        var t2=new toNodeInt(NodeTypeFactory.getNodeFloatFlyweight(12.0));
        var t3=new toNodeInt(NodeTypeFactory.getNodeBinaryFlyweight("000000000000"));
        var t4=new toNodeFloat(NodeTypeFactory.getNodeIntFlyweight(12));
        var t5=new toNodeFloat(NodeTypeFactory.getNodeFloatFlyweight(12.0));
        var t6=new toNodeBool(NodeTypeFactory.getNodeBoolFlyweight(true));
        var t7=new toNodeBinaryC(NodeTypeFactory.getNodeBinaryFlyweight("000000000000"));
        var t8=new toNodeFloat(NodeTypeFactory.getNodeBinaryFlyweight("000000000000"));
        assertEquals(NodeTypeFactory.getNodeIntFlyweight(12).eval(), t1.eval());
        assertNull(t2.eval());
        assertEquals(NodeTypeFactory.getNodeIntFlyweight(0).eval(), t3.eval());
        assertEquals(NodeTypeFactory.getNodeFloatFlyweight(12.0).eval(),t4.eval());
        assertEquals(NodeTypeFactory.getNodeFloatFlyweight(12.0).eval(),t5.eval());
        assertEquals(NodeTypeFactory.getNodeBoolFlyweight(true).eval(),t6.eval());
        assertEquals(NodeTypeFactory.getNodeBinaryFlyweight("000000000000"),t7.eval());
        assertEquals(NodeTypeFactory.getNodeFloatFlyweight(0.0).eval(), t8.eval());
    }

    @Test
    void operationTest(){
        var a1=new Addition(
                NodeTypeFactory.getNodeIntFlyweight(0)
                ,
                NodeTypeFactory.getNodeIntFlyweight(12)
                        );
        var a2=new Addition(
                NodeTypeFactory.getNodeFloatFlyweight(12.0)
                ,
                NodeTypeFactory.getNodeIntFlyweight(0)
        );
        var a3=new Addition(
                NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000")
                ,
                NodeTypeFactory.getNodeIntFlyweight(0)
        );
        var a4=new Addition(
                NodeTypeFactory.getNodeFloatFlyweight(12.0)
                ,
                NodeTypeFactory.getNodeFloatFlyweight(0.0)
        );
        var a5=new Addition(
                NodeTypeFactory.getNodeIntFlyweight(0)
                ,
                NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000")
        );
        var a6=new Addition(
                NodeTypeFactory.getNodeFloatFlyweight(12.0)
                ,
                NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000")
        );
        var a7=new Addition(
                NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000")
                ,
                NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000")
        );
        var s1=new Subtraction(
                NodeTypeFactory.getNodeIntFlyweight(0)
                ,
                NodeTypeFactory.getNodeIntFlyweight(12)
        );
        var s2=new Subtraction(
                NodeTypeFactory.getNodeFloatFlyweight(12.0)
                ,
                NodeTypeFactory.getNodeIntFlyweight(0)
        );
        var s3=new Subtraction(
                NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000")
                ,
                NodeTypeFactory.getNodeIntFlyweight(0)
        );
        var s4=new Subtraction(
                NodeTypeFactory.getNodeFloatFlyweight(12.0)
                ,
                NodeTypeFactory.getNodeFloatFlyweight(0.0)
        );
        var s5=new Subtraction(
                NodeTypeFactory.getNodeIntFlyweight(0)
                ,
                NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000")
        );
        var s6=new Subtraction(
                NodeTypeFactory.getNodeFloatFlyweight(12.0)
                ,
                NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000")
        );
        var s7=new Subtraction(
                NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000")
                ,
                NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000")
        );
        var S8=new Subtraction(NodeTypeFactory.getNodeIntFlyweight(0)
                ,
                NodeTypeFactory.getNodeFloatFlyweight(12.0)

        );
        assertEquals(NodeTypeFactory.getNodeIntFlyweight(12).eval(),a1.eval());
        assertEquals(NodeTypeFactory.getNodeFloatFlyweight(12.0).eval(),a2.eval());
        assertEquals(NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000").eval(),a3.eval());
        assertEquals(NodeTypeFactory.getNodeFloatFlyweight(12.0),a4.eval());
        assertEquals(NodeTypeFactory.getNodeIntFlyweight(0),a5.eval());
        assertEquals(NodeTypeFactory.getNodeFloatFlyweight(12.0),a6.eval());
        assertEquals(NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000"),a7.eval());
        assertEquals(NodeTypeFactory.getNodeIntFlyweight(-12).eval(),s1.eval());
        assertEquals(NodeTypeFactory.getNodeFloatFlyweight(12.0).eval(),s2.eval());
        assertEquals(NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000").eval(),s3.eval());
        assertEquals(NodeTypeFactory.getNodeFloatFlyweight(12.0), s4.eval());
        assertEquals(NodeTypeFactory.getNodeIntFlyweight(0),s5.eval());
        assertEquals(NodeTypeFactory.getNodeFloatFlyweight(12.0),s6.eval());
        assertEquals(NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000"),s7.eval());
        assertEquals(NodeTypeFactory.getNodeFloatFlyweight(-12.0).eval(), S8.eval());
    }

    @Test
    void moreOperationsTest(){
        var a1=new Multiplication(
                NodeTypeFactory.getNodeIntFlyweight(0)
                ,
                NodeTypeFactory.getNodeIntFlyweight(12)
        );
        var anew=new Multiplication(
                NodeTypeFactory.getNodeIntFlyweight(0)
                ,
                NodeTypeFactory.getNodeFloatFlyweight(12.0)
        );
        var a2=new Multiplication(
                NodeTypeFactory.getNodeFloatFlyweight(12.0)
                ,
                NodeTypeFactory.getNodeIntFlyweight(0)
        );
        var a3=new Multiplication(
                NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000")
                ,
                NodeTypeFactory.getNodeIntFlyweight(0)
        );
        var a4=new Multiplication(
                NodeTypeFactory.getNodeFloatFlyweight(12.0)
                ,
                NodeTypeFactory.getNodeFloatFlyweight(0.0)
        );
        var a5=new Multiplication(
                NodeTypeFactory.getNodeIntFlyweight(0)
                ,
                NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000")
        );
        var a6=new Multiplication(
                NodeTypeFactory.getNodeFloatFlyweight(12.0)
                ,
                NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000")
        );
        var a7=new Multiplication(
                NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000")
                ,
                NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000")
        );
        var s1=new Division(
                NodeTypeFactory.getNodeIntFlyweight(0)
                ,
                NodeTypeFactory.getNodeIntFlyweight(12)
        );
        var s2=new Division(
                NodeTypeFactory.getNodeFloatFlyweight(12.0)
                ,
                NodeTypeFactory.getNodeIntFlyweight(1)
        );
        var s3=new Division(
                NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000")
                ,
                NodeTypeFactory.getNodeIntFlyweight(1)
        );
        var s4=new Division(
                NodeTypeFactory.getNodeFloatFlyweight(12.0)
                ,
                NodeTypeFactory.getNodeFloatFlyweight(2.0)
        );
        var s5=new Division(
                NodeTypeFactory.getNodeIntFlyweight(0)
                ,
                NodeTypeFactory.getNodeBinaryFlyweight("0000001001000001")
        );
        var s6=new Division(
                NodeTypeFactory.getNodeFloatFlyweight(12.0)
                ,
                NodeTypeFactory.getNodeBinaryFlyweight("0000000000000010")
        );
        var s7=new Division(
                NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000")
                ,
                NodeTypeFactory.getNodeBinaryFlyweight("1111111111111111")
        );
        var S8=new Division(NodeTypeFactory.getNodeIntFlyweight(0)
                ,
                NodeTypeFactory.getNodeFloatFlyweight(12.0)

        );
        assertEquals(NodeTypeFactory.getNodeIntFlyweight(0).eval(),a1.eval());
        assertEquals(NodeTypeFactory.getNodeFloatFlyweight(0.0).eval(),a2.eval());
        assertEquals(NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000").eval(),a3.eval());
        assertEquals(NodeTypeFactory.getNodeFloatFlyweight(0.0),a4.eval());
        assertEquals(NodeTypeFactory.getNodeIntFlyweight(0),a5.eval());
        assertEquals(NodeTypeFactory.getNodeFloatFlyweight(0.0),a6.eval());
        assertEquals(NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000"),a7.eval());
        assertEquals(NodeTypeFactory.getNodeIntFlyweight(0).eval(),s1.eval());
        assertEquals(NodeTypeFactory.getNodeFloatFlyweight(12.0).eval(),s2.eval());
        assertEquals(NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000").eval(),s3.eval());
        assertEquals(NodeTypeFactory.getNodeFloatFlyweight(6.0), s4.eval());
        assertEquals(NodeTypeFactory.getNodeIntFlyweight(0),s5.eval());
        assertEquals(NodeTypeFactory.getNodeFloatFlyweight(6.0),s6.eval());
        assertEquals(NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000"),s7.eval());
        assertEquals(NodeTypeFactory.getNodeFloatFlyweight(0.0/12.0).eval(), S8.eval());
        assertEquals(NodeTypeFactory.getNodeFloatFlyweight(0).eval(),anew.eval());

    }

    @Test
    void variableAssignTest(){
        AssignableVariablesFactory.get("the");
        AssignableVariablesFactory.get("cake");
        AssignableVariablesFactory.get("is");
        AssignableVariablesFactory.get("a");
        AssignableVariablesFactory.get("lie");
        AssignableVariablesFactory.setAssignableNodeBinary("the", "1111111111111111");
        AssignableVariablesFactory.setAssignableNodeFloat("cake", 12.12);
        AssignableVariablesFactory.setAssignableNodeInt("is",15);
        AssignableVariablesFactory.setAssignableNodeString("a", "great offer");
        AssignableVariablesFactory.setAssignableNodeBool("lie", true);

        assertEquals(NodeTypeFactory.getNodeBinaryFlyweight("1111111111111111"),AssignableVariablesFactory.get("the").eval());
        assertEquals(NodeTypeFactory.getNodeFloatFlyweight(12.12),AssignableVariablesFactory.get("cake").eval());
        assertEquals(NodeTypeFactory.getNodeIntFlyweight(15),AssignableVariablesFactory.get("is").eval());
        assertEquals(NodeTypeFactory.getNodeStringFlyweight("great offer"),AssignableVariablesFactory.get("a").eval());
        assertEquals(NodeTypeFactory.getNodeBoolFlyweight(true),AssignableVariablesFactory.get("lie").eval());
        AssignableVariablesFactory.setAssignableNodeFloat("cake", 12.13);
        assertEquals(NodeTypeFactory.getNodeFloatFlyweight(12.13),AssignableVariablesFactory.get("cake").eval());

    }

    @Test
    void finalTest(){
        var a1=new Or(NodeTypeFactory.getNodeBoolFlyweight(true),
                NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000"));
        var a2= new And(NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000"),
                NodeTypeFactory.getNodeBinaryFlyweight("1111111111111111"));
        var a3=new Or(NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000"),
                NodeTypeFactory.getNodeBoolFlyweight(true));
        var a4=new Or(NodeTypeFactory.getNodeBoolFlyweight(true),
                NodeTypeFactory.getNodeBoolFlyweight(true));
        var a5= new And(NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000"),
                NodeTypeFactory.getNodeBoolFlyweight(true));
        var a6=new And(NodeTypeFactory.getNodeBoolFlyweight(false),
                NodeTypeFactory.getNodeBoolFlyweight(true));
        assertEquals(NodeTypeFactory.getNodeBinaryFlyweight("1111111111111111").eval(),a1.eval());
        assertEquals(NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000").eval(),a2.eval());
        assertEquals(NodeTypeFactory.getNodeBinaryFlyweight("1111111111111111").eval(),a3.eval());
        assertEquals(NodeTypeFactory.getNodeBoolFlyweight(true).eval(),a4.eval());
        assertEquals(NodeTypeFactory.getNodeBinaryFlyweight("0000000000000000").eval(),a5.eval());
        assertEquals(NodeTypeFactory.getNodeBoolFlyweight(false).eval(),a6.eval());
    }
}
