package org.rrajesh1979.tool;

import org.javatuples.Pair;
import org.rrajesh1979.utils.JWTUtil;

import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;

@CommandLine.Command(name = "encode")
@Slf4j
public class JWTCEncode implements Runnable {
    @Override
    public void run() {
        log.info("Hello from JWTCEncode");

        String userInput = "{\"name\": \"Joe\", \"picture\": \"https://example.com/image.png\"}";

        Pair<String, String> jwtAndKey = JWTUtil.createJWT("JWT", "HS512", userInput,
                "rrajesh1979", "JWT Encoder", "Hello JWT", false, 1000000000);

        System.out.println("JWT :" + jwtAndKey.getValue0());
        System.out.println("Secret Key :" + jwtAndKey.getValue1());

    }
}
