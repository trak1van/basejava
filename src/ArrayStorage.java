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

        boolean elementFound = false;
        for(int i=0;i<currentSize;i++){
            int k = i - 1;
            if(elementFound){
                storage[k] = storage[i];
            }
            if(storage[i].uuid == uuid && !elementFound){
                storage[i]= null;
                elementFound = true;
            }
        }
        if(elementFound) {
            currentSize--;
        }
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

        Resume[] fullStorage = new Resume[currentSize];
        for(int i =0;i<currentSize;i++){
            fullStorage[i] = storage[i];
        }
        return fullStorage;
    }

    int size() {
        return currentSize;
    }
}
