/**
 * 
 */
package com.ishop.redis.test;

import java.util.HashSet;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/**
 * redis集群版
 * @author Administrator
 *
 */
public class JedisClientGroupTest {
	@Test
	public void testJedisCluster() {
		HashSet<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("127.0.0.1", 7001));
		nodes.add(new HostAndPort("127.0.0.1", 7002));
		nodes.add(new HostAndPort("127.0.0.1", 7003));
		nodes.add(new HostAndPort("127.0.0.1", 7004));
		nodes.add(new HostAndPort("127.0.0.1", 7005));
		nodes.add(new HostAndPort("127.0.0.1", 7006));
		
		JedisCluster cluster = new JedisCluster(nodes);
		
		cluster.set("key", "1000");
		String string = cluster.get("key");
		System.out.println(string);
		
		cluster.close();
	}
}
