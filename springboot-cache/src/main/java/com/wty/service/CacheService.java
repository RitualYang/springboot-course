package com.wty.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 当我们需要缓存的地方越来越多,你可以使用@CacheConfig(cacheNames = {"myCache"})注解来统一指定value的值,
 * 这时可省略value,如果你在你的方法依旧写上了value,那么依然以方法的value值为准。
 * 作者：吟风者
 * 链接：https://www.jianshu.com/p/e9b40acb2993
 * 来源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权,非商业转载请注明出处。
 * String keyGenerator() default "";  //key的生成器。key/keyGenerator二选一使用
 * String cacheManager() default "";  //指定缓存管理器
 * String cacheResolver() default ""; //或者指定获取解析器
 *
 * @author wty
 * @date 2020/8/27 15:47
 */
@Service
@Slf4j
@CacheConfig(cacheNames = {"myCache"})
public class CacheService {

    private static List<String> strArr = Arrays.asList(new String[]{"string", "String", "cache"});

    /**
     * {@link Cacheable} 注解会先查询是否已经有缓存,有会使用缓存,没有则会执行方法并缓存。
     * String[] cacheNames() default {}; //和value注解差不多,二选一
     * String keyGenerator() default ""; //key的生成器。key/keyGenerator二选一使用
     * String cacheManager() default ""; //指定缓存管理器
     * String cacheResolver() default ""; //或者指定获取解析器
     * String condition() default ""; //条件符合则缓存
     * String unless() default ""; //条件符合则不缓存
     * boolean sync() default false; //是否使用异步模式
     *
     * @return
     */
    @Cacheable(value = "strAll", key = "targetClass")
    public String queryAll() {
        log.info("缓存中无数据,添加返回");
        StringBuffer stringBuffer = new StringBuffer("");
        strArr.forEach(s -> {
            stringBuffer.append(s + " ");
        });
        return stringBuffer.toString();
    }

    /**
     * {@link CachePut}注解的作用 主要针对方法配置,能够根据方法的请求参数对其结果进行缓存,和 @Cacheable 不同的是,
     * 它每次都会触发真实方法的调用 。简单来说就是用户更新缓存数据。但需要注意的是该注解的value 和 key 必须与
     * 要更新的缓存相同,也就是与@Cacheable 相同。
     * String[] cacheNames() default {}; //与value二选一
     * String keyGenerator() default "";  //key的生成器。key/keyGenerator二选一使用
     * String cacheManager() default "";  //指定缓存管理器
     * String cacheResolver() default ""; //或者指定获取解析器
     * String condition() default ""; //条件符合则缓存
     * String unless() default ""; //条件符合则不缓存
     *
     * @param newStr
     * @return
     */
    @CachePut(value = "str", key = "targetClass + #newStr")
    public String save(String newStr) {
        log.info("更新一条缓存数据");
        strArr.add(newStr);
        StringBuffer stringBuffer = new StringBuffer("");
        strArr.forEach(s -> {
            stringBuffer.append(s + " ");
        });
        return stringBuffer.toString();
    }

    @CachePut(value = "strAll", key = "targetClass")
    public String update() {
        log.info("更新缓存数据");
        strArr = Arrays.asList(new String[]{"string", "String", "cache"});
        StringBuffer stringBuffer = new StringBuffer("");
        strArr.forEach(s -> {
            stringBuffer.append(s + " ");
        });
        return stringBuffer.toString();
    }

    /**
     * 清除一条缓存,key为要清空的数据
     * String[] cacheNames() default {}; //与value二选一
     * String keyGenerator() default "";  //key的生成器。key/keyGenerator二选一使用
     * String cacheManager() default "";  //指定缓存管理器
     * String cacheResolver() default ""; //或者指定获取解析器
     * String condition() default ""; //条件符合则清空
     *
     * @param str
     */
    @CacheEvict(value = "str", key = "targetClass + #str")
    public void deleteOne(String str) {
        log.info("删除一条缓存数据");
        strArr.remove(str);
    }

    /**
     * 方法调用后清空所有缓存
     */
    @CacheEvict(value = "strAll", allEntries = true)
    public void deleteAll() {
        log.info("删除strAll的缓存数据");
        strArr = new ArrayList<>();
    }

    /**
     * 方法调用前清空所有缓存
     */
    @CacheEvict(value = "str", beforeInvocation = true)
    public void deleteAllBefore() {
        log.info("删除str的缓存数据");
        strArr = new ArrayList<>();
    }

    /**
     * 有时候我们可能组合多个Cache注解使用,此时就需要@Caching组合多个注解标签了。
     */
    @Caching(
            cacheable = {@Cacheable(value = "str", key = "targetClass")},
            put = {@CachePut(value = "str", key = "targetClass")},
            evict = {@CacheEvict(value = "str", key = "targetClass")})
    public void allOperation() {

    }

}
