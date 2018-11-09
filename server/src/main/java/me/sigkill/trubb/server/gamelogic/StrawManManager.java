package me.sigkill.trubb.server.gamelogic;

import me.sigkill.trubb.common.exceptions.CharacterAlreadyGuessedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martin Engström on 2018-11-08.
 */
public class StrawManManager {
    private GameState state;

    public StrawManManager() {
        state = new GameState();
        state.setRunning(false);
        state.setTriesRemaining(10);
        state.setWord(WordUtil.getRandomWord());
        state.setChars(new ArrayList<>());
    }

    public GameState getState() {
        return state;
    }

    public void guess(Character c) throws CharacterAlreadyGuessedException {
        if (state.chars.contains(c))
            throw new CharacterAlreadyGuessedException("Char already guessed");

        if (state.getTriesRemaining().equals(0)) {
            state.setRunning(false);
            return;
        }

        state.chars.add(c);
        if (state.getWord().indexOf(c) < 0) {
            state.setTriesRemaining(state.getTriesRemaining() - 1);
        }
    }

    public static class GameState {
        private boolean running;
        private String word;
        private Integer triesRemaining;
        private List<Character> chars;

        public boolean isRunning() {
            return running;
        }

        public void setRunning(boolean running) {
            this.running = running;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public List<Character> getChars() {
            return chars;
        }

        public void setChars(List<Character> chars) {
            this.chars = chars;
        }

        public Integer getTriesRemaining() {
            return triesRemaining;
        }

        public void setTriesRemaining(Integer triesRemaining) {
            this.triesRemaining = triesRemaining;
        }
    }
}
