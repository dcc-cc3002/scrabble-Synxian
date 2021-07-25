package cl.uchile.dcc.scrabble.AST.Transformations;

import cl.uchile.dcc.scrabble.AST.Nodes.NodeBool;
import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;
import cl.uchile.dcc.scrabble.AST.TreeNodes;
import cl.uchile.dcc.scrabble.types.SType;

public class toNodeBool extends AbstractSoloOperations{
    /**
     * the constructor of this class
     *
     * @param node the node to be operated
     */
    public toNodeBool(TreeNodes node) {
        super(node);
    }



    /**
     * applies the transformation to Bool node
     * @return a NodeBool
     */
    @Override
    public NodeBool eval() {
        return this.node.eval().toNodeBool();
    }
}
