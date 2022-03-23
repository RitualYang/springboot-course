package com.wty.config;

import com.wty.shiro.CustomRealm;
import com.wty.shiro.ShiroSessionListener;
import java.util.Collections;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * shiro配置
 *
 * @author wty
 * @date 2019/11/01 21:11
 */
@Configuration
public class ShiroConfig {

    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAPC = new DefaultAdvisorAutoProxyCreator();
        defaultAAPC.setProxyTargetClass(true);
        return defaultAAPC;
    }

    /**
     * 将自己的验证方式加入容器
     *
     * @return
     */
    @Bean
    public CustomRealm myShiroRealm() {
        CustomRealm customRealm = new CustomRealm();
        return customRealm;
    }

    /**
     * 权限管理,配置主要是Realm的管理认证
     *
     * @return
     */
    @Bean
    public SecurityManager securityManager(SessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        securityManager.setSessionManager(sessionManager);
        return securityManager;
    }

    @Bean
    public SessionManager sessionManager(SessionDAO sessionDAO) {
        DefaultWebSessionManager skySessionManager = new DefaultWebSessionManager();
        // session 失效删除session
        skySessionManager.setSessionDAO(sessionDAO);
        skySessionManager.setDeleteInvalidSessions(true);
        // 定期检查 失效的 session
        skySessionManager.setSessionValidationInterval(5000);
        skySessionManager.setGlobalSessionTimeout(20000);
        // 开启 schedule
        skySessionManager.setSessionValidationSchedulerEnabled(true);
        skySessionManager.setSessionListeners(Collections.singletonList(new ShiroSessionListener()));
        return skySessionManager;
    }

    @Bean
    public SessionDAO sessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        redisSessionDAO.setExpire(36);
        return redisSessionDAO;
    }

    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setTimeout(0);
        return redisManager;
    }

    /**
     * Filter工厂,设置对应的过滤条件和跳转条件
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //拦截器
        Map<String, String> filterChainDefinitionMap = new HashMap<>(6);
        //登出过滤器(Shiro已经替我们实现了)
        filterChainDefinitionMap.put("/logout", "logout");
        //authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
        filterChainDefinitionMap.put("/static/**", "anon");
        // 登录 URL 放行
        filterChainDefinitionMap.put("/login", "anon");
        //必须放在最后,否则全部拦截
        filterChainDefinitionMap.put("/**", "authc");
        //登录页面,如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        //登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //错误页面,认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/error");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 开启shiro aop注解支持.
     * 使用代理方式,需要开启代码支持;
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * 凭证匹配器
     *
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //加密操作
        //hashedCredentialsMatcher.setHashAlgorithmName("md5");
        //hashedCredentialsMatcher.setHashIterations(2);
        return hashedCredentialsMatcher;
    }
}