import java.util.Arrays;
import java.util.Collections;

public class MaxSum2 {

    public static Integer[] getSliceOfArray(Integer[] arr, int start, int end) {
        Integer[] slicedArray = new Integer[end - start];
        for (int i = 0; i < slicedArray.length; i++) {
            slicedArray[i] = arr[start + i];
        }
        return slicedArray;
    }

    private static int maxSumUtil(Integer[] arr) {
        if(arr.length != 0 && arr[0] == 0) {
            Arrays.sort(arr);
        }

        int maxNo = 0;
        for(int i = 0; i < arr.length; i+=2) {
            if(i == arr.length-1) {
                maxNo += arr[i];
            } else {
                maxNo += Math.max(arr[i] + arr[i + 1], arr[i] * arr[i + 1]);
            }
        }
        return maxNo;
    }

    private static int maximumSum(Integer[] arr) {
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
        int index = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] < 1) {
                index = i;
                break;
            }
        }
        return maxSumUtil(getSliceOfArray(arr, 0, index)) +
                maxSumUtil(getSliceOfArray(arr, index, arr.length));
    }

    public static void main(String[] args) {
        Integer[] arr = {-1, -2, -3, -4, -4,0, -1};
        System.out.println(maximumSum(arr));
    }
}
