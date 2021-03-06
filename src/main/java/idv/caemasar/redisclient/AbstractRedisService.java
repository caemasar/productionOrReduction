//package idv.caemasar.redisclient;
//
//import java.util.concurrent.TimeUnit;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.BoundValueOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//
//public abstract class AbstractRedisService<K, V> implements IRedisService<K, V> {
//	@Autowired
//	private RedisTemplate<K, V> redisTemplate;
//
//	public RedisTemplate<K, V> getRedisTemplate() {
//		return redisTemplate;
//	}
//
//	public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
//		this.redisTemplate = redisTemplate;
//	}
//
//	@Override
//	public void set(final K key, final V value, final long expiredTime) {
//		BoundValueOperations<K, V> valueOper = redisTemplate.boundValueOps(key);
//		if (expiredTime <= 0) {
//			valueOper.set(value);
//		} else {
//			valueOper.set(value, expiredTime, TimeUnit.MILLISECONDS);
//		}
//	}
//
//	@Override
//	public V get(final K key) {
//		BoundValueOperations<K, V> valueOper = redisTemplate.boundValueOps(key);
//		System.out.println("valueOper:::" + valueOper.toString());
//		V v = valueOper.get();
//		System.out.println("value:::" + v + ",key:::" + key);
//		return v;
//	}
//
//	@Override
//	public Object getHash(K key, String name) {
//		Object res = redisTemplate.boundHashOps(key).get(name);
//		return res;
//	}
//
//	@Override
//	public void del(K key) {
//		if (redisTemplate.hasKey(key)) {
//			redisTemplate.delete(key);
//		}
//	}
//
//}
