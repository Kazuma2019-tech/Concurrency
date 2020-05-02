package concurrency;

import java.util.Random;

/**
 *
 * @author oladele
 */
public class RandomNumbersAndWords {

    public static void main(String[] args) {
        new GenerateRandomWords(4, 100).start();
        new GenerateRandomNumbers(100000, 1000, 100).start();
    }//end main()

}//end class RandomNumbersAndWords

class GenerateRandomWords extends Thread {

    int wordSize;
    int numberOfWords;
    char alphabet[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public GenerateRandomWords(int wordSize, int numberOfWords) {

        this.wordSize = wordSize;
        this.numberOfWords = numberOfWords;
    }

    @Override
    public void run() {

        Random r = new Random();
        String aWord = "";

        for (int j = 0; j < numberOfWords; j++) {
            for (int i = 0; i <= 3; i++) {
                aWord += String.valueOf(alphabet[r.nextInt(26)]);
            }//end inner for

            System.out.println(aWord);

            aWord = "";

        }//end outer for
    }//end run
}//end class GenerateRandomWords

class GenerateRandomNumbers extends Thread {

    int upperBound;
    int lowerBound;
    int numberOfValues;

    Random r = new Random();

    public GenerateRandomNumbers(int upperBound, int lowerBound, int numberOfValues) {
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
        this.numberOfValues = numberOfValues;
    }

    @Override
    public void run() {

        int randNum = 0;

        for (int i = 0; i < numberOfValues; i++) {
            randNum = r.nextInt(upperBound - lowerBound) + lowerBound;
            System.out.println(randNum);
        }//end for

    }//end run()
}//end class GenerateRandomNumbers
