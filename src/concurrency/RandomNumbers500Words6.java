package concurrency;

import java.util.Random;

/**
 *
 * @author oladele
 */
public class RandomNumbers500Words6 {
  
    public static void main(String[] args) {
        new GenerateRandomWords6(6, 500).start();
        new GenerateRandomNumbers500(10000, 5000, 700).start();
    }//end main()

}//end class RandomNumbersAndWords

class GenerateRandomWords6 extends Thread {

    int wordSize;
    int numberOfWords;
    char alphabet[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public GenerateRandomWords6(int wordSize, int numberOfWords) {

        this.wordSize = wordSize;
        this.numberOfWords = numberOfWords;
    }

    @Override
    public void run() {

        Random r = new Random();
        String aWord = "";

        for (int j = 0; j < numberOfWords; j++) {
            for (int i = 0; i <= 5; i++) {
                aWord += String.valueOf(alphabet[r.nextInt(26)]);
            }//end inner for

            System.out.println(aWord);

            aWord = "";

        }//end outer for
    }//end run
}//end class GenerateRandomWords

class GenerateRandomNumbers500 extends Thread {

    int upperBound;
    int lowerBound;
    int numberOfValues;

    Random r = new Random();

    public GenerateRandomNumbers500(int upperBound, int lowerBound, int numberOfValues) {
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

