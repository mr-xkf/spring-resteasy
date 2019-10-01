/**
 * FileName: OrderThreadPool
 * Author:   13235
 * Date:     2019/7/20 10:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.thread;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/7/20
 * @since 1.0.0
 */
@Component
@Slf4j
public class OrderThreadPool {

    private ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
            5, 10, 1, TimeUnit.MINUTES,
            new LinkedBlockingQueue<>(20), new BasicThreadFactory.Builder()
            .namingPattern("orderPool-%d").uncaughtExceptionHandler((t, e) -> {
                log.error("异步调用处理异常。。。。");
            }).build(), new ThreadPoolExecutor.CallerRunsPolicy());

    public <V> Future<V> submit(Callable<V> callable) {
        return poolExecutor.submit(callable);
    }

    public void execute(Runnable runnable) {
        poolExecutor.execute(runnable);
    }

}
