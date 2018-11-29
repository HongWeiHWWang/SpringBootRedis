package com.nbs.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nbs.App;

import redis.clients.jedis.JedisCluster;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class RedisClusterTest {
	
	//注入Redis集群对象
	@Autowired
	private JedisCluster jedisCluster;
	
	@Test
	public void testRedisCluster(){
		this.jedisCluster.set("username", "David");
		String value = jedisCluster.get("username");
		System.out.println("uesrname: "+value);
	}
	
}
