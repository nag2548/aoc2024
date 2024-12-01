package de.zimtix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.fail;

public interface FileInputTest {
    default List<String> readLines(String path) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(requireNonNull(getClass().getClassLoader().getResourceAsStream(path))))) {
            return reader.lines().toList();
        } catch (Exception e) {
            fail("Could not read input file " + path, e);
            return null;
        }
    }
}
