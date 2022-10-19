package com.example.demo.client;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="picture-service", url = "${mars.api.host}" )
public interface MarsApiClient {

    @GetMapping("${mars.api.get.larg.pics}")
    @Cacheable({"pic-cache"})
    byte[] getLargestPicture(@RequestParam("sol") Integer sol,
                             @RequestParam(required = false) String camera);
}