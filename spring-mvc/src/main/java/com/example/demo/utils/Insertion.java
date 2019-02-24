/**
 * FileName: Insertion
 * Author:   13235
 * Date:     2019/2/17 2:08
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
public class Insertion<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0 && less(nums[j], nums[j - 1]); j--) {
                swap(nums, j, j - 1);
            }
        }
    }
}
