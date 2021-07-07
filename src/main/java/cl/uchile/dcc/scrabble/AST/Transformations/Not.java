package cl.uchile.dcc.scrabble.AST.Transformations;

import cl.uchile.dcc.scrabble.AST.Nodes.NodeBinary;
import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;
import cl.uchile.dcc.scrabble.AST.TreeNodes;
import cl.uchile.dcc.scrabble.types.SType;

public class Not extends AbstractSoloOperations{


    /**
     * the constructor of this class
     *
     * @param node the node to be operated
     */
    public Not(TreeNodes node) {
        super(node);
    }

    /**
     * Applies Not method to the node
     * @return a ScrNode post application of not
     */
    @Override
    public ScrNode eval() {
        return this.node.eval().notNode();
    }
}
