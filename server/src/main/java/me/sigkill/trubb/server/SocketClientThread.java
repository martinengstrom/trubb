package me.sigkill.trubb.server;

import me.sigkill.trubb.common.exceptions.CharacterAlreadyGuessedException;
import me.sigkill.trubb.common.models.request.GameGuessRequest;
import me.sigkill.trubb.common.models.response.GameStateResponse;
import me.sigkill.trubb.server.gamelogic.StrawManManager;

import java.io.*;
import java.net.Socket;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Created by Martin Engström on 2018-11-08.
 */
public class SocketClientThread extends Thread {
    protected Socket socket;
    public SocketClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        StrawManManager strawManManager = new StrawManManager();
        ObjectOutputStream ous = null;
        ObjectInputStream ois = null;
        try {
            ous = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {}

        while (true) {
            try {
                //TrubbRequest res = (TrubbRequest)ois.readObject();
                //System.out.println(res.getName());

                if (!strawManManager.getState().isRunning()) {
                    // Game is starting
                    strawManManager.getState().setRunning(true);
                } else {
                    // game in progress
                    GameGuessRequest req = (GameGuessRequest) ois.readObject();
                    try {
                        strawManManager.guess(req.getLetter());
                    } catch (CharacterAlreadyGuessedException e) {
                        ous.writeObject(e);
                        ous.flush();
                    }
                }

                // Send state back to client
                ous.writeObject(getStateResponse(strawManManager));
                ous.flush();

            } catch (IOException e) {
                // Error parsing input
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                System.out.println(e);
                // ignored
            }
        }
    }

    private GameStateResponse getStateResponse(StrawManManager manager) {
        GameStateResponse response = new GameStateResponse();
        response.setCorrectGuessCount(0);
        response.setGuessedLetters(manager.getState().getChars().stream().map(x -> x.toString()).collect(Collectors.toList()));
        response.setScore(0);
        GameStateResponse.Tries tries = new GameStateResponse.Tries();
        tries.setRemaining(manager.getState().getTriesRemaining());
        tries.setTotal(10);
        response.setTries(tries);
        response.setWordLetterCount(manager.getState().getWord().length());
        return response;
    }
}