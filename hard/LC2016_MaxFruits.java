public class LC2016_MaxFruits {

        public int maxTotalFruits(int[][] fruits, int startPos, int k) {
            int n = fruits.length;
            int left = 0, right = 0;
            int total = 0, maxFruits = 0;

            while (right < n) {
                total += fruits[right][1];

                while (left <= right && !canReach(fruits[left][0], fruits[right][0], startPos, k)) {
                    total -= fruits[left][1];
                    left++;
                }

                maxFruits = Math.max(maxFruits, total);
                right++;
            }

            return maxFruits;
        }

        private boolean canReach(int leftPos, int rightPos, int startPos, int k) {
            int option1 = Math.abs(startPos - leftPos) + (rightPos - leftPos);
            int option2 = Math.abs(rightPos - startPos) + (rightPos - leftPos);

            return Math.min(option1, option2) <= k;
        }

}
