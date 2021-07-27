package cl.uchile.dcc.scrabble.AST.Transformations;

import cl.uchile.dcc.scrabble.AST.ITreeNodes;
import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;
import cl.uchile.dcc.scrabble.AST.Operations.AbstractOperations;
import cl.uchile.dcc.scrabble.AST.TreeNodes;
import cl.uchile.dcc.scrabble.types.SType;

/**
 * Abstract class for the Operations applied to only one node
 */
public abstract class AbstractSoloOperations implements TreeNodes, ITreeNodes {
    /**
     * The node to be operated
     */
    protected TreeNodes node;

    /**
     * the constructor of this class
     * @param node the node to be operated
     */
    protected AbstractSoloOperations(TreeNodes node){
        this.node=node;
    }

    @Override
    public SType getValue() {
        return this.eval().getValue();
    }
}
