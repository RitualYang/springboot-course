package com.wty;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * 事务测试
 *
 * @author wty
 * @Date 2020/11/16 16:28
 */
@SpringBootTest
public class TransTest {


    @Test
    public void test(){
        try {
            new TransTest().okOrError();
            System.out.println(" 正常逻辑");
        }catch (Exception e){
            System.out.println(e.getMessage());//No transaction aspect-managed TransactionStatus in scope
            System.out.println("有全局异常处理 抛一个 就结束了.没有的话 就出方法拍屁股走人");
        }

    }
    // 自己加回滚异常类型
    @Transactional
    public void okOrError() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println("插入:" + i);
            if (i == 50 || i == 75) {
                // 自定义注解
                //throw new Exception( i + "更新失败");
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
    }
}
