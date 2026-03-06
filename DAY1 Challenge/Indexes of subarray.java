import java.util.*;
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        int start = 0; 
        int sum = 0;
        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];
            while (sum > target && start < end) {
                sum -= arr[start];
                start++;
            }
            if (sum == target) {
                // 1-based index, so add +1
                result.add(start + 1);
                result.add(end + 1);
                return result;
            }
        }
        result.add(-1);
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> ans = subarraySum(arr, target);
        System.out.println(ans);
    }
}
