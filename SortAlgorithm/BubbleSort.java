public class BubbleSort {
    public static void main(String[] args) {
        int a[] = { 2, 3, 6, 4, 0, 1, 7, 8, 5, 9 };
        System.out.print("Unsorted：");
        for(int i:a) {
            System.out.print(i+" ");
        }        
        startSort(a);
    }

    public static void toString(int[] a) {
        System.out.print("\n  Sorted：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static void startSort(int[] a) {
        int temp = 0;
        for (int j = 0; j < a.length - 1; j++) {
            for (int i = 0; i < a.length - 1 - j; i++) {
                if (a[i] > a[i + 1]) {
                    //比较相邻的元素。如果第一个比第二个大，就交换位置。
                    temp = a[i + 1];
                    a[i + 1] = a[i];
                    a[i] = temp;
                }
            }
        }
        toString(a);
    }
}