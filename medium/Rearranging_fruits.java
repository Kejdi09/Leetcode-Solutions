import java.util.*;

public class Rearranging_fruits {
        public long minCost(int[] basket1, int[] basket2) {
            Map< Integer , Integer > count = new HashMap<>();
            for ( int x : basket1) count.put(x , count.getOrDefault(x , 0) + 1 );
            for ( int x : basket2) count.put(x , count.getOrDefault(x , 0) + 1 );

            for (int freq : count.values()) {
                if ( freq % 2 != 0 ) return -1;
            }

            int globalMin = Integer.MAX_VALUE;

            for (int x : basket1) globalMin = Math.min( globalMin , x);
            for (int x : basket2) globalMin = Math.min( globalMin , x);

            Map <Integer, Integer> diff = new HashMap<>();
            for ( int x : basket1) diff.put(x , diff.getOrDefault(x , 0) +1);
            for ( int x : basket2) diff.put(x , diff.getOrDefault(x, 0) -1);

            List<Integer> extra = new ArrayList<>();
            for( Map.Entry <Integer, Integer> e : diff.entrySet()){
                int key = e.getKey() , val = e.getValue();
                for(int i = 0 ; i < Math.abs(val)/2 ; i++){
                    extra.add(key);
                }
            }

            Collections.sort(extra);
            long cost = 0;
            for(int i = 0 ; i < extra.size()/2 ; i++){
                cost += Math.min(extra.get(i), 2*globalMin);
            }
            return cost;
        }
}
