import java.util.Scanner;

public class insertionMerge {

    // -------- Insertion Sort --------
    static void insertionSort(int[] arr, int n){
        for(int i = 1; i < n; i++){
            int key = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // -------- Merge Sort --------
    static void mergeSort(int[] arr, int l, int r){
        if(l < r){
            int m = l + (r - l) / 2;   // safer mid calculation

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    static void merge(int[] arr, int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i = 0; i < n1; i++)
            L[i] = arr[l + i];

        for(int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;

        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while(i < n1){
            arr[k++] = L[i++];
        }

        while(j < n2){
            arr[k++] = R[j++];
        }
    }

    // -------- Main --------
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        System.out.println("Enter elements (space separated):");
        for(int i = 0; i < n; i++){
            arr1[i] = sc.nextInt();
        }

        // copy arr1 to arr2
        for(int i = 0; i < n; i++){
            arr2[i] = arr1[i];
        }

        // Sorting
        insertionSort(arr1, n);
        mergeSort(arr2, 0, n - 1);

        // Output
        System.out.println("\nSorted using Insertion Sort:");
        for(int i = 0; i < n; i++){
            System.out.print(arr1[i] + " ");
        }

        System.out.println("\n\nSorted using Merge Sort:");
        for(int i = 0; i < n; i++){
            System.out.print(arr2[i] + " ");
        }

        sc.close();
    }
}