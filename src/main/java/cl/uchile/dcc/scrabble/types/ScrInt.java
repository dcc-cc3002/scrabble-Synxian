package cl.uchile.dcc.scrabble.types;

import java.util.Objects;

/**
 * The ScrInt class wraps an int in an object.
 * A ScrInt object contains a single field whose type is int
 *
 * @author Felix Melo Aviles
 */
public class ScrInt implements IOperations{

    /**
     *
     */
    private final int scrInt;

    /**
     * The constructor for this object
     * @param entero the int value that will be represented by the ScrInt object
     */
    public ScrInt(int entero){
        this.scrInt=entero;
    }

    /**
     * Returns the primitive String representation of the ScrInt
     * @return a String representation of the ScrInt value
     */
    @Override
    public String toString() {
        return String.valueOf(this.scrInt);
    }

    /**
     * Compares this object to the specified object
     * returns true if the param is an object of the same class and contains the same int as value,
     * otherwise, returns false
     * @param o The object to be compared with the ScrInt object
     * @return true if the objects are the same, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrInt scrInt1 = (ScrInt) o;
        return scrInt == scrInt1.scrInt;
    }

    /**
     * Returns the hash code for the ScrInt object
     * @return an int with the hashcode of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(scrInt);
    }

    /**
     * returns a ScrFloat representation of this ScrInt, converting the value of the ScrInt to a double
     * @return a ScrFloat representation of the value of this object
     */
    public ScrFloat toScrFloat(){
        return new ScrFloat(this.getValue());
    }

    /**
     * returns a ScrInt representation of this ScrInt, using the value of the ScrInt
     * @return a ScrInt representation of the value of this object
     */
    public ScrInt toScrInt(){
        return new ScrInt(this.scrInt);
    }

    /**
     * returns a ScrString representation of this ScrInt, converting its value to a string
     * @return a ScrString representation of the value of this object
     */
    public ScrString toScrString(){
        return new ScrString(String.valueOf(this.scrInt));
    }

    /**
     * returns a ScrBinary representation of this ScrInt, converting it's value to a 16-bit binary
     * @return a ScrBinary representation of the value of this object
     */
    public ScrBinary toScrBinary(){
        return new ScrBinary(this.intToBinary(this.getValue()));
    }

    /**
     * Returns the value of the ScrInt
     * @return an int equal to the wrapped value of this object
     */
    public int getValue(){
        return this.scrInt;
    }

    /**
     * Adds this ScrInt to a Scr object, returning the same type of num as the param.
     * @param num the object to be added
     * @return a Scr object with the result
     */
    @Override
    public IOperations add(IOperations num) {
        return num.addToScrInt(this);
    }

    /**
     * Adds this ScrInt to a ScrFloat, returning a ScrFloat
     * @param num a ScrFloat to be added with this object
     * @return a ScrFloat with the result
     */
    @Override
    public ScrFloat addToScrFloat(ScrFloat num) {
        return new ScrFloat(num.getValue()+this.getValue());
    }

    /**
     * Adds this ScrInt to another ScrInt, returning the same type
     * @param num a ScrInt to be added with this object
     * @return a ScrInt with the result
     */
    @Override
    public ScrInt addToScrInt(ScrInt num) {
        return new ScrInt(num.getValue()+this.getValue());
    }

    /**
     * Subtracts a ScrObject to this ScrInt, returning the same type of the param
     * @param num the object to be subtracted
     * @return a Scr object with the result
     */
    @Override
    public IOperations subtract(IOperations num) {
        return num.subtractToScrInt(this);
    }

    /**
     * Subtracts this ScrInt to a ScrFloat, returning a ScrFloat
     * @param num a ScrFloat to be subtracted by this object
     * @return a ScrFloat with the result
     */
    @Override
    public ScrFloat subtractToScrFloat(ScrFloat num) {
        return new ScrFloat(num.getValue()-this.getValue());
    }

    /**
     * Subtracts this ScrInt to another ScrInt, returning the same type
     * @param num a ScrInt to be subtracted by this object
     * @return a ScrInt with the result
     */
    @Override
    public ScrInt subtractToScrInt(ScrInt num) {
        return new ScrInt(num.getValue()-this.getValue());
    }

    /**
     * multiplies this ScrInt by a Scr object, returning the same type as the param.
     * @param num the object to multiply this object by
     * @return a Scr object with the result
     */
    @Override
    public IOperations multiply(IOperations num) {
        return num.mulAScrInt(this);
    }

    /**
     * Multiplies a ScrInt by this ScrInt, returning the same type
     * @param num a ScrInt to be multiplied by this object
     * @return a ScrInt with the result
     */
    @Override
    public ScrInt mulAScrInt(ScrInt num) {
        return new ScrInt(num.getValue()*this.getValue());
    }

    /**
     * Multiplies a ScrFloat by this ScrInt, returning a ScrFloat
     * @param num a ScrFloat to be multiplied by this object
     * @return a ScrFloat with the result
     */
    @Override
    public ScrFloat mulAScrFloat(ScrFloat num) {
        return new ScrFloat(num.getValue()*this.getValue());
    }

    /**
     * Divides this ScrInt by a Scr object, returning the same type as num
     * @param num the object to divide this object by
     * @return a Scr object with the result
     */
    @Override
    public IOperations divide(IOperations num) {
        return num.divideAScrInt(this);
    }

    /**
     * Divides a ScrInt by this ScrInt, returning the same type
     * @param num the ScrInt to divide
     * @return a ScrInt with the result
     */
    @Override
    public IOperations divideAScrInt(ScrInt num) {
        return new ScrInt((num.getValue()/this.getValue())+0);
    }

    /**
     * Divides a ScrFloat by this ScrInt, returning a ScrFloat
     * @param num the ScrFloat to divide
     * @return a ScrFloat with the result
     */
    @Override
    public ScrFloat divideAScrFloat(ScrFloat num) {
        return new ScrFloat(num.getValue()/this.getValue());
    }

    /**
     * Adds a ScrBinary to this ScrInt, returning a ScrInt
     * @param bin the ScrBinary to be added
     * @return a ScrInt with the result
     */
    public ScrInt add(ScrBinary bin){
        return new ScrInt(this.getValue()+bin.toScrInt().getValue());
    }

    /**
     * Subtracts a ScrBinary to this ScrInt, returning a ScrInt
     * @param bin the ScrBinary to be subtracted
     * @return a ScrInt with the result
     */
    public ScrInt subtract(ScrBinary bin){
        return new ScrInt(this.getValue()-bin.toScrInt().getValue());
    }

    /**
     * Multiplies this ScrInt by a ScrBinary, returning a ScrInt
     * @param bin the ScrBinary to be multiplied
     * @return a ScrInt with the result
     */
    public ScrInt multiply(ScrBinary bin){
        return new ScrInt(this.getValue()*bin.toScrInt().getValue());
    }

    /**
     * Divides this ScrInt by a ScrBinary, returning a ScrInt
     * @param bin the ScrBinary to be divided
     * @return a ScrInt with the result
     */
    public ScrInt divide(ScrBinary bin){
        return new ScrInt(this.getValue()/bin.toScrInt().getValue());
    }

    //Transformation methods

    /**
     * Returns the binary form of a integer
     * @param i the integer to convert
     * @return a String with the binary value
     */
    private String intToBinary(int i){
        int j = Math.abs(i);
        String bin= this.positiveInToBinary(j);
        if(i<0){
            bin=twosComplement(bin);
        }
        return bin;
    }

    private String positiveInToBinary(int i){
        StringBuilder posBin = new StringBuilder();
        while(i>0){
            posBin.insert(0, i%2);
            i/=2;
        }
        return String.format("%16s", posBin).replace(' ', '0');
    }

    private String twosComplement(String b){
        ScrBinary oldBin= new ScrBinary(b);
        ScrBinary negBin= oldBin.neg();
        return negBin.add(new ScrBinary("0000000000000001")).getValue();
    }
}