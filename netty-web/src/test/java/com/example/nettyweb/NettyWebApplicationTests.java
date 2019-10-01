package com.example.nettyweb;

import com.example.nettyweb.utils.ABService;
import com.example.nettyweb.utils.Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ResolvableType;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NettyWebApplicationTests {

	@Test
	public void contextLoads() {
		ResolvableType resolvableType = ResolvableType.forClass(ABService.class);
		Class<?> resolve = resolvableType.as(Service.class).getGeneric(0).resolve();
		Class<?> resolve1 = resolvableType.getInterfaces()[0].getGeneric(1).resolve();
		System.out.println(resolve1.getName());
		System.out.println(resolve.getName());
	}

}
