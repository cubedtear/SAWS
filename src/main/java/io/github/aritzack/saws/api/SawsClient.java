package io.github.aritzack.saws.api;

import io.github.aritzack.saws.impl.RemoteRunner;
import io.github.aritzhack.aritzh.logging.core.ILogger;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @author aritzh
 */
public class SawsClient {

    @SuppressWarnings("unchecked")
    public static <T> T get(String address, int port, Class<T> inter) throws IOException {
        Socket s = new Socket(address, port);
        return (T) Proxy.newProxyInstance(inter.getClassLoader(), new Class[]{inter}, new RemoteRunner(s));
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String address, int port, Class<T> inter, ILogger logger) throws IOException {
        Socket s = new Socket(address, port);
        return (T) Proxy.newProxyInstance(inter.getClassLoader(), new Class[]{inter}, new RemoteRunner(s, logger));
    }
}