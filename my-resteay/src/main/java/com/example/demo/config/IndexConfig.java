/**
 * FileName: IndexConfig
 * Author:   13235
 * Date:     2019/1/12 1:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/12
 * @since 1.0.0
 */
@Configuration
//@EnableWebMvc
public class IndexConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
    }

  /*  @Bean
    public MappingJackson2HttpMessageConverter jackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        converter.setObjectMapper(mapper);
        return converter;
    }//添加转换器@Override

    @Override
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        //将我们定义的时间格式转换器添加到转换器列表中,
        // 这样jackson格式化时候但凡遇到Date类型就会转换成我们定义的格式
        converters.add(jackson2HttpMessageConverter());
    }*/

}