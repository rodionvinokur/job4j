package ru.job4j.chat.dict;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Class Dictionary
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Dictionary implements IDict {
    private final Path pathToDictionary;
    private final int size;
    private final List<String> list;
    private final ArrayList<Integer> indexes = new ArrayList<>();
    private int counter;

    public Dictionary(Path pathToDictionary) throws IOException {
        this.pathToDictionary = pathToDictionary;
        if (!Files.exists(pathToDictionary)
                || Files.isDirectory(pathToDictionary)
                || !Files.isRegularFile(pathToDictionary)
                || !Files.isReadable(pathToDictionary)) {
            throw new IOException("Invalid dictionary, check path.");
        }
        list = Files
                .lines(pathToDictionary)
                .map(String::trim)
                .filter(x -> !"".equals(x))
                .collect(Collectors.toList());
        size = (int) list.size();
        if (size == 0) {
            throw new IOException("Invalid dictionary, check line filling.");
        }
        this.initIndexArrayList();
    }

    @Override
    public String readRandomLine() {
        Random random = new Random(System.currentTimeMillis());
        if (counter == 1) {
            initIndexArrayList();
        }
        int nextIndex = random.nextInt(counter - 1);
        String line = list.get(indexes.get(nextIndex));
        indexes.remove(nextIndex);
        counter--;
        return line;
    }

    private void initIndexArrayList() {
        for (int i = 0; i < size; i++) {
            indexes.add(i);
        }
        counter = size;
    }
}
