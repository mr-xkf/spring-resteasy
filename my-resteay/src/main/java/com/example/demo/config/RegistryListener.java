/**
 * FileName: RegistryListener
 * Author:   13235
 * Date:     2019/1/19 4:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.config;

import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/19
 * @since 1.0.0
 */
@Component
public class RegistryListener {


    @Autowired
    private CommonLog commonLog;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @PostConstruct
    public void registerListeners() {
        HibernateEntityManagerFactory sessionFactory = (HibernateEntityManagerFactory) this.entityManagerFactory;
        EventListenerRegistry registry = ((SessionFactoryImpl) sessionFactory.getSessionFactory()).getServiceRegistry().getService(
                EventListenerRegistry.class);
        registry.getEventListenerGroup(EventType.POST_INSERT).appendListener(commonLog);
        registry.getEventListenerGroup(EventType.POST_UPDATE).appendListener(commonLog);
        registry.getEventListenerGroup(EventType.POST_DELETE).appendListener(commonLog);
    }


}
