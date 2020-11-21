package com.wty.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * ISOLATION_DEFAULT	使用后端数据库默认的隔离级别
 * ISOLATION_READ_UNCOMMITTED	允许读取尚未提交的更改。可能导致脏读、
 * 幻读或不可重复读。
 * ISOLATION_READ_COMMITTED	(Oracle 默认级别)允许从已经提交的并发事务读取。
 * 可防止脏读,但幻读和不可重复读仍可能会发生。
 * ISOLATION_REPEATABLE_READ	(MYSQL默认级别)对相同字段的多次读取的结果是一致的,
 * 除非数据被当前事务本身改变。可防止脏读和不可重复读,但幻读仍可能发生。
 * ISOLATION_SERIALIZABLE	完全服从ACID的隔离级别,确保不发生脏读、不可重复读和幻影读。
 * 这在所有隔离级别中也是最慢的,因为它通常是通过完全锁定当前事务所涉及的数据表来完成的。
 *
 * @author wty
 * @date 2020/8/31 15:09
 */
@Service
public class IsolationService {

    @Transactional(isolation = Isolation.DEFAULT)
    public String test() {
        return "test";
    }

}
