package cl.uchile.dcc.scrabble.types;

public abstract class AbstractType implements SType{
    @Override
    public ScrString addToString(ScrString addend) {
        return new ScrString(addend.toString()+this);
    }
}
