package me.sigkill.trubb.common.exceptions;

import java.io.Serializable;

/**
 * Created by Martin Engström on 2018-11-09.
 */
public class CharacterAlreadyGuessedException extends Exception implements Serializable {
    public CharacterAlreadyGuessedException(String message) {
        super(message);
    }
}
