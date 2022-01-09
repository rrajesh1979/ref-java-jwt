package org.rrajesh1979.tool;

import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;
import picocli.CommandLine.Command;

/**
 * @author rrajesh1979
 * @version 0.0.1
 * @since 2021-Jan-08
 */

@Command(name = "jwtc", mixinStandardHelpOptions = true, version = "jwtc 0.0.1", description = "Encode and decode JWT tokens.", subcommands = {
        JWTCEncode.class, JWTCDecode.class
})
@Slf4j
public class JWTC implements Runnable {
    /**
     * Main function to invoke the picocli framework.
     *
     * @param args the command line arguments.
     *             The first argument is the file whose checksum to calculate.
     *             The second argument is the algorithm to use.
     *             The default algorithm is MD5.
     */
    public static void main(String[] args) {
        int exitCode;
        log.info("Hello from JWTC main");
        CommandLine.run(new JWTC(), args);
    }

    /**
     * Function invoked by picocli to calculate the checksum of a file.
     *
     */
    @Override
    public void run() {
        log.info("Hello from JWTC call");
    }

}
