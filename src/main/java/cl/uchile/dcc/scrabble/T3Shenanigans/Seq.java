package cl.uchile.dcc.scrabble.T3Shenanigans;

import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;
import cl.uchile.dcc.scrabble.AST.TreeNodes;

/**
 * Class in charge of creating a list of Ast, seq will sequentially execute the ast contained
 */
public class Seq {
    /**
     * The list of Ast
     */
    private TreeNodes[] Tree;

    /**
     * Constructor method for the Seq class
     * @param Tree the list of Ast
     */
    public Seq(TreeNodes... Tree){
        this.Tree=Tree;
    }

    /**
     * Method that sequentially evaluates the tree
     * @return The resulting node of the operations
     */
    public ScrNode eval() {
        for(int i=0; i<this.Tree.length;i++){
            this.Tree[i].eval();
        }
        return null;
    }
}
