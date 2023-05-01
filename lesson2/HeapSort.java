package lesson2;
import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args){
        int[] array = new int[]{4,2,5,8,1,9,2,3,6,8,5};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void heapSort(int[] array) {
        int n = array.length;

        for(int i  = n / 2 - 1; i >= 0; i--)
            heapify(array, i , n);

        for (int i = n - 1; i >= 0; i--){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
    
            heapify(array, 0, i);
        }
    }


    private static void heapify(int[] array, int i, int n) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        int largest = i;
    
        if(left < n && array[left] > array[largest])
            largest = left;

        if(right < n && array[right] > array[largest])
            largest = right;
    
        if (i != largest){
          int temp = array[i];
          array[i] = array[largest];
          array[largest] = temp;
    
          heapify(array, largest, n);
        }
    }
}