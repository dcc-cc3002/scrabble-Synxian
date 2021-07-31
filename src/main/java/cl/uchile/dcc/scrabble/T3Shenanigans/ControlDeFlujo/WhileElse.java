package cl.uchile.dcc.scrabble.T3Shenanigans.ControlDeFlujo;

import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;
import cl.uchile.dcc.scrabble.AST.TreeNodes;
import cl.uchile.dcc.scrabble.MemoryOpFactory.TypesFactory.ScrTypesFactory;

/**
 * Class that handles the while-else loop for scrabble
 */
public class WhileElse implements TreeNodes {
    /**
     * this can be a tree, but at the end it must result in a nodeBool
     */
    private TreeNodes condition;

    private TreeNodes doThis;

    private TreeNodes elseDo;

    /**
     * the constructor method of the loop
     * @param condition the condition under the while will continue looping
     * @param doThis the instruction for the loop
     * @param elseDo what to do if the while condition isn't met/stop being true
     */
    public WhileElse(TreeNodes condition, TreeNodes doThis, TreeNodes elseDo){
        this.condition=condition;
        this.doThis=doThis;
        this.elseDo=elseDo;
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
        return v.visitorWhileElse(this);
    }

    /**
     * Getter of the condition to be executed while the condition is met
     * @return the condition to be executed while the condition is met
     */
    public TreeNodes getDoThis() {
        return doThis;
    }

    /**
     * Getter for the condition under which the loop continues active
     * @return the condition under which the loop continues active
     */
    public TreeNodes getCondition() {
        return condition;
    }

    /**
     * Getter for the instruction to be executed when the while stops being executed/even if it's not executed
     * @return the instruction to be executed when the while stops being executed/even if it's not executed
     */
    public TreeNodes getElseDo() {
        return elseDo;
    }
}
