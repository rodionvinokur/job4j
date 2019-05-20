package ru.job4j.finder.opt;

import ru.job4j.finder.opt.except.NoSuchDirectoryException;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Class OptionDirectory
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */

public class OptionDirectory extends Option implements OptActions<Path>, ValidateOption {

    public OptionDirectory(String option) {
        super(option, "d");
    }

    @Override
    public Path apply() {
        try {
            validate(this.option);
            return Paths.get(option);
        } catch (InvalidPathException ex) {
            System.out.println("Illegal symbol at {" + option + "} path string.");
        } catch (NoSuchDirectoryException ex) {
            System.out.println("Path {" + option + "} not exist or not directory.");
        } catch (NullPointerException npe) {
            System.out.println("Path can't be NULL.");
        }
        return null;
    }

    @Override
    public void validate(String str) {
        if (!Files.isDirectory(Paths.get(str))) {
            throw new NoSuchDirectoryException("");
        }
    }
}
