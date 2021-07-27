package cl.uchile.dcc.scrabble.AST.Nodes;

import cl.uchile.dcc.scrabble.MemoryOpFactory.AstFactory.NodeTypeFactory;
import cl.uchile.dcc.scrabble.types.numbers.ScrInt;

/**
 * Class that represent a ScrInt node
 */
public class NodeInt extends AbstractNodeTypes{
    /**
     * the ScrInt contained in the node
     */
    public ScrInt nodeValue;

    /**
     * The constructor for the NodeInt class
     * @param nodeValue the ScrInt object to be contained by the Node
     */
    public NodeInt(ScrInt nodeValue){
        this.nodeValue=nodeValue;
    }

    /**
     * {@inheritDoc}
     * @return a NodeInt
     */
    @Override
    public NodeInt eval(){
        return this;
    }

    /**
     * Gets the ScrInt contained in the NodeInt
     * @return a ScrInt
     */
    @Override
    public ScrInt getValue(){
        return this.nodeValue;
    }

    /**
     * Adds this NodeInt with a Scr Node
     * @param node {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public ScrNode addNode(ScrNode node) {
        return node.addToIntNode(this);
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return a NodeInt with the result
     */
    @Override
    public NodeInt addToIntNode(NodeInt node) {
        return NodeTypeFactory.getNodeIntFlyweight(this.getValue().addToScrInt(node.getValue()).getValue());
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
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return a NodeBinary with the result
     */
    @Override
    public NodeBinary addToBinaryNode(NodeBinary node) {
        return NodeTypeFactory.getNodeBinaryFlyweight(this.getValue().addToScrBinary(node.getValue()).getValue());
    }

    /**
     * Subtracts this NodeInt with a Scr Node
     * @param node {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public ScrNode subtractNode(ScrNode node) {
        return node.subtractToIntNode(this);
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return a NodeInt with the result
     */
    @Override
    public NodeInt subtractToIntNode(NodeInt node) {
        return NodeTypeFactory.getNodeIntFlyweight(this.getValue().subtractToScrInt(node.getValue()).getValue());
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
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return a NodeBinary with the result
     */
    @Override
    public NodeBinary subtractToBinaryNode(NodeBinary node) {
        return NodeTypeFactory.getNodeBinaryFlyweight(this.getValue().subtractToScrBinary(node.getValue()).getValue());
    }

    /**
     * Multiplies this NodeInt with a Scr Node
     * @param node {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public ScrNode multiplyNode(ScrNode node) {
        return node.multiplyAIntNode(this);
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return a NodeInt with the result
     */
    @Override
    public NodeInt multiplyAIntNode(NodeInt node) {
        return NodeTypeFactory.getNodeIntFlyweight(this.getValue().mulAScrInt(node.getValue()).getValue());
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return a NodeFloat with the result
     */
    @Override
    public NodeFloat multiplyAFloatNode(NodeFloat node) {
        return NodeTypeFactory.getNodeFloatFlyweight(this.getValue().mulAScrFloat(node.getValue()).getValue());
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return a NodeBinary with the result
     */
    @Override
    public NodeBinary multiplyABinaryNode(NodeBinary node) {
        return NodeTypeFactory.getNodeBinaryFlyweight(this.getValue().multiplyAScrBinary(node.getValue()).getValue());
    }

    /**
     * Divides this NodeInt with a Scr Node
     * @param node {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public ScrNode divideNode(ScrNode node) {
        return node.divideAIntNode(this);
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return a NodeInt with the result
     */
    @Override
    public NodeInt divideAIntNode(NodeInt node) {
        return NodeTypeFactory.getNodeIntFlyweight(this.getValue().divideAScrInt(node.getValue()).getValue());
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return a NodeFloat with the result
     */
    @Override
    public NodeFloat divideAFloatNode(NodeFloat node) {
        return NodeTypeFactory.getNodeFloatFlyweight(this.getValue().divideAScrFloat(node.getValue()).getValue());
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return a NodeBinary with the result
     */
    @Override
    public NodeBinary divideABinaryNode(NodeBinary node) {
        return NodeTypeFactory.getNodeBinaryFlyweight(this.getValue().divideAScrBinary(node.getValue()).getValue());
    }

    /**
     * Transforms this node to a IntNode
     * @return a NodeInt
     */
    @Override
    public NodeInt toNodeInt() {
        return this;
    }

    /**
     * Transforms this node to a NodeFloat
     * @return a NodeFloat
     */
    @Override
    public NodeFloat toNodeFloat() {
        return NodeTypeFactory.getNodeFloatFlyweight(this.getValue().getValue());
    }

    /**
     * Transforms this node to a IntNode
     * @return a NodeInt
     */
    @Override
    public NodeBinary toNodeBinary() {
        return NodeTypeFactory.getNodeBinaryFlyweight(String.valueOf(this.getValue().toScrBinary().getValue()));
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public int compareTo(ScrNode node){
        return node.compareToInt(this);
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Integer compareToInt(NodeInt node){
        return node.getValue().compareTo(this.getValue());
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Integer compareToFloat(NodeFloat node){
        return node.getValue().compareTo(this.getValue());
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Integer compareToBinary(NodeBinary node){
        return node.getValue().compareTo(this.getValue());
    }
}
