package com.qunar.hotel.provider;

import com.qunar.hotel.api.Service.DemoService;
import com.qunar.hotel.api.bean.Param;

/**
 * Created by easonlian on 16-7-12.
 */
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

    @Override
    public String echoBean(Param param) {
        return param == null ? null : param.toString();
    }

    @Override
    public Param getParam() {
        return new Param();
    }
}
