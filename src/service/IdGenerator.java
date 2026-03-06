package service;

/**
 * static: generador de IDs simple.
 */
public class IdGenerator {
    private static int current = 100;

    public static int nextId() {
        current++;
        return current;
    }
}
