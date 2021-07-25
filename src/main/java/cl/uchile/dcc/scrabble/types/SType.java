package cl.uchile.dcc.scrabble.types;

public interface SType {
    ScrString toScrString();

    ScrString addToString(ScrString addend);

}
