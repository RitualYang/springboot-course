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
public class MeterRunner implements ApplicationRunner {

    @Autowired
    private MeterRegistry meterRegistry;

    /**
     * mock redis 缓存
     */
    private final Map<String,AtomicLong> atomicLong = Maps.newHashMap();
    private final Map<String,AtomicLong> atomicNumLong = Maps.newHashMap();

    private static final String METER_KEY = "meterKey";
    private static final String METER_TYPE_KEY = "meterTypeKey";

    @Override
    public void run(ApplicationArguments args) {
        Thread thread = new Thread(() -> {
            while (true) {
                String meterBefore = "DATA" + new Random().nextInt(3);
                String meterAfter = "DATA" + new Random().nextInt(3);
                String key = meterBefore + "_" + meterAfter;
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
                    meterRegistry.gauge("meter.key",Tags.of(Tag.of(METER_KEY, meterBefore),Tag.of(METER_TYPE_KEY, meterAfter)), atomicLong);
                    meterRegistry.gauge("meter.type.key", Tags.of(Tag.of(METER_KEY, meterBefore),Tag.of(METER_TYPE_KEY, meterAfter)), atomicLong1);
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
