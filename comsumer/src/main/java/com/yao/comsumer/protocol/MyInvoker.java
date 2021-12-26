package com.yao.comsumer.protocol;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.protocol.AbstractInvoker;

/**
 * @author yaojian
 * @date 2021/12/26 15:47
 */
public class MyInvoker<T> extends AbstractInvoker {
    public MyInvoker(Class type, URL url) {
        super(type, url);
    }

    @Override
    protected Result doInvoke(Invocation invocation) throws Throwable {
        return null;
    }
}
