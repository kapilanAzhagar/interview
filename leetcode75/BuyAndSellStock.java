package blind75;

public class BuyAndSellStock {

    public static void main(String[] args) {
        int[] inputItems = {7,1,5,6,4};
        int output = 5;
        int maxProfit = getMaxProfit(inputItems);
        System.out.println("maxProfit:"+maxProfit);

    }

    private static int getMaxProfit(int[] inputItems) {

        int min = inputItems[0];
        int profit = 0;

        for(int i=0;i<inputItems.length;i++){
            if(inputItems[i]<min){
                min = inputItems[i];
            }
            profit = Math.max(profit,inputItems[i]-min);
        }
        return profit;
    }

}
