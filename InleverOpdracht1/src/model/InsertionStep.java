package model;

import view.GuiAttributes;


public class InsertionStep {
//    public static int[] insertionStep(int[] list) {
//    //inspiratie: http://www.java2novice.com/java-sorting-algorithms/insertion-sort/
//        int temporary;
//        for (int i = 1; i < list.length; i++) {
//            for (int j = i; j > 0; j--) {
//                if (list[j] < list[j - 1]) {
//                    temporary = list[j];
//                    list[j] = list[j - 1];
//                    list[j - 1] = temporary;
//                    break;
//                }
//                break;
//            }
//        }
//        return list;
//    }
//}

    public static int[] insertionStep(int[] array) {
        //inspiratie: http://www.algolist.net/Algorithms/Sorting/Insertion_sort
        int i;
        int j;
        int newValue;
        for (i = 1; i < array.length; i++) {
            newValue = array[i];
            j = i;
            while (j > 0 && array[j - 1] > newValue) {
                array[j] = array[j - 1];
                j--;
                break;
            }
            array[j] = newValue;
        }
        return array;
    }
}
