package me.sigkill.trubb.common.exceptions;

import java.io.Serializable;

/**
 * Created by Martin Engström on 2018-11-08.
 */
public class GameNotInProgressException extends Exception implements Serializable {
    public GameNotInProgressException(String message) {
        super(message);
    }
}
