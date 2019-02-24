/**
 * FileName: Bubble
 * Author:   13235
 * Date:     2019/2/17 2:04
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
public class Bubble<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int len = nums.length;
        boolean hasSored = false;
        for (int i = len - 1; i > 0 && !hasSored; i--) {
            hasSored = true;
            for (int j = 0; j < i; j++) {
                if (less(nums[j + 1], nums[j])) {
                    hasSored = false;
                    swap(nums, j, j + 1);
                }
            }
        }
    }
}
