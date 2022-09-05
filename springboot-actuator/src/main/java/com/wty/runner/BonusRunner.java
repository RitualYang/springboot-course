package com.wty.runner;

import com.google.common.collect.Maps;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Tags;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author wty
 * @date 2022/8/18 11:17
 */
@Component
public class BonusRunner implements ApplicationRunner {

    @Autowired
    private MeterRegistry meterRegistry;

    /**
     * mock redis 缓存
     */
    private Map<String,AtomicLong> atomicLong = Maps.newHashMap();
    private Map<String,AtomicLong> atomicNumLong = Maps.newHashMap();

    private String BONUS_KEY = "bonusCurrency";
    private String BONUS_TYPE_KEY = "bonusType";

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Thread thread = new Thread(() -> {
            while (true) {
                String bonusCurrency = "USD" + new Random().nextInt(3);
                String bonusType = "TYPE" + new Random().nextInt(3);
                String key = bonusCurrency + "_" + bonusType;
                AtomicLong atomicLong = this.atomicLong.get(key);
                if (Objects.isNull(atomicLong)) {
                    atomicLong = new AtomicLong(0);
                    this.atomicLong.put(key,atomicLong);
                }
                AtomicLong atomicLong1 = atomicNumLong.get(key);
                if (Objects.isNull(atomicLong1)){
                    atomicLong1 = new AtomicLong(0);
                    this.atomicNumLong.put(key,atomicLong1);
                }
                atomicLong.addAndGet(new Random().nextInt(300));
                atomicLong1.incrementAndGet();
                if (atomicLong1.get() <= 1L) {
                    System.out.println("发送注册消息");
                    meterRegistry.gauge("contract.project.bonus.ev",Tags.of(Tag.of(BONUS_KEY, bonusCurrency),Tag.of(BONUS_TYPE_KEY, bonusType)), atomicLong);
                    meterRegistry.gauge("contract.project.bonus.num", Tags.of(Tag.of(BONUS_KEY, bonusCurrency),Tag.of(BONUS_TYPE_KEY, bonusType)), atomicLong1);
                } else {
                    System.out.println("更新缓存");
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}
