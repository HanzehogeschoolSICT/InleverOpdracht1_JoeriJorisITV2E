package model;

import java.util.Random;

public class ArrayCreation {

    public int[] createArray(int length) {
        int[] array = new int[length];
        for (int i = 0;i < length; i++){
            array[i] = i;
        }

        //Inspiratie: http://www.programcreek.com/2012/02/java-method-to-shuffle-an-int-array-with-random-order/
        Random rgen = new Random();
        for (int i=0; i<array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }
        return array;
    }
}

