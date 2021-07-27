package cl.uchile.dcc.scrabble.AST.Nodes;

import cl.uchile.dcc.scrabble.MemoryOpFactory.AstFactory.NodeTypeFactory;
import cl.uchile.dcc.scrabble.types.numbers.ScrBinary;

/**
 * Class that represent a ScrBinary node
 */
public class NodeBinary extends AbstractNodeTypes{
    /**
     * the ScrBinary contained in the node
     */
    public ScrBinary nodeValue;

    /**
     * The constructor for the NodeBinary class
     * @param nodeValue the ScrBinary object to be contained by the Node
     */
    public NodeBinary(ScrBinary nodeValue){
        this.nodeValue=nodeValue;
    }

    /**
     * {@inheritDoc}
     * @return a NodeBinary
     */
    @Override
    public NodeBinary eval(){
        return this;
    }

    /**
     * Gets the ScrBinary contained in the NodeBinary
     * @return a ScrBinary
     */
    @Override
    public ScrBinary getValue(){
        return this.nodeValue;
    }

    /**
     * Adds this NodeBinary with a Scr Node
     * @param node {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public ScrNode addNode(ScrNode node) {
        return node.addToBinaryNode(this);
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
     * Subtracts this NodeBinary with a Scr Node
     * @param node {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public ScrNode subtractNode(ScrNode node) {
        return node.subtractToBinaryNode(this);
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
     * Multiplies this NodeBinary with a Scr Node
     * @param node {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public ScrNode multiplyNode(ScrNode node) {
        return node.multiplyABinaryNode(this);
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
        return NodeTypeFactory.getNodeBinaryFlyweight(this.getValue().mulAScrBinary(node.getValue()).getValue());
    }

    /**
     * Divides this NodeBinary with a Scr Node
     * @param node {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public ScrNode divideNode(ScrNode node) {
        return node.divideABinaryNode(this);
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
     * logic and operates this NodeBinary with a Scr Node
     * @param node {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public ScrNode andNode(ScrNode node) {
        return node.andByBinary(this);
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return a NodeBinary with the result
     */
    @Override
    public NodeBinary andByBool(NodeBool node) {
        return NodeTypeFactory.getNodeBinaryFlyweight(this.getValue().andByBool(node.getValue()).getValue());
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return a NodeBinary with the result
     */
    @Override
    public NodeBinary andByBinary(NodeBinary node) {
        return NodeTypeFactory.getNodeBinaryFlyweight(this.getValue().andByBinary(node.getValue()).getValue());
    }

    /**
     * logic or operates this NodeBinary with a Scr Node
     * @param node {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public ScrNode orNode(ScrNode node) {
        return node.orByBinary(this);
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return a NodeBinary with the result
     */
    @Override
    public NodeBinary orByBool(NodeBool node) {
        return NodeTypeFactory.getNodeBinaryFlyweight(this.getValue().orByBool(node.getValue()).getValue());
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return a NodeBinary with the result
     */
    @Override
    public NodeBinary orByBinary(NodeBinary node) {
        return NodeTypeFactory.getNodeBinaryFlyweight(this.getValue().orByBinary(node.getValue()).getValue());
    }

    /**
     * Applies not operand to this Bool node
     * @return a NodeBinary with 0's instead of 1's and 1's instead of 0's
     */
    @Override
    public NodeBinary notNode() {
        return NodeTypeFactory.getNodeBinaryFlyweight(this.getValue().neg().getValue());
    }

    @Override
    public NodeInt toNodeInt() {
        return NodeTypeFactory.getNodeIntFlyweight(this.getValue().toScrInt().getValue());
    }

    @Override
    public NodeFloat toNodeFloat() {
        return NodeTypeFactory.getNodeFloatFlyweight(this.getValue().toScrFloat().getValue());
    }

    @Override
    public NodeBinary toNodeBinary() {
        return this;
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public int compareTo(ScrNode node){
        return node.compareToBinary(this);
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
