package model;

public class InsertionStep implements SortingAlgorithmInterface{

    public int[] doStep(int[] array) {
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
