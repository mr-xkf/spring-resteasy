/**
 * FileName: Selection
 * Author:   13235
 * Date:     2019/2/17 2:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.utils;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/2/17
 * @since 1.0.0
 */
public class Selection<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (less(nums[j], nums[min])) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }

    }
}
