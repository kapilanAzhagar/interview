package blind75;

import java.util.Arrays;

public class ProductOfArrayExceptIteself {

    public static void main(String[] args) {
        int[] inputList = {3,4,3,1,2};
        int[] outPutList = findProductOfArrayExceptItself(inputList);
        System.out.println("outPutList"+ Arrays.toString(outPutList));


    }

    private static int[] findProductOfArrayExceptItself(int[] nums) {

        int result[] = new int[nums.length];

        int prefix = 1;
        for(int i=0;i<nums.length;i++){
            result[i] = prefix;
            prefix = prefix * nums[i];
        }

        int postfix = 1;
        for(int i=nums.length-1;i>=0;i--){
            result[i] = postfix * result[i];
            postfix = postfix * nums[i];
        }

        return result;



    }


}
