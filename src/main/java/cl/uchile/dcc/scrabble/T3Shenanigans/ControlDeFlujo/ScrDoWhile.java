package cl.uchile.dcc.scrabble.T3Shenanigans.ControlDeFlujo;

import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;
import cl.uchile.dcc.scrabble.AST.TreeNodes;
import cl.uchile.dcc.scrabble.MemoryOpFactory.TypesFactory.ScrTypesFactory;

/**
 * Class that handles the Do-while loop for scrabble
 */
public class ScrDoWhile implements TreeNodes{
    /**
     * this can be a tree, but at the end it must result in a nodeBool
     */
    private TreeNodes condition;

    private TreeNodes doThis;

    /**
     * the constructor method of the loop
     * @param condition the condition under the while will continue looping
     * @param doThis the instruction for the loop, it will be executed once no matter what
     */
    public ScrDoWhile(TreeNodes condition, TreeNodes doThis){
        this.condition=condition;
        this.doThis=doThis;
    }

    /**
     * creates the visitor object and then sends it to the accept method in this class
     * @return nothing, it sends the instruction to the accept class
     */
    @Override
    public ScrNode eval() {
        Visitor visitor= new Visitor();
        return this.accept(visitor);
    }

    /**
     * Sends to the visitor class
     * @param v the visitor object
     * @return it will be nothing, but the action will be executed by the visitor
     */
    public ScrNode accept(Visitor v){
        return v.visitorDoWhile(this);
    }

    /**
     * Getter of the condition to be executed while the condition is met/at least once, even if the condition is never met
     * @return the condition to be executed
     */
    public TreeNodes getDoThis() {
        return doThis;
    }

    /**
     * Getter of the condition under which the loop continues active
     * @return the condition under which the loop continues active
     */
    public TreeNodes getCondition() {
        return condition;
    }
}
