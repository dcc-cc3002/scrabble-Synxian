package cl.uchile.dcc.scrabble.T3Shenanigans.ControlDeFlujo;

import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;
import cl.uchile.dcc.scrabble.MemoryOpFactory.TypesFactory.ScrTypesFactory;

/**
 * Class for the implementation of the Visitor DP
 */
public class Visitor implements IVisitor {


    /**
     * Visitor for if
     * @return nothing, it just executes the instruction
     */
    @Override
    public ScrNode visitorIf(ScrIf v){
        if(v.getCondition().eval().getValue().equals(ScrTypesFactory.getScrBoolFlyweight(true))){
            v.getDoThis().eval();
        }
        else {
            v.getElseDo().eval();
        }
        return null;
    }

    /**
     * Visitor for While
     * @return nothing, it just executes the instruction
     */
    @Override
    public ScrNode visitorWhile(ScrWhile v) {
        while(v.getCondition().eval().getValue().equals(ScrTypesFactory.getScrBoolFlyweight(true))){
            v.getDoThis().eval();
        }
        return null;
    }

    /**
     * Visitor for DoWhile
     * @return nothing, it just executes the instruction
     */
    @Override
    public ScrNode visitorDoWhile(ScrDoWhile v) {
        do {
            v.getDoThis().eval();
        }
        while(v.getCondition().eval().getValue().equals(ScrTypesFactory.getScrBoolFlyweight(true)));
        return null;
    }

    /**
     * Visitor for While-Else
     * @return nothing, it just executes the instruction
     */
    @Override
    public ScrNode visitorWhileElse(WhileElse v) {
        v.getDoThis().eval();
        while(v.getCondition().eval().getValue().equals(ScrTypesFactory.getScrBoolFlyweight(true))){
            v.getDoThis().eval();
        }
        v.getElseDo().eval();
        return null;
    }

    /**
     * Visitor for 'For'
     * @return nothing, it just executes the instruction
     */
    @Override
    public ScrNode visitorFor(ScrFor v) {
        v.getInit().eval();
        while(v.getStopCondition().eval().getValue().equals(ScrTypesFactory.getScrBoolFlyweight(true))){
            v.getDoThis().eval();
            v.getIncrement().eval();
        }
        return null;
    }
}
