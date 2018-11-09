package me.sigkill.trubb.client;

/**
 * Created by Martin Engström on 2018-11-08.
 */
public class AsciiArtHelper {
    // 9 steps
    private void printFirst() {
        System.out.println("            	");
        System.out.println("               	");
        System.out.println("               	");
        System.out.println("                ");
        System.out.println("                ");
        System.out.println("     			");
        System.out.println("     			");
    }

    private void printSecond() {
        System.out.println("            	");
        System.out.println("    |          	");
        System.out.println("    |         	");
        System.out.println("    |           ");
        System.out.println("    |           ");
        System.out.println("    |			");
        System.out.println("    |			");
    }

    private void printThird() {
        System.out.println("    _________	");
        System.out.println("    |          	");
        System.out.println("    |          	");
        System.out.println("    |           ");
        System.out.println("    |           ");
        System.out.println("    |			");
        System.out.println("    |			");
    }

    private void printFourth() {
        System.out.println("    _________	");
        System.out.println("    |         |	");
        System.out.println("    |          	");
        System.out.println("    |           ");
        System.out.println("    |           ");
        System.out.println("    |			");
        System.out.println("    |			");
    }

    private void printFifth() {
        System.out.println("    _________	");
        System.out.println("    |         |	");
        System.out.println("    |         0	");
        System.out.println("    |           ");
        System.out.println("    |           ");
        System.out.println("    |			");
        System.out.println("    |			");
    }

    private void printSixth() {
        System.out.println("    _________	");
        System.out.println("    |         |	");
        System.out.println("    |         0	");
        System.out.println("    |         | ");
        System.out.println("    |           ");
        System.out.println("    |			");
        System.out.println("    |			");
    }

    private void printSeventh() {
        System.out.println("    _________	");
        System.out.println("    |         |	");
        System.out.println("    |         0	");
        System.out.println("    |        /| ");
        System.out.println("    |           ");
        System.out.println("    |			");
        System.out.println("    |			");
    }

    private void printEigth() {
        System.out.println("    _________	");
        System.out.println("    |         |	");
        System.out.println("    |         0	");
        System.out.println("    |        /|\\");
        System.out.println("    |           ");
        System.out.println("    |			");
        System.out.println("    |			");
    }

    private void printNinth() {
        System.out.println("    _________	");
        System.out.println("    |         |	");
        System.out.println("    |         0	");
        System.out.println("    |        /|\\");
        System.out.println("    |        /  ");
        System.out.println("    |			");
        System.out.println("    |			");
    }

    private void printLast() {
        System.out.println("    _________	");
        System.out.println("    |         |	");
        System.out.println("    |         0	");
        System.out.println("    |        /|\\");
        System.out.println("    |        / \\");
        System.out.println("    |			");
        System.out.println("    |			");
    }

    public void print(Integer trie) {
        switch(trie) {
            case 0:
                printFirst();
                break;
            case 1:
                printSecond();
                break;
            case 2:
                printThird();
                break;
            case 3:
                printFourth();
                break;
            case 4:
                printFifth();
                break;
            case 5:
                printSixth();
                break;
            case 6:
                printSeventh();
                break;
            case 7:
                printEigth();
                break;
            case 8:
                printNinth();
                break;
            case 9:
                printLast();
                break;
        }
    }
}
