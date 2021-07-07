package cl.uchile.dcc.scrabble.AST.Nodes;

import cl.uchile.dcc.scrabble.types.ScrString;

/**
 * Class that represent a ScrString node
 */
public class NodeString extends AbstractNodeTypes{
    /**
     * the ScrString contained in the node
     */
    public ScrString nodeValue;

    /**
     * The constructor for the NodeString class
     * @param nodeValue the ScrString object to be contained by the Node
     */
    public NodeString(ScrString nodeValue){
        this.nodeValue=nodeValue;
    }

    /**
     * {@inheritDoc}
     * @return a NodeString
     */
    @Override
    public NodeString eval(){
        return this;
    }

    /**
     * Gets the ScrString contained in the NodeString
     * @return a ScrString
     */
    @Override
    public ScrString getValue(){
        return this.nodeValue;
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return the resulting NodeString
     */
    @Override
    public NodeString addNode(ScrNode node){
        return (NodeString) node.addToStringNode(this);
    }

}
