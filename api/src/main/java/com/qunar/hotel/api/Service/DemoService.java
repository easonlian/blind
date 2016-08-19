package com.qunar.hotel.api.Service;

import com.qunar.hotel.api.bean.Param;

/**
 * Created by easonlian on 16-7-12.
 */
public interface DemoService {

    String sayHello(String name);

    String echoBean(Param param);

    Param getParam();
}
