package com.yao.comsumer.protocol;

import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.protocol.AbstractExporter;

/**
 * @author yaojian
 * @date 2021/12/26 15:46
 */
public class MyExporter<T> extends AbstractExporter {
    public MyExporter(Invoker invoker) {
        super(invoker);
    }
}
