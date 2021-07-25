package cl.uchile.dcc.scrabble.AST.Transformations;

import cl.uchile.dcc.scrabble.AST.Nodes.NodeInt;
import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;
import cl.uchile.dcc.scrabble.AST.TreeNodes;
import cl.uchile.dcc.scrabble.types.SType;

public class toNodeInt extends AbstractSoloOperations{
    /**
     * the constructor of this class
     *
     * @param node the node to be operated
     */
    public toNodeInt(TreeNodes node) {
        super(node);
    }



    /**
     * applies the transformation to Int node
     * @return a NodeInt
     */
    @Override
    public NodeInt eval() {
        return this.node.eval().toNodeInt();
    }
}
