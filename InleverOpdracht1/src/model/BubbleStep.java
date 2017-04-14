package model;

public class BubbleStep implements SortingAlgorithmInterface{

    public int[] doStep(int[] array){
        Boolean sorted = true;
        while (sorted){
            sorted = false;
            for (int i = 0; i < array.length - 1; i++){
                if (array[i] > array[i + 1]){
                    Integer temporaryI = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temporaryI;
                    break;
                }
            }
        }
        return array;
    }
}
