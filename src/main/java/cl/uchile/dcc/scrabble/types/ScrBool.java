package cl.uchile.dcc.scrabble.types;

import java.util.Objects;

public class ScrBool{
    boolean scrBool;

    public ScrBool(boolean newBool){
        this.scrBool=newBool;
    }

    @Override
    public String toString() {
        return String.valueOf(this.scrBool);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrBool scrBool1 = (ScrBool) o;
        return scrBool == scrBool1.scrBool;
    }

    @Override
    public int hashCode() {
        return Objects.hash(scrBool);
    }

    public ScrString boolToString(){
        return new ScrString(this.toString());
    }

    public ScrBool boolToBool(){
        return new ScrBool(this.scrBool);
    }

    public boolean getValue(){
        return this.scrBool;
    }
}