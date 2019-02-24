/**
 * FileName: CommonLog
 * Author:   13235
 * Date:     2019/1/19 3:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.config;

import org.hibernate.event.spi.*;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/19
 * @since 1.0.0
 */
@Component
public class CommonLog implements PostInsertEventListener, PostUpdateEventListener,
        PostDeleteEventListener {
    @Override
    public void onPostDelete(PostDeleteEvent postDeleteEvent) {
        System.out.println("删除监听。。。。");
    }

    @Override
    public void onPostInsert(PostInsertEvent postInsertEvent) {
        Serializable id = postInsertEvent.getId();
        System.out.println("id:" + id.toString());
        Object entity = postInsertEvent.getEntity();
        System.out.println("entity:" + entity.getClass().getSimpleName());
        Object[] state = postInsertEvent.getState();
        System.out.println("state:" + Arrays.toString(state));
        System.out.println("插入监听。。。。");
    }

    @Override
    public boolean requiresPostCommitHanding(EntityPersister entityPersister) {
        return false;
    }

    @Override
    public void onPostUpdate(PostUpdateEvent postUpdateEvent) {
        Serializable id = postUpdateEvent.getId();
        System.out.println("id:" + id.toString());
        Object entity = postUpdateEvent.getEntity();
        System.out.println("entity:" + entity.getClass().getSimpleName());
        Object[] state = postUpdateEvent.getState();
        System.out.println("state:" + Arrays.toString(state));
        System.out.println("更新监听。。。。");
    }


}
