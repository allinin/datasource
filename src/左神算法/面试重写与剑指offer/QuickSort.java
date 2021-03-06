package 左神算法.面试重写与剑指offer;

import java.util.Arrays;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * 重写quickSort,重点都是partation的过程
 * @date 2020/3/19 20:55
 */
public class QuickSort {

    public static void quickSort(int[] arr){
        if(arr==null || arr.length<2)
            return;
        quickSort(arr,0,arr.length-1);
    }

    private static void quickSort(int[] arr,int left,int right){
        if(left<right){
            //随机快排
            swap(arr,left+(int)(Math.random()*(right-left+1)),right);
            int[] ans=partation(arr,left,right);
            quickSort(arr,left,ans[0]-1);
            quickSort(arr,ans[1]+1,right);

        }
    }
    //以right位置的数为标准进行partation
    private static int[] partation(int[] arr,int left,int right){
        int less=left-1;
        int more=right;
        while(left<more){
            if(arr[left]<arr[right]){
                swap(arr,++less,left++);
            }else if(arr[left]>arr[right]){
                swap(arr,--more,left);
            }else{
                left++;
            }
        }
        swap(arr,more,right);
        return new int[]{less+1,more};
    }


    private static void swap(int[] arr,int left,int right){
        int tmp=arr[left];
        arr[left]=arr[right];
        arr[right]=tmp;
    }



    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
//        int testTime = 500000;
//        int maxSize = 100;
//        int maxValue = 100;
//        boolean succeed = true;
//        for (int i = 0; i < testTime; i++) {
//            int[] arr1 = generateRandomArray(maxSize, maxValue);
//            int[] arr2 = copyArray(arr1);
//            quickSort(arr1,0,arr1.length-1);
//            comparator(arr2);
//            if (!isEqual(arr1, arr2)) {
//                succeed = false;
//                printArray(arr1);
//                printArray(arr2);
//                break;
//            }
//        }
//        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
//
//        int[] arr = generateRandomArray(50, 100);
//        printArray(arr);
//        quickSort(arr);
//        printArray(arr);

    }
}
