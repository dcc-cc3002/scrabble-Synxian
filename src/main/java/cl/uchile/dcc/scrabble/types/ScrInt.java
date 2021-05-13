package cl.uchile.dcc.scrabble.types;

import java.util.Objects;

public class ScrInt {
    int scrInt;

    public ScrInt(int entero){
        this.scrInt=entero;
    }

    @Override
    public String toString() {
        return String.valueOf(this.scrInt);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrInt scrInt1 = (ScrInt) o;
        return scrInt == scrInt1.scrInt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(scrInt);
    }

    public ScrFloat intToFloat(){
        return new ScrFloat(Double.valueOf(this.scrInt));
    }

    public ScrInt intToInt(){
        return new ScrInt(this.scrInt);
    }

    public ScrString intToString(){
        return new ScrString(String.valueOf(this.scrInt));
    }

    public ScrBinary intToBinary(){
        return null;
    }

    public int getValue(){
        return this.scrInt;
    }
}