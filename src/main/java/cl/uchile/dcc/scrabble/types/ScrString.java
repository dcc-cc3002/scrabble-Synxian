package cl.uchile.dcc.scrabble.types;

import java.util.Objects;

/**
 * The ScrString class wraps a String in an object.
 * A ScrString object contains a single field whose type is String
 *
 * @author Felix Melo Aviles
 */
public class ScrString{

    /**
     * then immutable value of this ScrString
     */
    private final String scrString;

    /**
     * Constructor for the ScrString class, it creates a ScrString object with the given string
     * @param newString the String type argument that will be contained in the object
     */
    public ScrString(String newString){
        this.scrString=newString;
    }

    /**
     * Returns the primitive String representation of the ScrString object
     * @return a String representation of the ScrString's value
     */
    @Override
    public String toString() {
        return this.scrString;
    }

    /**
     * Compares this object to the specified object
     * returns true if the param is an object of the same class and contains the same string as value,
     * otherwise, returns false
     * @param o The object to be compared with the ScrString object
     * @return true if the objects are the same, false otherwise
     */
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrString scrString1 = (ScrString) o;
        return Objects.equals(scrString, scrString1.scrString);
    }

    /**
     * Returns the hashcode for this object
     * @return an int with the hashcode for the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(scrString);
    }

    /**
     * Returns a ScrString representing this ScrString's value
     * @return a ScrString representation of the value of this object
     */
    public ScrString toScrString(){
        return new ScrString(this.scrString);
    }

    /**
     * Returns the value of this objet as a primitive String
     * @return a String equal to the wrapped value of this object
     */
    public String getValue(){
        return this.scrString;
    }

    /**
     * Concatenates the param ScrString at the end of this ScrString
     * @param str the ScrString to add at the end
     * @return the ScrString generated by the concatenation
     */
    public ScrString add(ScrString str){
        return new ScrString(this.getValue()+str.getValue());
    }

    /**
     * Concatenates the param ScrInt at the end of this ScrString
     * @param entero the ScrString to add at the end
     * @return the ScrString generated by the concatenation
     */
    public ScrString add(ScrInt entero){
        return new ScrString(this.getValue()+entero.getValue());
    }

    /**
     * Concatenates the param ScrFloat at the end of this ScrString
     * @param flt the ScrString to add at the end
     * @return the ScrString generated by the concatenation
     */
    public ScrString add(ScrFloat flt){
        return new ScrString(this.getValue()+flt.getValue());
    }

    /**
     * Concatenates the param ScrBool at the end of this ScrString
     * @param bool the ScrString to add at the end
     * @return the ScrString generated by the concatenation
     */
    public ScrString add(ScrBool bool){
        return new ScrString(this.getValue()+bool.getValue());
    }

    /**
     * Concatenates the param ScrBinary at the end of this ScrString
     * @param bin the ScrString to add at the end
     * @return the ScrString generated by the concatenation
     */
    public ScrString add(ScrBinary bin){
        return new ScrString(this.getValue()+bin.getValue());
    }
}
