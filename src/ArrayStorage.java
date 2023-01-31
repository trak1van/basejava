/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    private int currentSize = 0;
    void clear() {
        currentSize = 0;
    }

    void save(Resume r) {
        currentSize++;
    }

    Resume get(String uuid) {
        return null;
    }

    void delete(String uuid) {
        currentSize--;
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return new Resume[0];
    }

    int size() {
        return currentSize;
    }
}
