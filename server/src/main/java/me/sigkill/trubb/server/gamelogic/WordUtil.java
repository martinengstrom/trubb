package me.sigkill.trubb.server.gamelogic;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
}
