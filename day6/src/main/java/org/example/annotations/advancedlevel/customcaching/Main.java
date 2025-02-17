package org.example.annotations.advancedlevel.customcaching;

import java.lang.reflect.Proxy;
public class Main {
    public static void main(String[] args) {
        ServiceInterface originalService = new Service();

        // Create a proxy instance
        ServiceInterface proxyService = (ServiceInterface) Proxy.newProxyInstance(
                ServiceInterface.class.getClassLoader(),
                new Class[]{ServiceInterface.class},
                new CacheProxyHandler(originalService)
        );

        // Test Caching Behavior
        System.out.println(proxyService.computeSquare(5)); // Computes and stores in cache
        System.out.println(proxyService.computeSquare(5)); // Retrieves from cache
        System.out.println(proxyService.computeSquare(10)); // Computes and stores in cache
        System.out.println(proxyService.computeSquare(10)); // Retrieves from cache
    }
}
