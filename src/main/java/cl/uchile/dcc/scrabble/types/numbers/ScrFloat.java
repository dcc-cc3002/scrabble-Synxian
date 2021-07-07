package cl.uchile.dcc.scrabble.types.numbers;

import cl.uchile.dcc.scrabble.MemoryOpFactory.TypesFactory.ScrTypesFactory;
import cl.uchile.dcc.scrabble.types.ScrString;

import java.util.Objects;

/**
 * The ScrFloat class wraps a double in an object.
 * A ScrBool object contains a single field whose type is double
 *
 * @author Felix Melo Aviles
 */
public class ScrFloat implements IOperations {

    /**
     * then immutable value of this ScrString
     */
    private final double scrFloat;

    /**
     * Constructor for the ScrFloat class, it creates a ScrFloat object with the given double
     * @param newFloat the double type argument that will be contained in the object
     */
    public ScrFloat(double newFloat){
        this.scrFloat=newFloat;
    }

    /**
     *Returns the primitive String representation of the ScrFloat
     * @return a String representation of the ScrFloat value
     */
    @Override
    public String toString() {
        return String.valueOf(this.scrFloat);
    }

    /**
     * Compares this object to the specified object
     * returns true if the param is an object of the same class and contains the same double as value,
     * otherwise, returns false
     * @param o The object to be compared with the ScrInt object
     * @return true if the objects are the same, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrFloat scrFloat1 = (ScrFloat) o;
        return Double.compare(scrFloat1.scrFloat, scrFloat) == 0;
    }

    /**
     * Returns the hash code for the ScrInt object
     * @return an int with the hashcode of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(scrFloat);
    }

    /**
     * returns a ScrString representation of this ScrFloat, converting its value to a string
     * @return a ScrString representation of the value of this object
     */
    public ScrString toScrString(){
        return ScrTypesFactory.getScrStringFlyweight(this.toString());
    }

    @Override
    public ScrString addToString(ScrString addend) {
        return ScrTypesFactory.getScrStringFlyweight(addend.toString()+this);
    }

    /**
     * returns a ScrFloat representation of this ScrFloat
     * @return a ScrFloat representation of the value of this object
     */
    public ScrFloat toScrFloat(){
        return ScrTypesFactory.getScrFloatFlyweight(this.scrFloat);
    }

    /**
     * Returns the value of the ScrFloat
     * @return a double equal to the wrapped value of this object
     */
    public double getValue(){
        return this.scrFloat;
    }

    /**
     * Adds this ScrFloat to a Scr object, returning the same type of num as the param. if possible
     * @param num the object to be added
     * @return a Scr object with the result
     */
    @Override
    public IOperations add(IOperations num) {
        return num.addToScrFloat(this);
    }

    /**
     * Adds this ScrInt to another ScrFloat, returning the same type
     * @param num a ScrFloat to be added with this object
     * @return a ScrFloat with the result
     */
    @Override
    public ScrFloat addToScrFloat(ScrFloat num) {
        return ScrTypesFactory.getScrFloatFlyweight(num.getValue()+this.getValue());
    }

    /**
     * Adds this ScrFloat to a ScrInt, returning a new-ScrFloat
     * @param num a ScrInt to be added with this object
     * @return a ScrFloat with the result
     */
    @Override
    public ScrFloat addToScrInt(ScrInt num) {
        return ScrTypesFactory.getScrFloatFlyweight(num.getValue()+this.getValue());
    }

    /**
     * Subtracts a ScrObject to this ScrInt, returning the same type of the param.
     * @param num the object to be subtracted
     * @return a Scr object with the result
     */
    @Override
    public IOperations subtract(IOperations num) {
        return num.subtractToScrFloat(this);
    }

    /**
     * Subtracts this ScrFloat to another ScrFloat, returning the same type
     * @param num a ScrFloat to be subtracted by this object
     * @return a ScrFloat with the result
     */
    @Override
    public ScrFloat subtractToScrFloat(ScrFloat num) {
        return ScrTypesFactory.getScrFloatFlyweight(num.getValue()-this.getValue());
    }

    /**
     * Subtracts this ScrFloat to a ScrInt, returning a new-ScrFloat
     * @param num a ScrFloat to be subtracted by this object
     * @return a ScrFloat with the result
     */
    @Override
    public ScrFloat subtractToScrInt(ScrInt num) {
        return ScrTypesFactory.getScrFloatFlyweight(num.getValue()-this.getValue());
    }

    /**
     * multiplies this ScrFloat by a Scr object, returning the same type as the param.
     * @param num the object to multiply this object by
     * @return a Scr object with the result
     */
    @Override
    public IOperations multiply(IOperations num) {
        return num.mulAScrFloat(this);
    }

    /**
     * Multiplies a ScrInt by this ScrFloat, returning a new-ScrFloat
     * @param num a ScrInt to be multiplied by this object
     * @return a ScrFloat with the result
     */
    @Override
    public ScrFloat mulAScrInt(ScrInt num) {
        return ScrTypesFactory.getScrFloatFlyweight(num.getValue()*this.getValue());
    }

    /**
     * Multiplies a ScrFloat by this ScrFloat, returning the same type
     * @param num a ScrFloat to be multiplied by this object
     * @return a ScrFloat with the result
     */
    @Override
    public ScrFloat mulAScrFloat(ScrFloat num) {
        return ScrTypesFactory.getScrFloatFlyweight(num.getValue()*this.getValue());
    }

    /**
     * Divides this ScrFloat by a Scr object, returning the same type as the param.
     * @param num the object to divide this object by
     * @return a Scr object with the result
     */
    @Override
    public IOperations divide(IOperations num) {
        return num.divideAScrFloat(this);
    }

    /**
     * Divides a ScrInt by this ScrFloat, returning a new-ScrFloat
     * @param num the ScrInt to divide
     * @return a ScrFloat with the result
     */
    @Override
    public ScrFloat divideAScrInt(ScrInt num) {
        return ScrTypesFactory.getScrFloatFlyweight(num.getValue()/this.getValue());
    }

    /**
     * Divides a ScrFloat by this ScrFloat, returning the same type
     * @param num the ScrFloat to divide
     * @return a ScrFloat with the result
     */
    @Override
    public ScrFloat divideAScrFloat(ScrFloat num) {
        return ScrTypesFactory.getScrFloatFlyweight(num.getValue()/this.getValue());
    }








}
