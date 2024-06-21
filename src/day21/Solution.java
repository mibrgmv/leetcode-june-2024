package day21;

public class Solution {
    /**
     * day 21
     * 1052. Grumpy Bookstore Owner (Medium)
     * Runtime: 91.51%
     * Memory: 78.34%
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int baseSatisfied = 0;
        for (int i = 0; i < n; ++i) {
            if (grumpy[i] == 0) {
                baseSatisfied += customers[i];
            }
        }

        int satisfiedExtra = 0;
        for (int i = 0; i < minutes; ++i) {
            if (grumpy[i] == 1) {
                satisfiedExtra += customers[i];
            }
        }

        int maxSatisfiedExtra = satisfiedExtra;
        for (int i = 1; i + minutes <= n; ++i) {
            if (grumpy[i - 1] == 1) {
                satisfiedExtra -= customers[i - 1];
            }
            if (grumpy[i + minutes - 1] == 1) {
                satisfiedExtra += customers[i + minutes - 1];
            }
            maxSatisfiedExtra = Math.max(maxSatisfiedExtra, satisfiedExtra);
        }

        return baseSatisfied + maxSatisfiedExtra;
    }
}
