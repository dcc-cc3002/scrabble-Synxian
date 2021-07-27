package cl.uchile.dcc.scrabble.T3Shenanigans;


import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;
import cl.uchile.dcc.scrabble.AST.TreeNodes;
import cl.uchile.dcc.scrabble.MemoryOpFactory.AstFactory.AssignableVariablesFactory;

public class AssignToVariable implements TreeNodes {


    private String var;
    private TreeNodes value;
    protected AssignToVariable(String var, TreeNodes value) {
        this.var=var;
        this.value=value;
    }

    public String getVar(){
        return this.var;
    }

    @Override
    public ScrNode eval() {
        AssignableVariablesFactory.setVariable(this.getVar(), this.value.eval());
        return null;
    }
}
