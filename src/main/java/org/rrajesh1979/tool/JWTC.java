package org.rrajesh1979.tool;

import java.util.concurrent.Callable;

import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Help.Ansi.Style;
import picocli.CommandLine.Help.ColorScheme;
import picocli.CommandLine.HelpCommand;

/**
 * @author rrajesh1979
 * @version 0.0.1
 * @since 2021-Jan-08
 */

@Command(name = "jwtc", mixinStandardHelpOptions = true, version = "jwtc 0.0.1", description = "Encode and decode JWT tokens.", subcommands = {
        HelpCommand.class, JWTCEncode.class, JWTCDecode.class
})
@Slf4j
public class JWTC implements Callable<Integer> {
    /**
     * Main function to invoke the picocli framework.
     *
     * @param args the command line arguments.
     *             The first argument is the file whose checksum to calculate.
     *             The second argument is the algorithm to use.
     *             The default algorithm is MD5.
     */
    public static void main(String[] args) {
        log.info("Hello from JWTC main");
        int exitCode = new CommandLine(new JWTC())
                .setColorScheme(JWTC.getColorScheme())
                .execute(args);
        System.exit(exitCode);
    }

    /**
     * Function invoked by picocli to compute JWT.
     *
     */
    @Override
    public Integer call() {
        log.info("Hello from JWTC call");
        return 0;
    }

    public static CommandLine.Help.ColorScheme getColorScheme() {
        // see also CommandLine.Help.defaultColorScheme()
        ColorScheme colorScheme = new ColorScheme.Builder()
                .commands(Style.bold, Style.underline) // combine multiple styles
                .options(Style.fg_yellow) // yellow foreground color
                .parameters(Style.fg_yellow)
                .optionParams(Style.italic)
                .errors(Style.fg_red, Style.bold)
                .stackTraces(Style.italic)
                .build();
        return colorScheme;
    }

}
