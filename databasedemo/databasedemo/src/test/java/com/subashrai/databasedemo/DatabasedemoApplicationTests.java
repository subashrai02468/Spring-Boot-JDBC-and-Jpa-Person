package com.subashrai.databasedemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


//replaced @RunWith with @ExtendWith
//replaced SpringRunner.class with SpringExtension.class
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DatabasedemoApplicationTests {

	@Test
	public void contextLoads() {
	}

}