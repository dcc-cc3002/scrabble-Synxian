package cl.uchile.dcc.scrabble.AST.Nodes;

import cl.uchile.dcc.scrabble.MemoryOpFactory.AstFactory.NodeTypeFactory;
import cl.uchile.dcc.scrabble.types.ScrBool;

/**
 * Class that represent a ScrBool node
 */
public class NodeBool extends AbstractNodeTypes{
    /**
     * the ScrBool contained in the node
     */
    public ScrBool nodeValue;

    /**
     * The constructor for the NodeBool class
     * @param nodeValue the ScrBool object to be contained by the Node
     */
    public NodeBool(ScrBool nodeValue){
        this.nodeValue=nodeValue;
    }

    /**
     * {@inheritDoc}
     * @return a NodeBool
     */
    @Override
    public NodeBool eval(){
        return this;
    }

    /**
     * Gets the ScrBool contained in the NodeBool
     * @return a ScrBool
     */
    @Override
    public ScrBool getValue(){
        return this.nodeValue;
    }

    /**
     * logic and operates this NodeBool with a Scr Node
     * @param node {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public ScrNode andNode(ScrNode node) {
        return node.andByBool(this);
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return a NodeBool with the result
     */
    @Override
    public NodeBool andByBool(NodeBool node) {
        return NodeTypeFactory.getNodeBoolFlyweight(this.getValue().andByBool(node.getValue()).getValue());
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
     * logic or operates this NodeBool with a Scr Node
     * @param node {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public ScrNode orNode(ScrNode node) {
        return node.orByBool(this);
    }

    /**
     * {@inheritDoc}
     * @param node {@inheritDoc}
     * @return a NodeBool with the result
     */
    @Override
    public NodeBool orByBool(NodeBool node) {
        return NodeTypeFactory.getNodeBoolFlyweight(this.getValue().orByBool(node.getValue()).getValue());
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
     * @return a NodeBool with the opposite value
     */
    @Override
    public NodeBool notNode() {
        return NodeTypeFactory.getNodeBoolFlyweight(this.getValue().neg().getValue());
    }

    /**
     * Returns a NodeBool representation of this NodeBool
     * @return a NodeBool
     */
    @Override
    public NodeBool toNodeBool() {
        return this;
    }

}
