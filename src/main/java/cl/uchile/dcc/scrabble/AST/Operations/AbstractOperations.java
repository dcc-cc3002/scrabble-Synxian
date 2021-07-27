package cl.uchile.dcc.scrabble.AST.Operations;

import cl.uchile.dcc.scrabble.AST.ITreeNodes;
import cl.uchile.dcc.scrabble.AST.TreeNodes;
import cl.uchile.dcc.scrabble.types.SType;

/**
 * Abstract class for the Operations between two Nodes in the ast
 */
public abstract class AbstractOperations implements TreeNodes, ITreeNodes {
    /**
     * The right Node of the Ast
     */
    protected TreeNodes rightNode;
    /**
     * The left Node of the Ast
     */
    protected TreeNodes leftNode;

    /**
     * The constructor for the Ast evaluation
     * @param leftNode the left Node
     * @param rightNode the right Node
     */
    protected AbstractOperations(TreeNodes leftNode, TreeNodes rightNode){
        this.leftNode=leftNode;
        this.rightNode=rightNode;
    }

    @Override
    public SType getValue() {
        return this.eval().getValue();
    }
}
