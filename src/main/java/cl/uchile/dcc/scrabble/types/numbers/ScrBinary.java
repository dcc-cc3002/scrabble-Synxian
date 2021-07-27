package cl.uchile.dcc.scrabble.types.numbers;

import cl.uchile.dcc.scrabble.MemoryOpFactory.TypesFactory.ScrTypesFactory;
import cl.uchile.dcc.scrabble.types.AbstractType;
import cl.uchile.dcc.scrabble.types.LogicalOp;
import cl.uchile.dcc.scrabble.types.ScrBool;
import cl.uchile.dcc.scrabble.types.ScrString;

import java.util.Objects;

/**
 * The ScrBinary class wraps an String consisting of only '0' and '1' that represents a signed int.
 * A ScrBinary object contains a single field whose type is String, representing a 16-bit binary
 *
 * @author Felix Melo Aviles
 */
public class ScrBinary extends AbstractType implements IOperations, LogicalOp, Comparable<IOperations> {
    /**
     * then immutable value of this ScrBinary
     */
    private final String scrBinary;

    /**
     * Constructor for the ScrBinary class, it creates a ScrString object with the String representation of a 16-bit binary
     * @param Binary the String type argument that will be contained in the object
     */
    public ScrBinary(String Binary){
        this.scrBinary=Binary;
    }

    /**
     * Returns a String with the value of the ScrBinary
     * @return a String representation of the ScrBinary's value
     */
    @Override
    public String toString() {
        return this.scrBinary;
    }

    /**
     * Method that checks if this object is equal to the object in the param.
     * returns true if the object is of the same class and represents the same binary value, otherwise, it returns false
     * @param o the object to be compared
     * @return true or false, depending if the objects are the same or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrBinary scrBinary1 = (ScrBinary) o;
        return Objects.equals(scrBinary, scrBinary1.scrBinary);
    }

    /**
     * Returns the hash code for the ScrBinary object
     * @return an int with the hashcode of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(scrBinary);
    }


    /**
     * Returns a ScrString representing this ScrBinary's value
     * @return a ScrString representation of the value of this object
     */
    public ScrString toScrString(){
        return ScrTypesFactory.getScrStringFlyweight(this.toString());
    }

    /**
     * Returns a ScrBinary representing this ScrBinary's value
     * @return a ScrBinary representation of the value of this object
     */
    public ScrBinary toScrBinary(){
        return ScrTypesFactory.getScrBinaryFlyweight(this.scrBinary);
    }

    /**
     * Returns a ScrInt representing this ScrBinary's value, converting the 16-bit binary to an integer
     * to create the ScrInt
     * @return a ScrInt representation of the value of this object
     */
    public ScrInt toScrInt(){
        return ScrTypesFactory.getScrIntFlyweight(this.toInt(this.getValue()));
    }

    /**
     * Returns a ScrFloat representing this ScrBinary's value, first converting it to an int,
     * then to a double to create the ScrFloat
     * @return a ScrFloat representation of the value of this object
     */
    public ScrFloat toScrFloat(){
        return ScrTypesFactory.getScrFloatFlyweight(Double.valueOf(this.toInt(this.getValue())));
    }

    /**
     * Returns the value of the ScrBinary as a primitive String
     * @return a String equal to the wrapped value of this object
     */
    public String getValue(){
        return this.scrBinary;
    }


    /**
     * Operates (logic and) this ScrBinary with the param., returning the same type as param if possible.
     * @param form the logic Scr to be operated with
     * @return a Scr logical object wih the result
     */
    @Override
    public LogicalOp logicAnd(LogicalOp form) {
        return form.andByBinary(this);
    }

    /**
     * Operates (logic and) a ScrBool with this ScrBinary, returning a new-ScrBinary
     * @param bool the ScrBool to be operated with
     * @return a ScrBinary with the result
     */
    @Override
    public ScrBinary andByBool(ScrBool bool) {
        return ScrTypesFactory.getScrBinaryFlyweight(bool.getValue() ? this.getValue() : "0000000000000000" );
    }

    /**
     * Operates (logic and) a ScrBinary with this ScrBinary, returning a ScrBinary
     * @param bin the ScrBinary to be operated with
     * @return ScrBinary with the result of the operation
     */
    @Override
    public ScrBinary andByBinary(ScrBinary bin) {
        int len= bin.getValue().length();
        StringBuilder newBin = new StringBuilder();
        for(int i=0; i<len; i++){
            boolean bool1 = bin.getValue().charAt(i) == '1';
            boolean bool2 = this.getValue().charAt(i) == '1';
            boolean boolI = bool1 && bool2;
            int valueI = boolI ? 1:0;
            newBin.append(valueI);
        }
        return ScrTypesFactory.getScrBinaryFlyweight(newBin.toString());
    }

    /**
     * Operates (logic or) this ScrBinary with the param., returning the same type as param if possible.
     * @param form the logic Scr to be operated with
     * @return a Scr logical object with the result
     */
    @Override
    public LogicalOp logicOr(LogicalOp form) {
        return form.orByBinary(this);
    }

    /**
     * Operates (logic or) a ScrBool with this ScrBinary, returning a new-ScrBinary
     * @param bool the ScrBool to be operated with
     * @return a ScrBinary with the result
     */
    @Override
    public ScrBinary orByBool(ScrBool bool) {
        return ScrTypesFactory.getScrBinaryFlyweight(bool.getValue() ? "1111111111111111": this.getValue());
    }

    /**
     * Operates (logic or) a ScrBinary with this ScrBinary, returning a ScrBinary
     * @param bin the ScrBinary to be operated with
     * @return a ScrBinary with the result
     */
    @Override
    public ScrBinary orByBinary(ScrBinary bin) {
        int len= bin.getValue().length();
        StringBuilder newBin = new StringBuilder();
        for(int i=0; i<len; i++){
            boolean bool1 = bin.getValue().charAt(i) == '1';
            boolean bool2 = this.getValue().charAt(i) == '1';
            boolean boolI = bool1 || bool2;
            int valueI = boolI ? 1:0;
            newBin.append(valueI);
        }
        return ScrTypesFactory.getScrBinaryFlyweight(newBin.toString());
    }

    /**
     * Logical negation for this ScrBinary, changes 1's for 0's and 0's for 1's
     * @return a ScrBinary with the result
     */
    @Override
    public ScrBinary neg() {
        int len= this.getValue().length();
        StringBuilder newBin = new StringBuilder();
        for(int i=0; i<len; i++) {
            boolean bool1 = this.getValue().charAt(i)=='1';
            int valueI = !bool1 ? 1:0;
            newBin.append(valueI);
        }
        return ScrTypesFactory.getScrBinaryFlyweight(newBin.toString());
    }

    /**
     * Adds a ScrInt to this ScrBinary, returning a new-ScrBinary
     * @param num the ScrInt to add
     * @return a ScrBinary with the result
     */
    public ScrInt addToScrInt(ScrInt num){
        int sum1= this.toInt(this.toString());
        int ans= sum1+num.getValue();
        ScrInt newBin = ScrTypesFactory.getScrIntFlyweight(ans);
        return ScrTypesFactory.getScrIntFlyweight(newBin.getValue());
    }

    @Override
    public IOperations subtract(IOperations num) {
        return null;
    }

    /**
     * Adds a ScrBinary to this ScrBinary, returning a new-ScrBinary
     * @param num the ScrBinary to add
     * @return a ScrBinary with the result
     */
    public ScrBinary addToScrBinary(ScrBinary num) {
        int carry=0;
        int len1=this.getValue().length()-1;
        int len2=num.getValue().length()-1;
        StringBuilder ans= new StringBuilder();
        while(len1>=0 || len2>=0 ){
            int subAns=carry;
            if(len1>=0){
                subAns+=this.getValue().charAt(len1) - '0';
                len1--;
            }
            if(len2>=0){
                subAns+=num.getValue().charAt(len2) - '0';
                len2--;
            }
            carry= subAns >> 1;
            subAns = subAns & 1;
            ans.append(subAns==0 ? '0':'1');
        }
        if(carry>0){
            ans.append('1');
        }
        ans.reverse();
        return ScrTypesFactory.getScrBinaryFlyweight(String.valueOf(ans));
    }

    /**
     * Subtract a ScrInt to this ScrBinary
     * @param num the ScrInt to subtract
     * @return a ScrBinary with the result
     */
    public ScrInt subtractToScrInt(ScrInt num){
        int sum1=this.toInt(this.getValue());
        int ans= num.getValue()-sum1;
        ScrInt newBin = ScrTypesFactory.getScrIntFlyweight(ans);
        return ScrTypesFactory.getScrIntFlyweight(newBin.getValue());
    }

    @Override
    public IOperations multiply(IOperations num) {
        return null;
    }

    /**
     * Subtracts a ScrBinary to this ScrBinary, returning a new-ScrBinary
     * @param num the ScrBinary to subtract
     * @return a ScrBinary with the result
     */
    public ScrBinary subtractToScrBinary(ScrBinary num){
        int ans=num.toInt(num.getValue())-this.toInt(this.getValue());
        ScrInt sum1= ScrTypesFactory.getScrIntFlyweight(ans);
        return ScrTypesFactory.getScrBinaryFlyweight(sum1.toScrBinary().getValue());
    }

    /**
     * Multiplies this ScrBinary by a ScrInt, returning a new-ScrBinary
     * @param num the ScrInt to multiply by
     * @return a ScrBinary with the result
     */
    public ScrInt mulAScrInt(ScrInt num){
        int fac1=this.toInt(this.getValue());
        int fac2= num.getValue();
        ScrInt newBin = ScrTypesFactory.getScrIntFlyweight(fac1*fac2);
        return ScrTypesFactory.getScrIntFlyweight(newBin.getValue());
    }

    /**
     * Multiplies this ScrBinary by a ScrBinary, returning a new-ScrBinary
     * @param num the ScrBinary to multiply by
     * @return a ScrBinary with the result
     */
    public ScrBinary mulAScrBinary(ScrBinary num){
        int fac1=this.toInt(this.getValue());
        int fac2=num.toInt(num.getValue());
        ScrInt newBin = ScrTypesFactory.getScrIntFlyweight(fac1*fac2);
        return ScrTypesFactory.getScrBinaryFlyweight(newBin.toScrBinary().getValue());
    }

    /**
     * Divides this ScrBinary by a ScrInt, returning a new-ScrBinary
     * @param num the ScrInt to divide by
     * @return a ScrBinary with the result
     */
    public ScrInt divideAScrInt(ScrInt num){
        int fac1=this.toInt(this.getValue());
        int fac2=num.getValue();
        ScrInt newBin = ScrTypesFactory.getScrIntFlyweight((fac2/fac1)+0);
        return ScrTypesFactory.getScrIntFlyweight(newBin.getValue());
    }

    /**
     * Divides this ScrBinary by a ScrScrBinary, returning a new-ScrBinary
     * @param num the ScrBinary to divide by
     * @return a ScrBinary with the result
     */
    public ScrBinary divideAScrBinary(ScrBinary num){
        int fac1=this.toInt(this.getValue());
        int fac2=num.toInt(num.getValue());
        ScrInt newBin = ScrTypesFactory.getScrIntFlyweight((fac2/fac1)+0);
        return ScrTypesFactory.getScrBinaryFlyweight(newBin.toScrBinary().getValue());
    }

    @Override
    public IOperations add(IOperations num) {
        return null;
    }

    /**
     * Adds this ScrBinary to a ScrFloat, returning a ScrFloat
     * @param bin the ScrFloat to be added
     * @return a ScrFloat with the result
     */
    public ScrFloat addToScrFloat(ScrFloat bin){
        return ScrTypesFactory.getScrFloatFlyweight(this.toScrFloat().getValue()+bin.getValue());
    }

    /**
     * Subtracts this ScrBinary to a ScrFloat, returning a ScrFloat
     * @param bin the ScrBinary to be subtracted
     * @return a ScrFloat with the result
     */
    public ScrFloat subtractToScrFloat(ScrFloat bin){
        return ScrTypesFactory.getScrFloatFlyweight(bin.getValue()-this.toScrFloat().getValue());
    }

    /**
     * Multiplies a ScrFloat by this ScrBinary, returning a ScrFloat
     * @param bin the ScrBinary to be multiplied
     * @return a ScrFloat with the result
     */
    public ScrFloat mulAScrFloat(ScrFloat bin){
        return ScrTypesFactory.getScrFloatFlyweight(this.toScrFloat().getValue()*bin.getValue());
    }

    @Override
    public IOperations divide(IOperations num) {
        return null;
    }

    /**
     * Divides a ScrFloat by this ScrBinary, returning a ScrFloat
     * @param bin the ScrBinary to be divided
     * @return a ScrFloat with the result
     */
    public ScrFloat divideAScrFloat(ScrFloat bin){
        return ScrTypesFactory.getScrFloatFlyweight(bin.getValue()/this.toScrFloat().getValue());
    }


    //The transformation methods

    /**
     * Returns the integer form of a binary number
     * @param binary the binary number to convert
     * @return an int with the value of the binary
     */
    private int toInt(String binary) {
        if (bitToInt(binary.charAt(0)) == 0) {
            return positiveBinToInt(binary);
        } else {
            return negativeBinaryToInt(binary);
        }
    }
    private int negativeBinaryToInt(String binary) {
        int n = binary.length() - 1;
        int w = -bitToInt(binary.charAt(0)) * (int) Math.pow(2, n);
        for (int i = n, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * (binary.charAt(i) == '1' ? 1 : 0);
        }
        return w;
    }
    private int positiveBinToInt(String binary) {
        int w = 0;
        for (int i = binary.length() - 1, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * bitToInt(binary.charAt(i));
        }
        return w;
    }
    private int bitToInt(char bit) {
        return bit == '0' ? 0 : 1;
    }

    /**
     * Compares this ScrBinary with the given one, if the Object called on is greater than the parameter, the return will be 1 or more,
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