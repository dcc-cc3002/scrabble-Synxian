package cl.uchile.dcc.scrabble.AST;

import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;
import cl.uchile.dcc.scrabble.types.SType;

public interface TreeNodes {

    /**
     * Gets the value contained in the ScrNode
     * @return a ScrObject
     */
    SType getValue();

    /**
     * Similar to a getValue, the node returns itself, its meant to be used to end recursions
     * @return a ScrNode
     */
    ScrNode eval();

}
