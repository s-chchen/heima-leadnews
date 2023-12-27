package cch.order.v1;

public class MaoPao {

    public static void main(String[] args) {
        int[] arr1 = {33, 45, 1, 2, 4, 25,45,25,66};
        int[] arr2 = {33, 45, 123, 123, 123, 232325,45,25,66};

//        bubbleSort(arr1);

//        insertSort(arr1);

//        quickSort(arr2, 0, arr2.length - 1);
//        selectionSort(arr2);
        heapSort(arr2);

        for (int i : arr2) {
            System.out.println(i);
        }
    }

    /**
     * 冒泡排序
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int length = arr.length;

        for (int i = 0; i < length; i++) {
            int innerLength = length - i - 1;

            for (int j = 0; j < innerLength; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


    /**
     * 插入排序
     * @param arr
     */
    public static void insertSort(int arr[]) {
        int length = arr.length;

        for (int i = 1; i < length; i++) {

            for (int j = i; j > 0 && arr[j-1] > arr[j]; j--) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }

        }
    }


    /**
     * 快速排序
     * @param arr
     * @param begin
     * @param end
     */
    public static void quickSort(int[] arr, int begin, int end) {
        if (begin >= end) return;

        int cursor = arr[begin];
        int i = begin;
        int j= end;

        while(i < j) {

            while(i<j && arr[j] >= cursor) {
                j--;
            }
            while (i<j && arr[i] <= cursor) {
                i++;
            }

            if (i<j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }

        arr[begin] = arr[i];
        arr[i] = cursor;

        quickSort(arr, begin, end - 1);
        quickSort(arr, begin + 1, end);
    }


    /**
     * 简单选择排序
     * @param arr
     */
    public static void selectionSort(int arr[]) {
        int length = arr.length;

        for (int i = 0; i < arr.length; i++) {

            int min_idx = i;
            int min =arr[i];

            int j = i+1;
            for (; j < length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    min_idx = j;
                }
            }

            if (min_idx != i) {
                int temp = arr[i];
                arr[i] =min;
                arr[min_idx] = temp;
            }
        }
    }


    /**
     * 堆排序
     * @param arr
     */
    public static void heapSort(int arr[]) {
        int length = arr.length;

        /* 初始化大根堆 */
        for (int i = length/2 - 1; i>=0; i--) {
            heapAdjust(arr, i, length);
        }

        /* 堆排序 */
        for (int i = length-1; i>0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapAdjust(arr, 0, i);
        }
    }

    /**
     * 调正大根堆
      * @param arr
     * @param i
     * @param length
     */
    public static void heapAdjust(int arr[], int i, int length) {

        int left = i*2 +1;
        int right = i*2 +2;
        int max_idx = i;

        if (left < length && arr[max_idx] < arr[left]) {
            max_idx = left;
        }
        if (right < length && arr[max_idx] < arr[right]) {
            max_idx = right;
        }

        if (max_idx != i) {
            int temp = arr[max_idx];
            arr[max_idx] = arr[i];
            arr[i] = temp;

            heapAdjust(arr, max_idx, length);

        }

    }

}
