package blind75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumProgram {

    public static void main(String[] args) {
        int[] inputList = {2,5,6,8,9};
        int target = 13;
        int[] outputIndices = getTwoSum(inputList, target);
        System.out.println("TWO sum indices:"+ Arrays.toString(outputIndices));
    }

    private static int[] getTwoSum(int[] inputList, int target) {

       Map<Integer, Integer>sourceMap = new HashMap<Integer,Integer>();
       for(int i=0;i<inputList.length;i++){
           int compliment = target - inputList[i];
           if(sourceMap.containsKey(compliment)){
               return new int[] {sourceMap.get(compliment),i};
           }else{
               sourceMap.put(inputList[i],i);
           }
       }

        return new int[0];
    }
}
