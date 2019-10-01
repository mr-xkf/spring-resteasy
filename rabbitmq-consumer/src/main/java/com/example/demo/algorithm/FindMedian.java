/**
 * FileName: FindMedian
 * Author:   13235
 * Date:     2019/7/28 20:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/7/28
 * @since 1.0.0
 */
public class FindMedian {
    private static PriorityQueue<Integer> maxHeap, minHeap;

    public static void main(String[] args) {
        Comparator<Integer> comparator = Comparator.reverseOrder();
        maxHeap = new PriorityQueue<>(100, comparator);
        minHeap = new PriorityQueue<>(100);
    }
}

