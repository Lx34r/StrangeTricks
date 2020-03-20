public class Merge_sort {
    /*=========归并排序=========
	1.申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
	2.设定两个指针，最初位置分别为两个已经排序序列的起始位置
	3.比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
	重复步骤3直到某一指针超出序列尾
	将另一序列剩下的所有元素直接复制到合并序列尾
	*/

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<? super T>> void mergeSort(T[] arr) {
        T[] tmpArray = (T[]) new Comparable[arr.length];
        mergeSort(arr, tmpArray, 0, arr.length - 1);
    }

    /**
     * @param arr      an array of Comparable items
     * @param tmpArray an array to place the merge result
     * @param left     the left-most index of the array
     * @param right    right-most index of the array
     */
    private static <T extends Comparable<? super T>> void mergeSort(T[] arr,
                                                                    T[] tmpArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(arr, tmpArray, left, center);
            mergeSort(arr, tmpArray, center + 1, right);
            merge(arr, tmpArray, left, center + 1, right);
        }
    }

    /**
     * @param arr      需排序数字（比较大小）的数组
     * @param tmpArray 放置合并结果的数组
     * @param leftPos  the left-most index of the subarray
     * @param rightPos the index of the start of the second half
     * @param rightEnd the right-most index of the subarray
     */
    private static <T extends Comparable<? super T>> void merge(T[] arr,
                                                                T[] tmpArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int numElements = rightEnd - leftPos + 1;
        int tmpPos = leftPos;// 只使用tmpArray中某一部分区域
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (arr[leftPos].compareTo(arr[rightPos]) <= 0)
                tmpArray[tmpPos++] = arr[leftPos++];
            else
                tmpArray[tmpPos++] = arr[rightPos++];
        }

        while (leftPos <= leftEnd)
            tmpArray[tmpPos++] = arr[leftPos++];// copy rest of left half
        while (rightPos <= rightEnd)
            tmpArray[tmpPos++] = arr[rightPos++];// copy rest of right half

        // copy tmpArray back
        for (int i = 0; i < numElements; i++, rightEnd--)
            arr[rightEnd] = tmpArray[rightEnd];//只拷贝当前 merge 的部分数组

        /**
         * 复制了整个数组中的所有元素 
         for(int i = 0; i < tmpArray.length; i++)
         arr[i] = tmpArray[i];
         */
    }

    public static void main(String[] args) {
        Integer[] arr = {24, 13, 26, 1, 2, 27, 38, 15};
        System.out.print("Unsorted：");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.print("\n  Sorted：");
        mergeSort(arr);
        for (Integer i : arr)
            System.out.print(i + " ");
    }
}