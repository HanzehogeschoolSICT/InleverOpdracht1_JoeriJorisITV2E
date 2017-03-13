package model;

public class InsertionStep {
    public static int[] insertionStep(int[] list) {
    //inspiratie: http://www.java2novice.com/java-sorting-algorithms/insertion-sort/
        int temporary;
        for (int i = 1; i < list.length; i++) {
            for (int j = i; j > 0; j--) {
                if (list[j] < list[j - 1]) {
                    temporary = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = temporary;
                }
            }
        }
        return list;
    }
}
