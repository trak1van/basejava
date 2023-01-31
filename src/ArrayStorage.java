/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    private int currentSize = 0;
    void clear() {
        for(int i =0; i<currentSize;i++){
            storage[i] = null;
        }
        currentSize = 0;
    }

    void save(Resume r) {
        storage[currentSize] = r;
        currentSize++;
    }

    Resume get(String uuid) {
        for(int i=0;i<currentSize;i++){
            if(storage[i].uuid == uuid){
                return storage[i];
            }
        }
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
