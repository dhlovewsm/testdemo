package com.dh;

import java.util.Arrays;

public class Test {


    public static void main(String[] args) {

        int arr[] = {5, 2, 3, 1};

        // 冒泡排序
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < i; j++){
                if (arr[i] < arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));


        // 选择排序
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++){
                if (arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

        int arr1[] = {7, 23, 79, 81, 103, 127, 131, 147};

        //二分查找
        int left = 0;
        int right = arr1.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (arr1[mid] == 81){
                System.out.println("找到了");
                break;
            }else if (arr1[mid] > 81){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
    }

}
