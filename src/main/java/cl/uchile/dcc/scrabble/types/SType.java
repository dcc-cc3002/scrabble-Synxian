package cl.uchile.dcc.scrabble.types;

import cl.uchile.dcc.scrabble.types.numbers.IOperations;


public interface SType {
    ScrString toScrString();

    ScrString addToString(ScrString addend);

}
