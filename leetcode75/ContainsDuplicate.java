package blind75;

import java.util.HashSet;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] inputList = {1,2,4,5,3};
        boolean isDuplicateAvailable = isDuplicateAvailable(inputList);
        System.out.println("isDuplicateAvailable:"+isDuplicateAvailable);
    }

    private static boolean isDuplicateAvailable(int[] inputList) {
        HashSet<Integer> sourceSet = new HashSet<Integer>();
        for(int i=0;i<inputList.length;i++){
            if(sourceSet.contains(inputList[i])){
                return true;
            }else{
                sourceSet.add(inputList[i]);
            }
        }
        return false;
    }
}
