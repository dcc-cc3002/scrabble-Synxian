package cl.uchile.dcc.scrabble.types;

import java.util.Objects;

public class ScrBinary {
    public String scrBinary;
    public ScrBinary(String Binary){
        this.scrBinary=Binary;
    }

    @Override
    public String toString() {
        return this.scrBinary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrBinary scrBinary1 = (ScrBinary) o;
        return Objects.equals(scrBinary, scrBinary1.scrBinary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scrBinary);
    }

    public ScrString binaryToString(){
        return new ScrString(this.toString());
    }

    public ScrBinary binaryToBinary(){
        return new ScrBinary(this.scrBinary);
    }

    public ScrFloat binaryToFloat(){
        return null;
    }

    public ScrInt binaryToInt(){
        return null;
    }

    public String getValue(){
        return this.scrBinary;
    }
}