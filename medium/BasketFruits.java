import java.util.HashMap;

public class BasketFruits {
    public int totalFruit(int[] fruits) {
        int n= fruits.length;
        int start=0, end=0,curr=0,maxLength=Integer.MIN_VALUE;
        HashMap<Integer,Integer> basket=new HashMap<>();
        while (end<n)
        {
            basket.put(fruits[end],basket.getOrDefault(fruits[end],0)+1);
            while (basket.size()>=3)
            {
                basket.put(fruits[start],basket.get(fruits[start])-1);
                if(basket.get(fruits[start])==0) basket.remove(fruits[start]);
                start++;
            }
            curr=end-start+1;
            maxLength= Math.max(maxLength,curr);
            end++;
        }
        return maxLength;
    }
}
