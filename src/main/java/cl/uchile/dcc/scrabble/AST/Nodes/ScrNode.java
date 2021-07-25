package cl.uchile.dcc.scrabble.AST.Nodes;

import cl.uchile.dcc.scrabble.AST.TreeNodes;

/**
 * Interface that wraps the methods applicable to Scr objects nodes
 */
public interface ScrNode extends TreeNodes {
    //Addition
    /**
     * Adds the values of two nodes
     * @param node the node to be added
     * @return a Node with the result
     */
    ScrNode addNode(ScrNode node);

    /**
     * Adds a NodeInt with this Node
     * @param node the NodeInt to be added to
     * @return A node with the result
     */
    ScrNode addToIntNode(NodeInt node);

    /**
     * Adds a NodeFloat with this Node
     * @param node the NodeFloat to be added to
     * @return A node with the result
     */
    ScrNode addToFloatNode(NodeFloat node);

    /**
     * Adds a NodeBinary with this Node
     * @param node the NodeBinary to be added to
     * @return A node with the result
     */
    ScrNode addToBinaryNode(NodeBinary node);

    /**
     * Adds a NodeString to this Node
     * @param node the NodeString to be added to
     * @return A node with the result
     */
    ScrNode addToStringNode(NodeString node);


    //Subtraction
    /**
     * Subtracts the values of two nodes
     * @param node the node to be subtracted
     * @return a Node with the result
     */
    ScrNode subtractNode(ScrNode node);

    /**
     * Subtracts this node to a NodeInt
     * @param node the NodeInt to be subtracted To
     * @return A node with the result
     */
    ScrNode subtractToIntNode(NodeInt node);

    /**
     * Subtracts this node to a NodeFloat
     * @param node the NodeFloat to be subtracted To
     * @return A node with the result
     */
    ScrNode subtractToFloatNode(NodeFloat node);

    /**
     * Subtracts this node to a NodeBinary
     * @param node the NodeBinary to be subtracted TO
     * @return A node with the result
     */
    ScrNode subtractToBinaryNode(NodeBinary node);
    


    //multiplication
    /**
     * Multiplies the values of two nodes
     * @param node the node to be multiplied
     * @return a Node with the result
     */
    ScrNode multiplyNode(ScrNode node);

    /**
     * Multiplies a NodeInt to this Node
     * @param node the NodeInt to be multiplied To
     * @return A node with the result
     */
    ScrNode multiplyAIntNode(NodeInt node);

    /**
     * Multiplies a NodeInt to this Node
     * @param node the NodeFloat to be multiplied To
     * @return A node with the result
     */
    ScrNode multiplyAFloatNode(NodeFloat node);

    /**
     * Multiplies a NodeInt to this Node
     * @param node the NodeBinary to be multiplied to
     * @return A node with the result
     */
    ScrNode multiplyABinaryNode(NodeBinary node);


    //Division
    /**
     * Divides the values of two nodes
      * @param node the node to be divided with
     * @return a Node with the result
     */
    ScrNode divideNode(ScrNode node);

    /**
     * Divides a NodeInt by this Node
     * @param node the NodeInt to be divided
     * @return A node with the result
     */
    ScrNode divideAIntNode(NodeInt node);

    /**
     * Divides a NodeInt by this Node
     * @param node the NodeFloat to be divided
     * @return A node with the result
     */
    ScrNode divideAFloatNode(NodeFloat node);

    /**
     * Divides a NodeInt by this Node
     * @param node the NodeBinary to be divided
     * @return A node with the result
     */
    ScrNode divideABinaryNode(NodeBinary node);

    //Logical Op
    /**
     * Applies logic and between two nodes
     * @param node the node to be and operated with
     * @return a Node with the result
     */
    ScrNode andNode(ScrNode node);

    /**
     * Applies logic and between this node and a Bool node
     * @param node the Bool node to be operated with
     * @return a ScrNode with the result
     */
    ScrNode andByBool(NodeBool node);

    /**
     * Applies logic and between this node and a Binary node
     * @param node the Binary node to be operated with
     * @return a ScrNode with the result
     */
    ScrNode andByBinary(NodeBinary node);

    /**
     * Applies logic or between two nodes
     * @param node the node to be or operated with
     * @return a Node with the result
     */
    ScrNode orNode(ScrNode node);

    /**
     * Applies logic or between this node and a Bool node
     * @param node the Bool node to be operated with
     * @return a ScrNode with the result
     */
    ScrNode orByBool(NodeBool node);

    /**
     * Applies logic or between this node and a Binary node
     * @param node the Binary node to be operated with
     * @return a ScrNode with the result
     */
    ScrNode orByBinary(NodeBinary node);

    /**
     * Applies not to a node
     * @return a Node with the result
     */
    ScrNode notNode();

    //Transformations
    /**
     * Transforms a node to an IntNode
     * @return an IntNode
     */
    NodeInt toNodeInt();

    /**
     * Transforms this node to a FloatNode
     * @return a FloatNode
     */
    NodeFloat toNodeFloat();

    /**
     * Transforms this node to a IntNode
     * @return a StringNode
     */
    NodeString toNodeString();

    /**
     * Transforms this node to a BinaryNode
     * @return a BinaryNode
     */
    NodeBinary toNodeBinary();

    /**
     * Transforms this node to a BoolNode
     * @return a BoolNode
     */
    NodeBool toNodeBool();
}
