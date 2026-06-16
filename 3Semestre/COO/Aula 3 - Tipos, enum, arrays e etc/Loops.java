public class Loops {
    int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public int calculateSum() {
        int sum1 = 0;

        for (int x : a) {
            sum1 += x;
        }

        return sum1;
    }
}
