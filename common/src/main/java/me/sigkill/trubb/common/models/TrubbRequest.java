package me.sigkill.trubb.common.models;

import java.io.*;
import java.net.Socket;

/**
 * Created by Martin Engström on 2018-11-08.
 */
public class TrubbRequest implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}