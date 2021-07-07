package cl.uchile.dcc.scrabble.AST.Operations;

import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;
import cl.uchile.dcc.scrabble.AST.TreeNodes;
import cl.uchile.dcc.scrabble.types.SType;

/**
 * Class that handles logic or between nodes in the Ast
 */
public class Or extends AbstractOperations{
    /**
     * Constructor for the class
     * @param leftNode the left Node
     * @param rightNode the right Node
     */
    public Or(TreeNodes leftNode, TreeNodes rightNode) {
        super(leftNode, rightNode);
    }



    /**
     * logic or operates both nodes
     * @return a node with the result
     */
    @Override
    public ScrNode eval(){
        return this.leftNode.eval().orNode(this.rightNode.eval());
    }
}
