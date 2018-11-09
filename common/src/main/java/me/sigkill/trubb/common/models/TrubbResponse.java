package me.sigkill.trubb.common.models;

import java.io.Serializable;

/**
 * Created by Martin Engström on 2018-11-08.
 */
public class TrubbResponse implements Serializable {
    private String herp;
    private String derp;

    public String getHerp() {
        return herp;
    }

    public void setHerp(String herp) {
        this.herp = herp;
    }

    public String getDerp() {
        return derp;
    }

    public void setDerp(String derp) {
        this.derp = derp;
    }
}
