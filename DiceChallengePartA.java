public class DiceChallengePartA {

    public static void main(String[] args) {
        // 1. How many total combinations are possible? Show the math along with the code!
        int totalCombinations = 6 * 6;
        System.out.println("Total Combinations: " + totalCombinations);

        // 2. Calculate and display the distribution of all possible combinations.
        // Hint: A 6 x 6 Matrix.
        int[][] combinationsDistribution = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                combinationsDistribution[i][j] = i + j + 2;
            }
        }
        System.out.println("Combinations Distribution:");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(combinationsDistribution[i][j] + " ");
            }
            System.out.println();
        }

        // 3. Calculate the Probability of all Possible Sums occurring among the number of combinations from (2).
        // Example: P(Sum = 2) = 1/X as there is only one combination possible to obtain Sum = 2. Die A = Die B = 1.
        double[] probabilityDistribution = new double[11];
        for (int i = 2; i <= 12; i++) {
            int count = 0;
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    if (combinationsDistribution[j][k] == i) {
                        count++;
                    }
                }
            }
            probabilityDistribution[i - 2] = (double) count / totalCombinations;
        }
        System.out.println("Probability Distribution:");
        for (int i = 0; i < probabilityDistribution.length; i++) {
            System.out.printf("P(Sum = %d) = %.4f\n", i + 2, probabilityDistribution[i]);
        }
    }
}
