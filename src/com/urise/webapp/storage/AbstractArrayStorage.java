package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstactStorage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int count = 0;

    public int size() {
        return count;
    }

    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, count);
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        storage[(Integer) searchKey] = r;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return (Integer) searchKey >= 0;
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        if (count >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            insertElement((Integer) searchKey, r);
            count++;
        }
    }

    @Override
    protected void doDelete(Object searchKey) {
        fillDeteleElement((Integer) searchKey);
        storage[count - 1] = null;
        count--;
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storage[((Integer) searchKey)];
    }

    //protected abstract int getIndex(String uuid);
    protected abstract Integer getSearchKey(String uuid);

    protected abstract void fillDeteleElement(int index);

    protected abstract void insertElement(int index, Resume r);
}
