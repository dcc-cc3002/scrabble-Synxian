package cl.uchile.dcc.scrabble.types;

import cl.uchile.dcc.scrabble.MemoryOpFactory.TypesFactory.ScrTypesFactory;
import cl.uchile.dcc.scrabble.types.numbers.ScrBinary;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * The ScrBool class wraps a boolean in an object.
 * A ScrBool object contains a single field whose type is bolean
 *
 * @author Felix Melo Aviles
 */
public class ScrBool implements LogicalOp, SType, Comparable<ScrBool>{

    /**
     * then immutable value of this ScrString
     */
    private final boolean scrBool;

    /**
     * Constructor for the ScrBool class, it creates a ScrBool object with the given boolean
     * @param newBool the boolean type argument that will be contained in the object
     */
    public ScrBool(boolean newBool){
        this.scrBool=newBool;
    }

    /**
     * Returns, in form of a String, the value of the object, if the ScrBool is true, the string will be true,
     * otherwise, it'll be false
     * @return a String representation of the object's value
     */
    @Override
    public String toString() {
        return String.valueOf(this.scrBool);
    }

    /**
     * Compares this object to the specified object
     * returns true if the param is an object of the same class and contains the same boolean as value,
     * otherwise, returns false
     * @param o The object to be compared with the ScrString object
     * @return true if the objects are the same, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrBool scrBool1 = (ScrBool) o;
        return scrBool == scrBool1.scrBool;
    }

    /**
     * Returns the hashcode for this object
     * @return an int with the hashcode for the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(scrBool);
    }

    /**
     * Returns a ScrString representing this ScrBool value
     * @return a ScrString representation of the value of this object
     */
    public ScrString toScrString(){
        return ScrTypesFactory.getScrStringFlyweight(this.toString());
    }

    @Override
    public ScrString addToString(ScrString addend) {
        return ScrTypesFactory.getScrStringFlyweight(addend.toString()+this.toString());
    }


    /**
     * Returns a ScrBool representing this ScrBool value
     * @return a ScrBool representation of the value of this object
     */
    public ScrBool toScrBool(){
        return ScrTypesFactory.getScrBoolFlyweight(this.scrBool);
    }

    /**
     * Returns the value of this objet as a primitive boolean
     * @return a boolean equal to the wrapped value of this object
     */
    public boolean getValue(){
        return this.scrBool;
    }

    /**
     * Operates (logic and) this ScrBool with the param., returning the same type as param.
     * @param form the logic Scr to be operated with
     * @return a Scr logical object wih the result
     */
    @Override
    public LogicalOp logicAnd(LogicalOp form) {
        return form.andByBool(this);
    }

    /**
     * Operates (logic and) a ScrBool with this ScrBool, returning the same type
     * @param bool the ScrBool to be operated with
     * @return a ScrBool object wih the result
     */
    @Override
    public ScrBool andByBool(ScrBool bool) {
        return ScrTypesFactory.getScrBoolFlyweight(bool.getValue() && this.getValue());
    }

    /**
     * Operates (logic and) a ScrBinary with this ScrBool, returning a ScrBinary
     * @param bin the ScrBinary to be operated with
     * @return a ScrBinary with the result
     */
    @Override
    public ScrBinary andByBinary(ScrBinary bin) {
        return ScrTypesFactory.getScrBinaryFlyweight(this.getValue() ? bin.getValue() : "0000000000000000" );
    }

    /**
     * Operates (logic or) this ScrBool with the param., returning the same type as param.
     * @param form the logic Scr to be operated with
     * @return a Scr logical object wih the result
     */
    @Override
    public LogicalOp logicOr(LogicalOp form) {
        return form.orByBool(this);
    }

    /**
     * Operates (logic or) a ScrBool with this ScrBool, returning the same type
     * @param bool the ScrBool to be operated with
     * @return a ScrBool object wih the result
     */
    @Override
    public ScrBool orByBool(ScrBool bool) {
        return ScrTypesFactory.getScrBoolFlyweight(bool.getValue()||this.getValue());
    }

    /**
     * Operates (logic or) a ScrBinary with this ScrBool, returning a ScrBinary
     * @param bin the ScrBinary to be operated with
     * @return a ScrBinary with the result
     */
    @Override
    public ScrBinary orByBinary(ScrBinary bin) {
        return ScrTypesFactory.getScrBinaryFlyweight(this.getValue() ? "1111111111111111": bin.getValue());
    }

    /**
     * Logical negation for this ScrBool, if its true, returns a ScrBool with false, otherwise, with true
     * @return a ScrBool with the result
     */
    @Override
    public ScrBool neg() {
        return ScrTypesFactory.getScrBoolFlyweight(!this.getValue());
    }

    /**
     * Compares this ScrBool with another ScrBool, if the Object called on is greater than the parameter (true>false), the return will be 1 or more,
     * if the values are the same, the return will be 0, otherwise it'll be -1 or less
     * @param o the ScrBool to be compared with
     * @return 1 or more if the object called on is greater then the parameter, 0 if equals, -1 or less if the called object is smaller
     */
    @Override
    public int compareTo(ScrBool o) {
        return Boolean.compare(this.getValue(),o.getValue());
    }
}