package me.sigkill.trubb.server.gamelogic;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Martin Engström on 2018-11-08.
 */
public class WordUtil {
    public static String getRandomWord() {
        Scanner s = new Scanner(WordUtil.class.getClassLoader().getResourceAsStream("words.txt"));
        List<String> words = new ArrayList<>();
        while (s.hasNext())
            words.add(s.next());
        s.close();
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

    public static LinkedList<Character> getGuessedCharsList(List<Character> e, String word, Character notGuessed) {
        return word.chars().boxed().map(x -> new Character((char)x.intValue())).map(x -> e.contains(x) ? x : notGuessed).collect(Collectors.toCollection(LinkedList::new));
    }
}
