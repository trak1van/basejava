package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

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
            System.out.println("Resume: " + uuid + " not exist");
            return null;
        } else {
            return storage[i];
        }
    }

    protected abstract int getIndex(String uuid);
}
