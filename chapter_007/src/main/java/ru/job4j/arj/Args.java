package ru.job4j.arj;

import javax.annotation.Nonnull;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Args
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Args {
    private final String[] argArr;

    public Args(String argStr) {
        argArr = argStr != null ? argStr.split("-") : new String[0];
    }

    public String directory() throws IllegalArgumentException {
        String result = getPart("d");
        if (!Files.isDirectory((Paths.get(result)))) {
            System.out.println("Wrong directory for zipping");
            throw new IllegalArgumentException();
        }
        return Objects.equals(result, "") ? "." : result;
    }

    public String exclude() {
        return Arrays.stream(argArr)
                .filter(x -> x.startsWith("e"))
                .map(x -> x.substring(1))
                .map(String::trim)
                .map(x -> x.split(" "))
                .flatMap(Arrays::stream)
                .map(x -> x.replace((CharSequence) ".", (CharSequence) "\\."))
                .map(x -> x.replace((CharSequence) "*", (CharSequence) ".*"))
//                .peek(System.out::println)
                .collect(Collectors.joining("|"));
    }

    public String output() {
        String result = getPart("o");
        result = Objects.equals(result, "")
                ? "tmp" + new Random(System.currentTimeMillis()).nextInt() + ".zip"
                : result;
        if (Files.isDirectory((Paths.get(result))) || result.endsWith("/")) {
            throw new IllegalArgumentException("Is a directory, zip filename wrong");
        }
        return result;
    }

    private String getPart(@Nonnull String part) {
        return Arrays.stream(argArr)
                .filter(x -> x.startsWith(part))
                .map(x -> x.substring(1))
                .map(String::trim)
//                .peek(System.out::println)
                .findFirst()
                .orElse("");
    }

}
