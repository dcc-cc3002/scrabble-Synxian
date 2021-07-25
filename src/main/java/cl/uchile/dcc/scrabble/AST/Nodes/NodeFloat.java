package cl.uchile.dcc.scrabble.AST.Nodes;

import cl.uchile.dcc.scrabble.MemoryOpFactory.AstFactory.NodeTypeFactory;
import cl.uchile.dcc.scrabble.types.numbers.ScrFloat;
import cl.uchile.dcc.scrabble.types.numbers.ScrInt;

/**
 * Class that represent a ScrFloat node
 */
public class NodeFloat extends AbstractNodeTypes{
    /**
     * the ScrFloat contained in the node
     */
    public ScrFloat nodeValue;

    /**
     * The constructor for the NodeFloat class
     * @param nodeValue the ScrFloat object to be contained by the Node
     */
    public NodeFloat(ScrFloat nodeValue){
        this.nodeValue=nodeValue;
    }

    /**
     * {@inheritDoc}
     * @return a NodeFloat
     */
    @Override
    public NodeFloat eval(){
        return this;
    }

    /**
     * Gets the ScrFloat contained in the NodeFloat
     * @return a ScrInt
     */
    @Override
    public ScrFloat getValue(){
        return this.nodeValue;
    }

    /**
     * Adds this NodeFloat with a Scr Node
     * @param node {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public ScrNode addNode(ScrNode node) {
        return node.addToFloatNode(this);
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return a NodeFloat with the result
     */
    @Override
    public NodeFloat addToIntNode(NodeInt node) {
        return NodeTypeFactory.getNodeFloatFlyweight(this.getValue().addToScrInt(node.getValue()).getValue());
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return a NodeFloat with the result
     */
    @Override
    public NodeFloat addToFloatNode(NodeFloat node) {
        return NodeTypeFactory.getNodeFloatFlyweight(this.getValue().addToScrFloat(node.getValue()).getValue());
    }

    /**
     * Subtracts this NodeFloat with a Scr Node
     * @param node {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public ScrNode subtractNode(ScrNode node) {
        return node.subtractToFloatNode(this);
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return a NodeFloat with the result
     */
    @Override
    public NodeFloat subtractToIntNode(NodeInt node) {
        return NodeTypeFactory.getNodeFloatFlyweight(this.getValue().subtractToScrInt(node.getValue()).getValue());
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return a NodeFloat with the result
     */
    @Override
    public NodeFloat subtractToFloatNode(NodeFloat node) {
        return NodeTypeFactory.getNodeFloatFlyweight(this.getValue().subtractToScrFloat(node.getValue()).getValue());
    }

    /**
     * Multiplies this NodeFloat with a Scr Node
     * @param node {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public ScrNode multiplyNode(ScrNode node) {
        return node.multiplyAFloatNode(this);
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return a NodeFloat with the result
     */
    @Override
    public ScrNode multiplyAIntNode(NodeInt node) {
        return NodeTypeFactory.getNodeFloatFlyweight(this.getValue().mulAScrInt(node.getValue()).getValue());
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return a NodeFloat with the result
     */
    @Override
    public ScrNode multiplyAFloatNode(NodeFloat node) {
        return NodeTypeFactory.getNodeFloatFlyweight(this.getValue().mulAScrFloat(node.getValue()).getValue());
    }

    /**
     * Divides this NodeFloat with a Scr Node
     * @param node {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public ScrNode divideNode(ScrNode node) {
        return node.divideAFloatNode(this);
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return a NodeFloat with the result
     */
    @Override
    public NodeFloat divideAIntNode(NodeInt node) {
        return NodeTypeFactory.getNodeFloatFlyweight(this.getValue().divideAScrInt(node.getValue()).getValue());
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return a NodeFloat with the result
     */
    @Override
    public ScrNode divideAFloatNode(NodeFloat node) {
        return NodeTypeFactory.getNodeFloatFlyweight(this.getValue().divideAScrFloat(node.getValue()).getValue());
    }

    /**
     * Returns this NodeFloat
     * @return a NodeFloat
     */
    @Override
    public NodeFloat toNodeFloat() {
        return this;
    }
}
