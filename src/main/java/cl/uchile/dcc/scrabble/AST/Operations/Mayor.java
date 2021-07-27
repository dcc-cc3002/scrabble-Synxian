package cl.uchile.dcc.scrabble.AST.Operations;

import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;
import cl.uchile.dcc.scrabble.AST.TreeNodes;
import cl.uchile.dcc.scrabble.MemoryOpFactory.AstFactory.NodeTypeFactory;

/**
 * Class that handles the greater than comparison between two nodes
 */
public class Mayor extends AbstractOperations{
    /**
     * Constructor for the class
     * @param leftNode the left Node
     * @param rightNode the right Node
     */
    public Mayor(TreeNodes leftNode, TreeNodes rightNode) {
        super(leftNode, rightNode);
    }


    /**
     * applies the 'greater than' comparison between the nodes
     * @return a nodeBool with true if the left leaf is greater than the right one, with false otherwise
     */
    @Override
    public ScrNode eval() {
        if(leftNode.eval().compareTo(rightNode.eval())>=1){
            return NodeTypeFactory.getNodeBoolFlyweight(true);
        }
        return NodeTypeFactory.getNodeBoolFlyweight(false);
    }
}
