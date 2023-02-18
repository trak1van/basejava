package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage implements Storage{

    private static final int STORAGE_LIMIT = 10000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];

    private int count = 0;

    public void clear() {
        Arrays.fill(storage,  0, count, null);
        count = 0;
    }

    public void save(Resume r) {
        int i = getIndex(r.getUuid());
        if (i != -1) {
            System.out.println("Resume: " + r.getUuid() + " already exist");
        } else if (count >= storage.length) {
            System.out.println("Storage overflow");
        } else {
            storage[count] = r;
            count++;
        }
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

    public void delete(String uuid) {
        int i = getIndex(uuid);
        if (i == -1) {
            System.out.println("Resume: " + uuid + " not exist");
        } else {
            storage[i] = storage[count - 1];
            storage[count - 1] = null;
            count--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, count);
    }

    public int size() {
        return count;
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < count; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    public void update(Resume resume) {
        int i = getIndex(resume.getUuid());
        if (i == -1) {
            System.out.println("Resume: " + resume.getUuid() + " not exist");
        } else {
            storage[i] = resume;
        }
    }
}
