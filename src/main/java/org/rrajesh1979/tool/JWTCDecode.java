package org.rrajesh1979.tool;

import org.javatuples.Pair;
import org.rrajesh1979.utils.JWTUtil;

import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "decode")
@Slf4j
public class JWTCDecode implements Runnable {
    @Option(names = { "-j", "--jwt" }, description = "JWT String to be decoded.", required = true)
    String jwt;

    @Option(names = { "-k", "--key" }, description = "Key to be used for decoding.", required = true)
    String key;

    @Override
    public void run() {
        log.info("Starting JWTCDecode");

        Pair<String, String> decodedJwtAndKey = JWTUtil.decodeJWT(jwt, key);
        log.info("Decoded JWT Header: {}", decodedJwtAndKey.getValue0());
        log.info("Decoded JWT Payload: {}", decodedJwtAndKey.getValue1());
    }
}
