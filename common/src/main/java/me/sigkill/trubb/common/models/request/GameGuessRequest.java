package me.sigkill.trubb.common.models.request;

import java.io.Serializable;

/**
 * Created by Martin Engström on 2018-11-08.
 */
public class GameGuessRequest implements Serializable {
    public Character getLetter() {
        return letter;
    }

    public void setLetter(Character letter) {
        this.letter = letter;
    }

    private Character letter;
}
