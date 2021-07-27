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

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public int compareTo(ScrNode node){
        return node.compareToString(this);
    }

    /**
     * Compares 2 string nodes, depending on their ASCII value, the return is 1 or more if the parameter object has a
     * higher ascii value, 0 if the same, -1 or less otherwise
     * @param node the string node to be compared with
     * @return {@inheritDoc}
     */
    @Override
    public Integer compareToString(NodeString node){
        return node.getValue().compareTo(this.getValue());
    }

}
