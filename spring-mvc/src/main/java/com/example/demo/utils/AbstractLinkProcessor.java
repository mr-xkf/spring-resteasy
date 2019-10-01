/**
 * FileName: AbstractLinkProcessor
 * Author:   13235
 * Date:     2019/3/8 10:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.utils;

/**
 * 〈一句话功能简述〉<br> 
 * 定义节点
 *
 * @author 13235
 * @create 2019/3/8
 * @since 1.0.0
 */
public abstract  class AbstractLinkProcessor implements Processor {

    private AbstractLinkProcessor next = null;

    public AbstractLinkProcessor getNext() {
        return next;
    }

    public void setNext(AbstractLinkProcessor next) {
        this.next = next;
    }

    @Override
    public void process(String content) {
        doProcess(content);
      //调用下一个processor
        if (next != null) {
            next.process(content);
        }
    }

    public abstract void doProcess(String content);
}
