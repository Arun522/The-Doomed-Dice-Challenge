import java.util.Arrays;

public class DiceChallengePartB {

    public static void main(String[] args) {
        int[] undoomedDieA = {1, 2, 3, 4, 5, 6};
        int[] undoomedDieB = {1, 2, 3, 4, 5, 6};

        int[] newDieA = undoomDiceA(undoomedDieA, undoomedDieB);
        int[] newDieB = undoomDiceB(undoomedDieA, undoomedDieB);

        System.out.println("Original Die A: " + Arrays.toString(undoomedDieA));
        System.out.println("Original Die B: " + Arrays.toString(undoomedDieB));
        System.out.println("New Die A: " + Arrays.toString(newDieA));
        System.out.println("New Die B: " + Arrays.toString(newDieB));
    }

    private static int[] undoomDiceA(int[] dieA, int[] dieB) {
        int[] newDieA = Arrays.copyOf(dieA, dieA.length);

        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                int currentSum = i + j;
                int count = 0;

                for (int k = 0; k < 6; k++) {
                    for (int l = 0; l < 6; l++) {
                        if (dieA[k] + dieB[l] == currentSum) {
                            count++;
                        }
                    }
                }

                for (int k = 0; k < 6; k++) {
                    //newDieA[k] += count * (i == dieA[k]);
                    newDieA[k] += count * (i == dieA[k] ? 1 : 0);

                }
            }
        }

        for (int k = 0; k < 6; k++) {
            if (newDieA[k] > 4) {
                int diff = newDieA[k] - 4;
                newDieA[k] -= diff;

                for (int l = 0; l < 6; l++) {
                    if (l != k) {
                        newDieA[l] += diff;
                    }
                }
            }
        }

        return newDieA;
    }

    private static int[] undoomDiceB(int[] dieA, int[] dieB) {
        // Die B can have as many spots on a face as necessary i.e., even more than 6.
        return Arrays.copyOf(dieB, dieB.length);
    }
}
