package leecode;

import java.util.*;

public class KSumJavaTest {

    public static void main(String[] args) {

        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> result = KSumJava.kSum(nums, 0, 4);
        System.out.println();

        for(var a : Arrays.asList(1,2,3)){
            System.out.println(a);
        }
    }
}
