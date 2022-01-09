package org.rrajesh1979.demo;

import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;

@CommandLine.Command(name = "decode")
@Slf4j
public class JWTCDecode implements Runnable {
    @Override
    public void run() {
        log.info("Hello from JWTCDecode");
    }
}
