package com.wm.eshop.price;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@SpringBootApplication
// 将本应用作为一个微服务注册到Eureka Server上去
@EnableEurekaClient
public class EshopPriceServiceApplication {

	@Bean
	public JedisPool jedisPool() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(100);
		config.setMaxIdle(5);
		config.setMaxWaitMillis(1000 * 10);// 连接Redis Pool最多等待10秒
		config.setTestOnBorrow(true);
		// return new JedisPool(config, "localhost", 6379);
		return new JedisPool(config, "192.168.1.103", 1111);// 生产环境Redis的twemproxy的主集群
	}

	public static void main(String[] args) {
		SpringApplication.run(EshopPriceServiceApplication.class, args);
	}

}
