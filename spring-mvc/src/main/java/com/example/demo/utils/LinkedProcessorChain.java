/**
 * FileName: LinkedProcessorChain
 * Author:   13235
 * Date:     2019/3/8 11:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.utils;

/**
 * 〈一句话功能简述〉<br> 
 * 需要定义一个容器，在容器中头节点尾节点,头节点是一个空节点，真正的节点将添加到
 * 头节点的next节点上去，尾节点作为一个指针，用来指向当前添加的的节点,下一次添加新节点时，
 * 将从尾节点处添加。
 *
 *
 * @author 13235
 * @create 2019/3/8
 * @since 1.0.0
 */
public class LinkedProcessorChain {

    /**
     *
     * 头节点
     *
     */
    private AbstractLinkProcessor first = new AbstractLinkProcessor() {

        @Override
        public void doProcess(String content) {
          this.getNext().process(content);
        }
    };


    /**
     *
     * 尾节点
     *
     */
    private AbstractLinkProcessor last = first.getNext();


    public void addLast(AbstractLinkProcessor processor) {
        if (processor == null) {
            return;
        }
        if (last == null) {
            first.setNext(processor);
        }else{
            last.setNext(processor);
        }
        last = processor;
    }

    public void process(String content) {
        first.doProcess(content);
    }
}
