/**
 * FileName: Main
 * Author:   13235
 * Date:     2019/2/17 2:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.utils;

import java.util.stream.Stream;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 13235
 * @create 2019/2/17
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        Insertion<Integer> insertion = new Insertion<Integer>();
        Integer[] nums=  new Integer[]{2, 3, 5, 2, 1, 6};
        insertion.sort(nums);
        Stream.of(nums).forEach(s-> System.out.print(s+"\t"));
    }
}
