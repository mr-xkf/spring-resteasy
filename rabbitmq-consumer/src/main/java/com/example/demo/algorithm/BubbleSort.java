/**
 * FileName: BubbleSort
 * Author:   13235
 * Date:     2019/7/28 20:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.algorithm;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 13235
 * @create 2019/7/28
 * @since 1.0.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] list = {27, 76, 47, 23, 7, 32, 19, 86};
        System.out.println("---------冒泡排序-----");
        System.out.println("排序前。。");
        display(list);
        System.out.println("排序后。。。。。");
        bubbleSort(list);
        display(list);

    }
    public static void display(int[] list) {
        if (list != null && list.length > 0) {
            for (int num : list) {
                System.out.print(num+" ");
            }
            System.out.println("");
        }

    }

    public static void  bubbleSort(int[] list) {
        int len = list.length;
        //做多少轮排序
        for (int i = 0; i < len - 1; i++) {
            //每轮比较多少个
            for (int j = 0; j < len - 1 - i; j++) {
                if (list[j] > list[j + 1]) {
                     //交换次序
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }


    }
















}
