package com.wty.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

/**
 * @author wty
 * @date 2022/3/22 22:29
 */
@Slf4j
public class ShiroSessionListener implements SessionListener {

    @Override
    public void onStart(Session session) {
        log.info("创建:{}", session.getId());
    }

    @Override
    public void onStop(Session session) {
        log.info("销毁:{}", session.getId());
    }

    @Override
    public void onExpiration(Session session) {
        log.info("失效监听:{}", session.getId());
    }
}
