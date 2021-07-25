package cl.uchile.dcc.scrabble.AST.Operations;

import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;
import cl.uchile.dcc.scrabble.AST.TreeNodes;
import cl.uchile.dcc.scrabble.types.SType;

/**
 * Class that handles multiplication between nodes in the Ast
 */
public class Multiplication extends AbstractOperations{
    /**
     * Constructor for the class
     * @param leftNode the left Node
     * @param rightNode the right Node
     */
    public Multiplication(TreeNodes leftNode, TreeNodes rightNode) {
        super(leftNode, rightNode);
    }


    /**
     * multiplies both notes
     * @return a node with the result
     */
    @Override
    public ScrNode eval(){
        return this.leftNode.eval().multiplyNode(this.rightNode.eval());
    }
}
