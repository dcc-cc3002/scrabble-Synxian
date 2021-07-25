package cl.uchile.dcc.scrabble.AST.Transformations;

import cl.uchile.dcc.scrabble.AST.Nodes.NodeString;
import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;
import cl.uchile.dcc.scrabble.AST.TreeNodes;
import cl.uchile.dcc.scrabble.types.SType;

public class toNodeString extends AbstractSoloOperations{
    /**
     * the constructor of this class
     *
     * @param node the node to be operated
     */
    public toNodeString(TreeNodes node) {
        super(node);
    }


    /**
     * applies the transformation to String node
     * @return a NodeString
     */
    @Override
    public NodeString eval() {
        return this.node.eval().toNodeString();
    }
}
