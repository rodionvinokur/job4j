package ru.job4j.finder.opt;

import ru.job4j.finder.opt.except.FileAccessErrorException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Class OptionJournal
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */

public class OptionJournal extends Option implements OptActions<PrintWriter>, ValidateOption {

    public OptionJournal(String option) {
        super(option, "o");
    }

    @Override
    public PrintWriter apply() {
        try {
            validate(this.option);
            try {
                return new PrintWriter(
                        new OutputStreamWriter(
                                (new FileOutputStream(this.option)), StandardCharsets.UTF_8), true);
            } catch (FileNotFoundException e) {
                System.out.println("Journal {" + this.option + "} file not found.");
            }
        } catch (FileAccessErrorException ie) {
            System.out.println(ie.getMessage());
        }
        return null;
    }

    @Override
    public void validate(String str) {
        Path path = Paths.get(str);

        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new FileAccessErrorException("Journal {" + path.toString() + "} can't be create.");
            }
            return;
        }

        if (Files.isDirectory(path)) {
            throw new FileAccessErrorException("File name {" + path.toString() + "} is directory.");
        } else if (!(Files.isRegularFile(path) && Files.isWritable(path))) {
            throw new FileAccessErrorException("Journal {" + path.toString() + "} can't be write.");
        }
    }
}
