package cl.uchile.dcc.scrabble.types;

import java.util.Objects;

public class ScrString {
    String scrString;


    public ScrString(String newString){
        this.scrString=newString;
    }

    @Override
    public String toString() {
        return this.scrString;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrString scrString1 = (ScrString) o;
        return Objects.equals(scrString, scrString1.scrString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scrString);
    }

    public ScrString stringToString(){
        return new ScrString(this.scrString);
    }

    public String getValue(){
        return this.scrString;
    }
}
