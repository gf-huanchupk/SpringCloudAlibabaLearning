package com.gf;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@NacosPropertySource(dataId = "springcloud-nacos-hello", autoRefreshed = true)
@RestController
public class SpringcloudNacosHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run( SpringcloudNacosHelloApplication.class, args );
    }

    @NacosValue(value = "${test.properties.useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;


    @GetMapping("/get")
    public boolean get(){
        return useLocalCache;
    }

}
