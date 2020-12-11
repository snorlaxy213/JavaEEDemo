package sorting;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {
    
    private static int binarySearch(List<Integer> targetList, Integer target){
        // Collections.binarySearch(list, key)
        int low = 0;
        int high = targetList.size() - 1;
        
        while(low <= high){
            int mid = (low + high) >>> 1;
            int cmp = targetList.get(mid);

            if(cmp > target) {
                high = mid - 1;
            } else if(cmp < target){
                low = mid + 1;
            } else if(cmp == target){
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,13,4,7,6,9,7,15);
        System.out.println(binarySearch(list, 15));
    }
}
