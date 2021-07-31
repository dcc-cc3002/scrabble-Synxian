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
        return v.visitorIf(this);
    }

    /**
     * Getter fot the condition of the if
     * @return the condition of the if
     */
    public TreeNodes getCondition(){
        return this.condition;
    }

    /**
     * Getter fot the instruction of a true condition
     * @return instruction of a true condition
     */
    public TreeNodes getDoThis(){
        return this.doThis;
    }

    /**
     * Getter fot the instruction of a false condition
     * @return instruction of a false condition
     */
    public TreeNodes getElseDo(){
        return this.elseDo;
    }
}
