package com.lvan.dubboprovider.service;

import cn.hutool.core.text.CharSequenceUtil;
import com.lvan.dubbointerface.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;

/**
 * @author lvan
 * @date 2022/6/9
 */
@Slf4j
@DubboService
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {

        RpcContext.getServiceContext().getLocalPort();
        return CharSequenceUtil.format("Hello {} , request from consumer: {}, dubbo port:{}",
                name, RpcContext.getServiceContext().getRemoteAddress(), RpcContext.getServiceContext().getLocalPort());
    }
}
