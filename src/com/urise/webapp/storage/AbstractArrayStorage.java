package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int count = 0;

    public int size() {
        return count;
    }

    public Resume get(String uuid) {
        int i = getIndex(uuid);
        if (i == -1) {
            throw new NotExistStorageException(uuid);
        } else {
            return storage[i];
        }
    }

    public void clear() {
        Arrays.fill(storage,  0, count, null);
        count = 0;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, count);
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(r.getUuid());
        }else{
            storage[index] = r;
        }
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            System.out.println("Resume:" + r.getUuid() + " already exsits");
        } else {
            if (count >= STORAGE_LIMIT) {
                throw new StorageException("Storage overflow", r.getUuid());
            } else {
                insertElement(index, r);
                count++;
            }
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            fillDeteleElement(index);
            storage[count - 1] = null;
            count--;
        }
    }

    protected abstract int getIndex(String uuid);

    protected abstract void fillDeteleElement(int index);

    protected abstract void insertElement(int index, Resume r);
}
