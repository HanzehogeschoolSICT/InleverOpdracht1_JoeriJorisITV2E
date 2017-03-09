package model;

import java.util.Arrays;

public class ArrayCreation {

    public int[] createArray(int length) {
        int[] array = new int[length];
        for (int i = 0;i < length; i++){
            array[i] = i;
        }

//        for (int i = 0; i < array.length; i++) {
//            int random = (int) (Math.random() * array.length);
//            int tmp = Arrays.asList(array).indexOf(random);
//            array[random] = Arrays.asList(array).indexOf(i);
//            array[i] = tmp;
//        }

        return array;
    }
}

