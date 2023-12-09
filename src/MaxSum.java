import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaxSum {

        private static int maxSumUtil(ArrayList<Integer> arr) {
            int maxNo = 0;
            for(int i = 0; i < arr.size(); i+=2) {
                if(i == arr.size()-1) {
                    maxNo += arr.get(i);
                } else {
                    maxNo += Math.max(arr.get(i) + arr.get(i + 1), arr.get(i) * arr.get(i + 1));
                }
            }
            return maxNo;
        }

        private static int maximumSum(Integer[] arr) {
        Arrays.sort(arr, Collections.reverseOrder());
//        System.out.println(Arrays.toString(arr));

        // negative list will be in ascending form including 0
        ArrayList<Integer> negativeList = new ArrayList<>();

        // positive list will be in descending form
        ArrayList<Integer> positiveList = new ArrayList<>();

        for(int num: arr) {
            var a = num < 1 ? negativeList.add(num) : positiveList.add(num);
        }
        Collections.sort(negativeList);
        return maxSumUtil(negativeList) + maxSumUtil(positiveList);
    }

    public static void main(String[] args) {
//        Integer[] arr = {-3, -4, 2, 1 ,0, 0, 0,3, -2};
//        Integer[] arr = {-1, -2, -3, -4, 0, 0, -1};
        Integer[] arr = {-1, -2, -3, -4, -4,0, -1};

//        Integer[] arr = new Integer[7];
//        Scanner sc = new Scanner(System.in);
//        for(int i=0; i<arr.length; i++) {
//            arr[i] = sc.nextInt();
//        }

        System.out.println(maximumSum(arr));
    }
}
