package cl.uchile.dcc.scrabble.types;

import java.util.Objects;

public class ScrFloat {
    double scrFloat;

    public ScrFloat(double newFloat){
        this.scrFloat=newFloat;
    }

    @Override
    public String toString() {
        return String.valueOf(this.scrFloat);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrFloat scrFloat1 = (ScrFloat) o;
        return Double.compare(scrFloat1.scrFloat, scrFloat) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(scrFloat);
    }

    public ScrString floatToString(){
        return new ScrString(this.toString());
    }

    public ScrFloat floatToFloat(){
        return new ScrFloat(this.scrFloat);
    }

    public double getValue(){
        return this.scrFloat;
    }
}
