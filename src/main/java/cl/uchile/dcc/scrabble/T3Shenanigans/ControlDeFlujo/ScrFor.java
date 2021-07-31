package cl.uchile.dcc.scrabble.T3Shenanigans.ControlDeFlujo;

import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;
import cl.uchile.dcc.scrabble.AST.TreeNodes;
import cl.uchile.dcc.scrabble.MemoryOpFactory.TypesFactory.ScrTypesFactory;

/**
 * Class that handles the for loop for scrabble
 */
public class ScrFor implements TreeNodes {
    private TreeNodes init;
    /**
     * this can be a tree, but at the end it must result in a nodeBool
     */
    private TreeNodes stopCondition;
    private TreeNodes increment;
    private TreeNodes doThis;

    /**
     * The constructor method for the loop (very similar to the c initialization of a for loop)
     * @param init the variable to be constantly updated and compared in the condition, expected to be a Node Int or Float
     *             (and maybe binary wink wink)
     * @param condition the condition for the loop, when it stops being true, the for loop is going to end
     * @param increment the increment applied to the init param after each loop, expected to be a Node Int or float
     *                  (once again, it might even accept binary, wink)
     * @param doThis the instruction to be executed
     */
    public ScrFor(TreeNodes init, TreeNodes condition, TreeNodes increment, TreeNodes doThis){
        this.stopCondition=condition;
        this.increment=increment;
        this.doThis=doThis;
        this.init=init;
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
        return v.visitorFor(this);
    }

    /**
     * Getter of the increment for the initial variable that indicates how long the for will stay active
     * @return the increment for the initial variable
     */
    public TreeNodes getIncrement() {
        return increment;
    }

    /**
     * Getter of the initial variable that indicates how long the for will stay active
     * @return the initial variable
     */
    public TreeNodes getInit() {
        return init;
    }

    /**
     * Getter of the condition under which the for will stop
     * @return the condition under which the for will stop
     */
    public TreeNodes getStopCondition() {
        return stopCondition;
    }

    /**
     * Getter fot the instruction of a true condition
     * @return instruction of a true condition
     */
    public TreeNodes getDoThis(){
        return this.doThis;
    }
}
