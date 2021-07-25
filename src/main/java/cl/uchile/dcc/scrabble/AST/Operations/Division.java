package cl.uchile.dcc.scrabble.AST.Operations;

import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;
import cl.uchile.dcc.scrabble.AST.TreeNodes;
import cl.uchile.dcc.scrabble.types.SType;

/**
 * Class that handles division between nodes in the Ast
 */
public class Division extends AbstractOperations{

    /**
     * Constructor for the class
     * @param leftNode the left Node
     * @param rightNode the right Node
     */
    public Division(TreeNodes leftNode, TreeNodes rightNode) {
        super(leftNode, rightNode);
    }


    /**
     * applies division between the nodes
     * @return a node with the result
     */
    @Override
    public ScrNode eval(){
        return this.leftNode.eval().divideNode(this.rightNode.eval());
    }
}
