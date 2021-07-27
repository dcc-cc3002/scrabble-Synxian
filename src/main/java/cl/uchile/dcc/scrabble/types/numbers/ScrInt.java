package cl.uchile.dcc.scrabble.types.numbers;

import cl.uchile.dcc.scrabble.MemoryOpFactory.TypesFactory.ScrTypesFactory;
import cl.uchile.dcc.scrabble.types.AbstractType;
import cl.uchile.dcc.scrabble.types.ScrString;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * The ScrInt class wraps an int in an object.
 * A ScrInt object contains a single field whose type is int
 *
 * @author Felix Melo Aviles
 */
public class ScrInt extends AbstractType implements IOperations, Comparable<IOperations> {

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
        return ScrTypesFactory.getScrFloatFlyweight(this.getValue());
    }

    /**
     * returns a ScrInt representation of this ScrInt, using the value of the ScrInt
     * @return a ScrInt representation of the value of this object
     */
    public ScrInt toScrInt(){
        return ScrTypesFactory.getScrIntFlyweight(this.scrInt);
    }

    /**
     * returns a ScrString representation of this ScrInt, converting its value to a string
     * @return a ScrString representation of the value of this object
     */
    public ScrString toScrString(){
        return ScrTypesFactory.getScrStringFlyweight(String.valueOf(this.scrInt));
    }

    /**
     * returns a ScrBinary representation of this ScrInt, converting it's value to a 16-bit binary
     * @return a ScrBinary representation of the value of this object
     */
    public ScrBinary toScrBinary(){
        return ScrTypesFactory.getScrBinaryFlyweight(this.intToBinary(this.getValue()));
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
        return ScrTypesFactory.getScrFloatFlyweight(num.getValue()+this.getValue());
    }

    /**
     * Adds this ScrInt to another ScrInt, returning the same type
     * @param num a ScrInt to be added with this object
     * @return a ScrInt with the result
     */
    @Override
    public ScrInt addToScrInt(ScrInt num) {
        return ScrTypesFactory.getScrIntFlyweight(num.getValue()+this.getValue());
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
        return ScrTypesFactory.getScrFloatFlyweight(num.getValue()-this.getValue());
    }

    /**
     * Subtracts this ScrInt to another ScrInt, returning the same type
     * @param num a ScrInt to be subtracted by this object
     * @return a ScrInt with the result
     */
    @Override
    public ScrInt subtractToScrInt(ScrInt num) {
        return ScrTypesFactory.getScrIntFlyweight(num.getValue()-this.getValue());
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
        return ScrTypesFactory.getScrIntFlyweight(num.getValue()*this.getValue());
    }

    /**
     * Multiplies a ScrFloat by this ScrInt, returning a ScrFloat
     * @param num a ScrFloat to be multiplied by this object
     * @return a ScrFloat with the result
     */
    @Override
    public ScrFloat mulAScrFloat(ScrFloat num) {
        return ScrTypesFactory.getScrFloatFlyweight(num.getValue()*this.getValue());
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
    public ScrInt divideAScrInt(ScrInt num) {
        return ScrTypesFactory.getScrIntFlyweight((num.getValue()/this.getValue())+0);
    }

    /**
     * Divides a ScrFloat by this ScrInt, returning a ScrFloat
     * @param num the ScrFloat to divide
     * @return a ScrFloat with the result
     */
    @Override
    public ScrFloat divideAScrFloat(ScrFloat num) {
        return ScrTypesFactory.getScrFloatFlyweight(num.getValue()/this.getValue());
    }

    /**
     * Adds a ScrBinary to this ScrInt, returning a ScrInt
     * @param bin the ScrBinary to be added
     * @return a ScrInt with the result
     */
    public ScrBinary addToScrBinary(ScrBinary bin){
        ScrInt bina= ScrTypesFactory.getScrIntFlyweight((bin.toScrInt().getValue()+this.getValue()));
        return ScrTypesFactory.getScrBinaryFlyweight(bina.toScrBinary().getValue());
    }

    /**
     * Subtracts a ScrBinary to this ScrInt, returning a ScrInt
     * @param bin the ScrBinary to be subtracted
     * @return a ScrInt with the result
     */
    public ScrBinary subtractToScrBinary(ScrBinary bin){
        ScrInt bina= ScrTypesFactory.getScrIntFlyweight((bin.toScrInt().getValue()-this.getValue()));
        return ScrTypesFactory.getScrBinaryFlyweight(bina.toScrBinary().getValue());
    }

    /**
     * Multiplies this ScrInt by a ScrBinary, returning a ScrInt
     * @param bin the ScrBinary to be multiplied
     * @return a ScrInt with the result
     */
    public ScrBinary multiplyAScrBinary(ScrBinary bin){
        ScrInt bina= ScrTypesFactory.getScrIntFlyweight((bin.toScrInt().getValue()*this.getValue()));
        return ScrTypesFactory.getScrBinaryFlyweight(bina.toScrBinary().getValue());
    }

    /**
     * Divides this ScrInt by a ScrBinary, returning a ScrInt
     * @param bin the ScrBinary to be divided
     * @return a ScrInt with the result
     */
    public ScrBinary divideAScrBinary(ScrBinary bin){
        ScrInt bina= ScrTypesFactory.getScrIntFlyweight((bin.toScrInt().getValue()/this.getValue()));
        return ScrTypesFactory.getScrBinaryFlyweight(bina.toScrBinary().getValue());
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
        ScrBinary oldBin= ScrTypesFactory.getScrBinaryFlyweight(b);
        ScrBinary negBin= oldBin.neg();
        return negBin.addToScrBinary(ScrTypesFactory.getScrBinaryFlyweight("0000000000000001")).getValue();
    }

    /**
     * Compares this ScrInt with the given one, if the Object called on is greater than the parameter, the return will be 1 or more,
     * if the values are the same, the return will be 0, otherwise it'll be -1 or less
     * @param num  the ScrObject to be compared with
     * @return 1 or more if the object called on is greater then the parameter, 0 if equals, -1 or less if the called object is smaller
     */
    @Override
    public int compareTo(IOperations num) {
        Double esta= this.toScrFloat().getValue();
        Double com= num.toScrFloat().getValue();
        return Double.compare(esta, com);
    }
}