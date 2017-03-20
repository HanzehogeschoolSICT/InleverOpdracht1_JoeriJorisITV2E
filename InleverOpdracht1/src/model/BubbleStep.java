package model;

public class BubbleStep {

    public static int[] bubbleStep(int[] list){
        Boolean sorted = true;
        while (sorted){
            sorted = false;
            for (int i = 0; i < list.length - 1; i++){
                if (list[i] > list[i + 1]){
                    Integer temporaryI = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temporaryI;
//                    return list;
                    break;
                }
                sorted = true;
            }
        }
        return list;
    }
}
