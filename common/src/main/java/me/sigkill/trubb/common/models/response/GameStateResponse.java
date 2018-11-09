package me.sigkill.trubb.common.models.response;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Martin Engström on 2018-11-08.
 */
/*
The server is only allowed to send state, e.g., number of letters in the word, correctly
guessed letters, number of remaining attempts, total score, etc. The server is not
allowed to send any part of the view, like for example a string saying “You have 2
attempts left”, instead the server must only send the number of remaining attempts,
and the client shall insert it in the user interface.
 */
public class GameStateResponse implements Serializable {
    private Tries tries;
    private Integer score;
    private Integer wordLetterCount;
    private Integer correctGuessCount;
    private List<String> guessedLetters;

    public Tries getTries() {
        return tries;
    }

    public void setTries(Tries tries) {
        this.tries = tries;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getWordLetterCount() {
        return wordLetterCount;
    }

    public void setWordLetterCount(Integer wordLetterCount) {
        this.wordLetterCount = wordLetterCount;
    }

    public Integer getCorrectGuessCount() {
        return correctGuessCount;
    }

    public void setCorrectGuessCount(Integer correctGuessCount) {
        this.correctGuessCount = correctGuessCount;
    }

    public List<String> getGuessedLetters() {
        return guessedLetters;
    }

    public void setGuessedLetters(List<String> guessedLetters) {
        this.guessedLetters = guessedLetters;
    }

    public static class Tries implements Serializable {
        private Integer remaining;
        private Integer total;

        public Integer getRemaining() {
            return remaining;
        }

        public void setRemaining(Integer remaining) {
            this.remaining = remaining;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }
    }
}
