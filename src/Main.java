import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private static ArrayList<Integer> array = new ArrayList<>(10);
    public static void main(String[] args) {
        randomizeArray();
        System.out.println("original array:          " + array);
        System.out.println("selection sort solution: " + selectionSort(array));
    }

    public static ArrayList<Integer> selectionSort(ArrayList<Integer> arr) {
        for (int i = 0; i<arr.size(); i++) {
            int min = findMin(arr, i);
            swap(arr, min, i);
        }
        return arr;
    }

    //finds index of min int in array from index i to the end of the array
    public static int findMin(ArrayList<Integer> candy, int i) {
        //min is initialized as the first element in the given interval
        int min = i;
        //iterate through remaining elements in array
        for (int j = i+1; j<candy.size(); j++) {
            //check current array element val against min
            if (candy.get(j) < candy.get(min)) {
                //update min if less
                min = j;
            }
        }
        return min;
    }

    //swaps two elements in an array
    public static void swap(ArrayList<Integer> arr, int min, int i) {
        //creates temp variable to hold arr[i]
        int temp = arr.get(i);
        //sets arr[i] equal to arr[min]
        arr.set(i, arr.get(min));
        //sets arr[min] equal to temp -> previous arr[i]
        arr.set(min, temp);
    }

    //adds random elements to array to be sorted
    private static void randomizeArray() {
        for (int i = 0; i<10; i++) {
            array.add(ThreadLocalRandom.current().nextInt(0, 10 + 1));
        }
    }
}
