package cl.uchile.dcc.scrabble.AST.Operations;

import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;
import cl.uchile.dcc.scrabble.AST.TreeNodes;
import cl.uchile.dcc.scrabble.MemoryOpFactory.AstFactory.NodeTypeFactory;

/**
 * Class that handles the less or equal comparison between two nodes
 */
public class MenorIgual extends AbstractOperations{
    /**
     * Constructor for the class
     * @param leftNode the left Node
     * @param rightNode the right Node
     */
    public MenorIgual(TreeNodes leftNode, TreeNodes rightNode) {
        super(leftNode, rightNode);
    }


    /**
     * applies the 'less or equal' comparison between the nodes
     * @return a nodeBool with true if the left leaf is less or equal to the right one, with false otherwise
     */
    @Override
    public ScrNode eval() {
        if(leftNode.eval().compareTo(rightNode.eval())<=0){
            return NodeTypeFactory.getNodeBoolFlyweight(true);
        }
        return NodeTypeFactory.getNodeBoolFlyweight(false);
    }
}
