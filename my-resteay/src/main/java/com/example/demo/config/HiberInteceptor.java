/**
 * FileName: HibernateInteceptor
 * Author:   13235
 * Date:     2019/1/21 21:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.config;

import com.example.demo.domain.FileInfo;
import com.example.demo.domain.LogOperate;
import com.example.demo.service.LogService;
import com.example.demo.utils.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

/**
 * 〈一句话功能简述〉<br>
 * <p>
 * hibernate.ejb.interceptor
 *
 * @author 13235
 * @create 2019/1/21
 * @since 1.0.0
 */
@Component
@Slf4j
public class HiberInteceptor extends EmptyInterceptor {

    @Override
    public void afterTransactionBegin(Transaction tx) {
        System.out.println("事务开启之后。。。。。");

    }

    @Override
    public void beforeTransactionCompletion(Transaction tx) {
        System.out.println("事务完成之前。。。。。");
    }

    @Override
    public void afterTransactionCompletion(Transaction tx) {
        System.out.println("事务完成之后。。。。。");

    }


    @Override
    public String onPrepareStatement(String sql) {
        System.out.println("拦截的sql->" + sql);
        return super.onPrepareStatement(sql);
    }

    @Override
    public void preFlush(Iterator entities) {
        System.out.println("删除，修改,新增提交之前调用");
    }

    @Override
    public void postFlush(Iterator entities) {
        System.out.println("删除，修改，新增之后调用");

    }

    @Override
    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        System.out.println("删除数据");

    }

    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        System.out.println("entity:" + entity.toString());
        System.out.println("currentState:" + Arrays.toString(currentState));
        System.out.println("previousState:" + Arrays.toString(previousState));
        System.out.println("propertyName:" + Arrays.toString(propertyNames));
        System.out.println("types:" + Arrays.toString(types));
        saveLog(entity, previousState,currentState, propertyNames);
        System.out.println("修改数据");
        return false;
    }


    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        System.out.println("entity:" + entity.toString());
        System.out.println("state:" + Arrays.toString(state));
        System.out.println("propertyName:" + Arrays.toString(propertyNames));
        System.out.println("types:" + Arrays.toString(types));
        System.out.println("保存数据");
        saveLog(entity, null,state, propertyNames);
        return false;
    }

    private void saveLog(Object entity, Object[] previousState,Object[] currentState, String[] propertyNames) {
        if (entity instanceof FileInfo) {
            String[] excludeFieldName = new String[]{"id", "operateTime"};
            for (int i = 0; i < propertyNames.length; i++) {
                //排除不需要记录的字段
                if (ArrayUtils.contains(excludeFieldName, propertyNames[i])) {
                    continue;
                }
                //修改
                if (previousState != null && previousState.length > 0) {
                    operateLog(previousState[i], currentState[i],propertyNames[i]);
                }else{
                    operateLog(null, currentState[i],propertyNames[i]);
                }
            }
        }
    }

    /**
     *
     * 记录日志
     * @param oldVal
     * @param newVal
     * @param propertyName
     *
     */
    private void operateLog(Object oldVal,Object newVal,String propertyName) {
        LogOperate logOperate = new LogOperate();
        logOperate.setOperateCode("admin");
        logOperate.setOperateUser("管理员");
        logOperate.setCurrentVal(changeType2String(newVal));
        logOperate.setPreviousVal(changeType2String(oldVal));
        logOperate.setCulumnName(propertyName);
        logOperate.setRelyCode("code");
        logOperate.setReversion(1);
        logOperate.setCreateBy("admin");
        logOperate.setCreateTime(new Date());
        logOperate.setUpdateBy("admin");
        logOperate.setUpdateTime(new Date());
        LogService bean = (LogService) SpringContextUtil.getBean(LogService.class);
        try {
            bean.editLog(logOperate);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * 类型转换为String
     * @param o
     * @return
     *
     *
     */
    private String changeType2String(Object o) {
        if (Objects.isNull(o)) {
            return "";
        }
        boolean primitiveWrapper = ClassUtils.isPrimitiveWrapper(o.getClass());
        if (primitiveWrapper) {
            return String.valueOf(o);
        } else if (o instanceof BigDecimal) {
            return o.toString();
        } else if (o instanceof Date) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return simpleDateFormat.format(o);
        }
        return o.toString();
    }

}
