package cl.uchile.dcc.scrabble.types;

/**
 * This interface contains mathematical operations for Scr objects (int and float)
 * It contains additions, subtractions, multiplications and divitions
 *
 * @author Felix Melo Aviles
 */
public interface IOperations {

    /**
     * Adds a Scr number with another Scr Object
     * @param num the object to be added
     * @return a new Scr number with the result
     */
    public IOperations add(IOperations num);

    /**
     * Adds this object to a ScrFloat, returning a new ScrFloat with the result
     * @param num a ScrFloat to be added with this object
     * @return a ScrFloat containing the result of the operation
     */
    public ScrFloat addToScrFloat(ScrFloat num);

    /**
     * Adds this object to a ScrInt, returning the same type
     * @param num a ScrInt to be added with this object
     * @return a Scr object containing the result of the operation
     */
    public IOperations addToScrInt(ScrInt num);

    /**
     * Subtract a Scr number with another Scr Object
     * @param num the object to be subtracted
     * @return a new Scr number with the result
     */
    public IOperations subtract(IOperations num);

    /**
     * Subtracts this object to a ScrFloat, returning a new ScrFloat with the result
     * @param num a ScrFloat to be subtracted by this object
     * @return a ScrFloat containing the result of the operation
     */
    public ScrFloat subtractToScrFloat(ScrFloat num);

    /**
     * Subtracts this object to a ScrInt, returning a new object of the same type
     * @param num a ScrInt to be subtracted by this object
     * @return a Scr object containing the result of the operation
     */
    public IOperations subtractToScrInt (ScrInt num);

    /**
     * Multiplies a Scr number with another Scr number
     * @param num the object to multiply this object by
     * @return a Scr object containing the result of the operation
     */
    public IOperations multiply(IOperations num);

    /**
     * Multiply a ScrInt by this object, returning the same type
     * @param num a ScrInt to be multiplied by this object
     * @return a Scr object containing the result of the operation
     */
    public IOperations mulAScrInt (ScrInt num);

    /**
     * Multiply a ScrFloat by this object, returning a new ScrFloat
     * @param num a ScrFloat to be multiplied by this object
     * @return a ScrFloat containing the result of the operation
     */
    public ScrFloat mulAScrFloat (ScrFloat num);

    /**
     * Divides a Scr number with another Scr number
     * @param num the object to divide this object by
     * @return a Scr object containing the result of the operation
     */
    public IOperations divide(IOperations num);

    /**
     * Divide a ScrInt by this object, returning an object of the same type
     * @param num the ScrInt to divide
     * @return a Scr object with the result of the operation
     */
    public IOperations divideAScrInt (ScrInt num);

    /**
     * Divide a ScrFloat by this object, returning a new ScrFloat
     * @param num the ScrFloat to divide
     * @return a ScrFloat with the result
     */
    public ScrFloat divideAScrFloat (ScrFloat num);


}
