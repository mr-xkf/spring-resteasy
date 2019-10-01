/**
 * FileName: TestMain
 * Author:   13235
 * Date:     2019/7/28 20:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.test;

import com.example.demo.json.disable.MyBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 13235
 * @create 2019/7/28
 * @since 1.0.0
 */
public class TestMain {
    @Test
    public void whenDisablingAllAnnotations_thenAllDisabled()
            throws IOException, JsonProcessingException {
        MyBean bean = new MyBean(1, null);

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(MapperFeature.USE_ANNOTATIONS);
        String result = mapper.writeValueAsString(bean);

        assertThat(result, containsString("1"));
        assertThat(result, containsString("name"));

        System.out.println(result);
    }
}
