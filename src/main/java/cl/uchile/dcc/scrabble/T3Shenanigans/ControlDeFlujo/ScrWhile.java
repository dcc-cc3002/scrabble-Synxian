package cl.uchile.dcc.scrabble.T3Shenanigans.ControlDeFlujo;

import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;
import cl.uchile.dcc.scrabble.AST.TreeNodes;
import cl.uchile.dcc.scrabble.MemoryOpFactory.TypesFactory.ScrTypesFactory;

/**
 * Class that handles the while loop for scrabble
 */
public class ScrWhile implements TreeNodes {
    /**
     * this can be a tree, but at the end it must result in a nodeBool
     */
    private TreeNodes condition;

    private TreeNodes doThis;

    /**
     * the constructor method of the loop
     * @param condition the condition under the while will continue looping
     * @param doThis the instruction for the loop
     */
    public ScrWhile(TreeNodes condition, TreeNodes doThis){
        this.condition=condition;
        this.doThis=doThis;
    }


    /**
     * Executes the instruction while the condition is meet
     * @return nothing, it just executes the instruction
     */
    @Override
    public ScrNode eval() {
        while(condition.eval().getValue().equals(ScrTypesFactory.getScrBoolFlyweight(true))){
            this.doThis.eval();
        }
        return null;
    }
}
