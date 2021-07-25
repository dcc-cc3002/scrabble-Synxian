package cl.uchile.dcc.scrabble.AST.Operations;

import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;
import cl.uchile.dcc.scrabble.AST.TreeNodes;
import cl.uchile.dcc.scrabble.types.SType;

/**
 * Class that handles subtraction between nodes in the Ast
 */
public class Subtraction extends AbstractOperations{
    /**
     * Constructor for the class
     * @param leftNode the left Node
     * @param rightNode the right Node
     */
    public Subtraction(TreeNodes leftNode, TreeNodes rightNode) {
        super(leftNode, rightNode);
    }


    /**
     * applies subtraction between both nodes
     * @return a node with the result
     */
    @Override
    public ScrNode eval(){
        return this.leftNode.eval().subtractNode(this.rightNode.eval());
    }
}
