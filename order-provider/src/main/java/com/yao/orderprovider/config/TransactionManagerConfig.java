package com.yao.orderprovider.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

/**
 * Created by yaojian on 2021/12/29 10:45
 *
 * @author
 */
@Configuration
public class TransactionManagerConfig {

    @Autowired
    private AtomikosJtaConfiguration jtaConfiguration;

    @Bean(name = "financeCore")
    public PlatformTransactionManager platformTransactionManager()  throws Throwable {
        System.out.println("init PlatformTransactionManager======================================");
        return new JtaTransactionManager(jtaConfiguration.userTransaction(), jtaConfiguration.transactionManager());
    }


}
