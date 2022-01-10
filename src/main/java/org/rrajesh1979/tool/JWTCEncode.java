/*
 *  Copyright (c) 2022 Rajesh Rajagopalan
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.rrajesh1979.tool;

import org.javatuples.Pair;
import org.rrajesh1979.utils.JWTUtil;

import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "encode")
@Slf4j
public class JWTCEncode implements Runnable {
    @Option(names = { "-a",
            "--algorithm" }, description = "Algorithm to be used. Default is HS256. Supported algorithms are HS256, HS384, HS512, RS256, RS384, RS512, ES256, ES384, ES512", defaultValue = "HS256")
    String alg;

    @Option(names = { "-t", "--ttl" }, description = "Time to Live in Milliseconds.", defaultValue = "3600000")
    long ttlMillis;

    @Option(names = { "-s", "--subject" }, description = "Subject of the JWT.")
    String sub;

    @Option(names = { "-ty", "--typ" }, description = "Token Type. Default is JWT.", defaultValue = "JWT")
    String typ;

    @Option(names = { "-i", "--issuer" }, description = "Principal that issued the JWT.", defaultValue = "rrajesh1979")
    String iss;

    @Option(names = { "-aud", "--audience" }, description = "Recipients the JWT is intended for.")
    String aud;

    @Option(names = { "-iat", "--issuedAt" }, description = "Include issued at in JWT.", defaultValue = "false")
    boolean iat;

    @Option(names = { "-p", "--userInput" }, description = "User provided payload in JSON format.", defaultValue = "{}")
    String userInput;

    @Override
    public void run() {
        log.info("Starting JWTCEncode");

        Pair<String, String> jwtAndKey = JWTUtil.createJWT(typ, alg, userInput,
                iss, sub, aud, iat, ttlMillis);

        log.info("JWT: {}", jwtAndKey.getValue0());
        log.info("Secret Key: {}", jwtAndKey.getValue1());

    }
}
