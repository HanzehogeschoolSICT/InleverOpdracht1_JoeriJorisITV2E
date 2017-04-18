package model;

import java.util.Stack;

public class QuickStep implements SortingAlgorithmInterface{
    //inspiratie: http://javarevisited.blogspot.nl/2016/09/iterative-quicksort-example-in-java-without-recursion.html

    public int[] doStep(int[] array) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        stack.push(array.length);

        while (!stack.isEmpty()){
            int end = stack.pop();
            int start = stack.pop();
            if(end - start < 2){
                continue;
            }
            int part = start + ((end - start) / 2);
            part = partition(array, part, start, end);

            stack.push(part + 1);
            stack.push(end);

            stack.push(start);
            stack.push(part);
        }
        return array;
    }

    private static int partition(int[] input, int position, int start, int end){
        int i = start;
        int j = end - 2;
        int pivot = input[position];
        swap(input, position, end - 1);

        while (i < j){
            if(input[i] < pivot){
                i++;
            } else if (input[j] >= pivot){
                j--;
            } else {
                swap(input, i, j);
            }
        }
        int idx = j;
        if (input[j] < pivot){
            idx++;
        }
        swap(input, end - 1, idx);
        return idx;
    }

    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
