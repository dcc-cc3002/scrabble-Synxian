package cl.uchile.dcc.scrabble.AST.Transformations;

import cl.uchile.dcc.scrabble.AST.Nodes.NodeFloat;
import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;
import cl.uchile.dcc.scrabble.AST.TreeNodes;
import cl.uchile.dcc.scrabble.types.SType;

public class toNodeFloat extends AbstractSoloOperations{
    /**
     * the constructor of this class
     *
     * @param node the node to be operated
     */
    public toNodeFloat(TreeNodes node) {
        super(node);
    }


    /**
     * applies the transformation to Float node
     * @return a NodeFloat
     */
    @Override
    public NodeFloat eval() {
        return this.node.eval().toNodeFloat();
    }
}
