package cl.uchile.dcc.scrabble.T3Shenanigans.ControlDeFlujo;

import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;

/**
 * Interface for the visitor DP
 */
public interface IVisitor {
    /**
     * Visitor for if
     * @return nothing, it just executes the instruction
     */
    ScrNode visitorIf(ScrIf v);

    /**
     * Visitor for While
     * @return nothing, it just executes the instruction
     */
    ScrNode visitorWhile(ScrWhile v);

    /**
     * Visitor for DoWhile
     * @return nothing, it just executes the instruction
     */
    ScrNode visitorDoWhile(ScrDoWhile v);

    /**
     * Visitor for While-Else
     * @return nothing, it just executes the instruction
     */
    ScrNode visitorWhileElse(WhileElse v);

    /**
     * Visitor for 'For'
     * @return nothing, it just executes the instruction
     */
    ScrNode visitorFor(ScrFor v);
}
