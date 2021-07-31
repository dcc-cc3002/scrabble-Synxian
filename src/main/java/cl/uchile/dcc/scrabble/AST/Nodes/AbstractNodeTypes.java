package cl.uchile.dcc.scrabble.AST.Nodes;

import cl.uchile.dcc.scrabble.MemoryOpFactory.AstFactory.NodeTypeFactory;

/**
 * Abstract class for the NodeTypes of the AST
 */
public abstract class AbstractNodeTypes implements ScrNode {
    //Notar que la documentacion de estas clases se encuentra presente en la interfaz, por lo que se hereda
    @Override
    public ScrNode addNode(ScrNode node) {
        return null;
    }

    @Override
    public ScrNode addToIntNode(NodeInt node) {
        return null;
    }

    @Override
    public ScrNode addToFloatNode(NodeFloat node) {
        return null;
    }

    @Override
    public ScrNode addToBinaryNode(NodeBinary node) {
        return null;
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return a NodeString with the result
     */
    @Override
    public NodeString addToStringNode(NodeString node){
        return NodeTypeFactory.getNodeStringFlyweight(this.getValue().addToString(node.getValue()).getValue());
    }

    @Override
    public ScrNode subtractNode(ScrNode node) {
        return null;
    }

    @Override
    public ScrNode subtractToIntNode(NodeInt node) {
        return null;
    }

    @Override
    public ScrNode subtractToFloatNode(NodeFloat node) {
        return null;
    }

    @Override
    public ScrNode subtractToBinaryNode(NodeBinary node) {
        return null;
    }

    @Override
    public ScrNode multiplyNode(ScrNode node) {
        return null;
    }

    @Override
    public ScrNode multiplyAIntNode(NodeInt node) {
        return null;
    }

    @Override
    public ScrNode multiplyAFloatNode(NodeFloat node) {
        return null;
    }

    @Override
    public ScrNode multiplyABinaryNode(NodeBinary node) {
        return null;
    }

    @Override
    public ScrNode divideNode(ScrNode node) {
        return null;
    }

    @Override
    public ScrNode divideAIntNode(NodeInt node) {
        return null;
    }

    @Override
    public ScrNode divideAFloatNode(NodeFloat node) {
        return null;
    }

    @Override
    public ScrNode divideABinaryNode(NodeBinary node) {
        return null;
    }

    @Override
    public ScrNode andNode(ScrNode node) {
        return null;
    }

    @Override
    public ScrNode andByBool(NodeBool node) {
        return null;
    }

    @Override
    public ScrNode andByBinary(NodeBinary node) {
        return null;
    }

    @Override
    public ScrNode orNode(ScrNode node) {
        return null;
    }

    @Override
    public ScrNode orByBool(NodeBool node) {
        return null;
    }

    @Override
    public ScrNode orByBinary(NodeBinary node) {
        return null;
    }

    @Override
    public ScrNode notNode() {
        return null;
    }

    @Override
    public NodeInt toNodeInt() {
        return null;
    }

    @Override
    public NodeFloat toNodeFloat() {
        return null;
    }

    @Override
    public NodeString toNodeString() {
        return NodeTypeFactory.getNodeStringFlyweight(this.getValue().toScrString().getValue());
    }

    @Override
    public NodeBinary toNodeBinary() {
        return null;
    }

    @Override
    public NodeBool toNodeBool() {
        return null;
    }

    @Override
    public int compareTo(ScrNode node){
        return 0;
    }

    @Override
    public Integer compareToInt(NodeInt node){
        return null;
    }

    @Override
    public Integer compareToFloat(NodeFloat node){
        return null;
    }

    @Override
    public Integer compareToBinary(NodeBinary node){
        return null;
    }

    @Override
    public Integer compareToString(NodeString node){
        return null;
    }

    @Override
    public Integer compareToBool(NodeBool node){
        return null;
    }

}
