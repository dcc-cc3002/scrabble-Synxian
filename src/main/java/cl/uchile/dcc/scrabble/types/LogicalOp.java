package cl.uchile.dcc.scrabble.types;

import cl.uchile.dcc.scrabble.types.numbers.ScrBinary;

/**
 * This interface contains Logical operations for Scr objects (binary and bool)
 * It contains logic and, or & negation
 *
 * @author Felix Melo Aviles
 */
public interface LogicalOp {

    /**
     * And logical operation between this logical object, and another one (ScrBinary or ScrBool)
     * @param form the logic Scr to be operated with
     * @return a Scr object with the result
     */
    public LogicalOp logicAnd(LogicalOp form);

    /**
     * And logical op between this Scr object and a ScrBool
     * @param bool the ScrBool to be operated with
     * @return a Scr object with the result
     */
    public LogicalOp andByBool(ScrBool bool);

    /**
     * And logical op between this Scr object and a ScrBinary, returning a new ScrBinary
     * @param bin the ScrBinary to be operated with
     * @return a ScrBinary with the result
     */
    public ScrBinary andByBinary(ScrBinary bin);

    /**
     * Or logical operation between this logical object, and another one (ScrBinary or ScrBool)
     * @param form the logic Scr to be operated with
     * @return a Scr object with the result
     */
    public LogicalOp logicOr(LogicalOp form);

    /**
     * Or logical op between this Scr object and a ScrBool
     * @param bool the ScrBool to be operated with
     * @return a Scr object with the result
     */
    public LogicalOp orByBool(ScrBool bool);

    /**
     * Or logical op between this Scr object and a ScrBinary, returning a new ScrBinary
     * @param bin the ScrBinary to be operated with
     * @return a ScrBinary with the result
     */
    public ScrBinary orByBinary(ScrBinary bin);

    /**
     * Logical negation for Scr cl.uchile.dcc.scrabble.AST.Operations.Binary ot Bool
     * @return a Scr object with the result
     */
    public LogicalOp neg();
}
