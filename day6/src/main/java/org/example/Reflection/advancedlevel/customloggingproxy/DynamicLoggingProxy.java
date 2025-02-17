package org.example.Reflection.advancedlevel.customloggingproxy;

import java.lang.reflect.Proxy;

public class DynamicLoggingProxy {
    public static void main(String[] args) {
        // Create the real object
        Greeting realGreeting = new GreetingImpl();

        // Create a proxy instance
        Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingProxyHandler(realGreeting)
        );

        // Step 5: Invoke method via proxy
        proxyInstance.sayHello("Alice");
    }
}
