
public class LinearSearch {
    public static void main(String[] args) {

        int[] a = {10, 20, 30, 40, 50};
        int key = 50;
        int found = 0;

        for (int i = 0; i < 5; i++) {
            if (a[i] == key) {
                System.out.println("Found");
                found = 1;
                break;
            }
        }

        if (found == 0) {
            System.out.println("Not Found");
        }
    }
}
