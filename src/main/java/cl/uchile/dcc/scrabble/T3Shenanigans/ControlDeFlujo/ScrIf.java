package cl.uchile.dcc.scrabble.T3Shenanigans.ControlDeFlujo;

import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;
import cl.uchile.dcc.scrabble.AST.TreeNodes;
import cl.uchile.dcc.scrabble.MemoryOpFactory.AstFactory.NodeTypeFactory;
import cl.uchile.dcc.scrabble.MemoryOpFactory.TypesFactory.ScrTypesFactory;


/**
 * Class that handles the if condition for scrabble
 */
public class ScrIf implements TreeNodes {
    /**
     * this can be a tree, but at the end it must result in a nodeBool
     */
    private TreeNodes condition;

    private TreeNodes doThis;

    private TreeNodes elseDo;

    /**
     * the constructor method of the conditional
     * @param condition the condition to check which instruction to execute
     * @param doThis the instruction to be executed if the condition is met
     * @param elseDo the instruction to be executed if the condition isn't met
     */
    public ScrIf(TreeNodes condition, TreeNodes doThis, TreeNodes elseDo){
        this.condition=condition;
        this.doThis=doThis;
        this.elseDo=elseDo;
    }


    /**
     * evaluates the doThis Ast if the condition is met, otherwise, it evaluates the elseDo Ast
     * @return nothing, it just executes the instruction
     */
    @Override
    public ScrNode eval() {
        if(condition.eval().getValue().equals(ScrTypesFactory.getScrBoolFlyweight(true))){
           this.doThis.eval();
        }
        else {
            this.elseDo.eval();
        }
        return null;
    }
}
