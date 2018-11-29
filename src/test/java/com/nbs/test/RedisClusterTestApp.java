package com.nbs.test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

public class RedisClusterTestApp {

	public static void main(String[] args) throws IOException {
		
		Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
		jedisClusterNode.add(new HostAndPort("192.168.1.224", 7001));
		jedisClusterNode.add(new HostAndPort("192.168.1.224", 7002));
		jedisClusterNode.add(new HostAndPort("192.168.1.224", 7003));
		jedisClusterNode.add(new HostAndPort("192.168.1.224", 7004));
		jedisClusterNode.add(new HostAndPort("192.168.1.224", 7005));
		jedisClusterNode.add(new HostAndPort("192.168.1.224", 7006));
		
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(100);
		config.setMaxIdle(20);
		config.setMaxWaitMillis(-1);
		config.setTestOnBorrow(true);
		JedisCluster jc = new JedisCluster(jedisClusterNode, 6000, 100, config);
		jc.set("sex", "nv");
		jc.set("age1", "23");
		System.out.println(jc.get("age1"));
		System.out.println(jc.get("sex"));
		jc.close();
		
		
/*		JedisCluster jcd = new JedisCluster(jedisClusterNode);
		jcd.set("name","zhangsan");
		String value = jcd.get("name");
		System.out.println(value);
		jcd.close();*/
		

	}

}
