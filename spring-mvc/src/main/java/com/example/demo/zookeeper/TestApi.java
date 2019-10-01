/**
 * FileName: TestApi
 * Author:   13235
 * Date:     2019/7/21 19:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 〈一句话功能简述〉<br>
 * zookeeper api 练习
 *
 * @author 13235
 * @create 2019/7/21
 * @since 1.0.0
 */
@Slf4j
public class TestApi {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        try {
            ZooKeeper zooKeeper = new ZooKeeper("39.104.50.79:2181", 30000,
                    watchedEvent -> {
                        if (KeeperState.SyncConnected.equals(watchedEvent.getType())) {
                           log.info("connected....");
                        }else if (EventType.NodeCreated.equals(watchedEvent.getType())) {
                            log.info("node created...");
                        } else if (EventType.NodeChildrenChanged.equals(watchedEvent.getType())) {
                            log.info("node childrenChanged......");
                        } else if (EventType.NodeDataChanged.equals(watchedEvent.getType())) {
                            log.info("node dataChanged............");
                        } else if (EventType.NodeDeleted.equals(watchedEvent.getType())) {
                            log.info("node deleted.......");
                        } else if (EventType.None.equals(watchedEvent.getType())) {
                            log.info("node ...........");
                        }
                    });
            List<String> children = zooKeeper.getChildren("/", true);
            children.forEach(s -> System.out.println(s));
            //持久节点
          /*  String s = zooKeeper.create("/first_node", "12312".getBytes("utf-8"),
                    Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(s);
            //持久顺序节点
            zooKeeper.create("/second_node", "sdfsd".getBytes("utf-8"), Ids.OPEN_ACL_UNSAFE,
                    CreateMode.PERSISTENT_SEQUENTIAL);
            //临时节点
            zooKeeper.create("/third_node", "sdfw".getBytes(Charset.forName("utf-8")), Ids.OPEN_ACL_UNSAFE,
                    CreateMode.EPHEMERAL);
            //临时顺序节点
            zooKeeper.create("/fourth_node", "sdfds".getBytes("utf-8"), Ids.OPEN_ACL_UNSAFE,
                    CreateMode.EPHEMERAL_SEQUENTIAL);*/

              //异步创建通知
            zooKeeper.create("/async_node2", "dsd".getBytes("utf-8"), Ids.OPEN_ACL_UNSAFE,
                    CreateMode.PERSISTENT, (i, s12, o, s1) -> {
                       log.info("i:"+i+"\t"+"s12:"+s12+"\t"+"o:"+o+"\t"+"s1:"+s1);
                    },"哈哈");
            zooKeeper.exists("/fist_node", watchedEvent -> {
                 log.info("处理事件");
            }, (i, s, o, stat) -> {
                log.info("异步回调！");

            },"回调");

           countDownLatch.await();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }


    }


}
