package cl.uchile.dcc.scrabble.AST.Transformations;

import cl.uchile.dcc.scrabble.AST.Nodes.NodeBinary;
import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;
import cl.uchile.dcc.scrabble.AST.TreeNodes;
import cl.uchile.dcc.scrabble.types.SType;

/**
 * Class that handles toNodeBinaryC transformation
 */
public class toNodeBinaryC extends AbstractSoloOperations{


    /**
     * the constructor of this class
     *
     * @param node the node to be operated
     */
    public toNodeBinaryC(TreeNodes node) {
        super(node);
    }



    /**
     * applies the transformation to Binary node
     * @return a NodeBinary
     */
    @Override
    public NodeBinary eval() {
        return this.node.eval().toNodeBinary();
    }
}
